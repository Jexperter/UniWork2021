import java.io.*;
import java.nio.file.*;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.regex.*;
import java.util.List;

/**
 * This class sets up the press object which creates a list of books which is then transfered to the vending machine. There are 3 methods and 1 constructor 
 */

public class Press {

    private String path;
    private int booksPerEdition;
    private Map<String, Integer> edition;
    private Map<String, Queue<Book>> shelf;
    private int bookEdition = 1;
    private Map<String, String> bookInfo;
    private File filesList[]; 
    private String title;
    private String author;
    private String content;

    /**
     * This constructor sets up the shelf, by using the print method below. 
     * @param p, this is tha path for the files
     * @param n, this is the number of books which is avalable per edition 
     */

    public Press(String p, int n) throws FileNotFoundException {
        booksPerEdition = n;
        path = p;

        edition = new HashMap<String, Integer>();
        shelf = new HashMap<>();

        //Create a file[] containing all files inside the directory 
        File directoryPath = new File(p);
        File filesList[] = directoryPath.listFiles();
        

        //Iterate through each file and retrive the sections 
        for (File a : filesList) {
            
            content = null;
            String line;
            Scanner scan = new Scanner(a);
            boolean found, flag;
            found = false;
            flag = false;

            while (scan.hasNextLine()) {
                line = scan.nextLine();

                if (line.contains("Title:")) {
                    title = line.substring(7);
                    flag = true;
                    
                } 
                if (line.contains("Author")) {
                    author = line.substring(8);
                    
                }
                if (line.contains("*** START")) {
                    found = true;
        
                }
                if (found) {
                    content = content + " " + line;
                }       
            }
            content = content.substring(51 + title.length());
            edition.put(a.getName(), bookEdition);
            shelf.put(a.getName(), (LinkedList) print(a.getName()));
        }    
    }

    /**
     * 
     * @param ID, this is the file which we will be searching for 
     * @return , a list of books which corespond with the string ID
     * @throws IllegalArgumentException
     */

    private List<Book> print(String ID) throws IllegalArgumentException {
        
        List<Book> bookList = new LinkedList<>();
        
        boolean found;
        found = true;
        int i;
        File directoryPath = new File(path);
        File filesList[] = directoryPath.listFiles();
        

        for(File a : filesList) {
            if (a.getName() == ID) {
                found = true;
            }
            if (!found) {
                throw new IllegalArgumentException();
            } if (found) {
                for (i = 0 ; i < booksPerEdition; i++) { 
                    bookList.add(new Book(title, author, content, bookEdition));
                }           
            }    
       } 
        return bookList;
    }

    /**
     * This returns a list of books the press can print
     * @return, a list of books which is available from the shelf
     */
    public List<String> getCatalogue() {

       List<String> catalogue = new ArrayList<String>();
       for (String key: edition.keySet()) {
          catalogue.add(key);
        }
      return catalogue;
    }

    /**
     * This class implement a check-out service which allows the user to print a number of books.
     * @param ID, the string which the user wants, namely the file in the directory
     * @param n, the number of copies they want from the shelf
     * @return a list of the books which they want
     * @throws IllegalArgumentException
     */
    public List<Book> request(String ID, int n) throws IllegalArgumentException {
        
        int i;
        List<Book>books = new LinkedList<>();        
        for (i = 0; i < n; i++) {
            books.add(new Book(title, author, content, bookEdition));
        }
        if (booksPerEdition - n <= 0) {
            bookEdition++;
            shelf.put(ID, (LinkedList) print(ID));
        }
        
        if (!(edition.containsKey(ID))) {
            throw new IllegalArgumentException();
        } 

        return books;
    }

}    

