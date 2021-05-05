
import java.io.File;
import java.nio.file.*;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.regex.*;
import java.io.IOException;
import java.util.List;



public class Press {

    private int booksPerEdition;
    private Map<String, Integer> edition;
    private Map<String, Queue<Book>> shelf;
    private String path; 
    private Map<String, String> bookInfo;
    private String[] bookPath;
    private int bookEdition;

    public Press(String p, int n) throws IOException {
        booksPerEdition = n;
        path = p;
        File directoryPath = new File(p);
        bookPath = directoryPath.list();
        
        Map<String, Integer> edition = new HashMap<String, Integer>();
        Map<String, Queue<Book>> shelf = new HashMap<>();
        bookEdition = 1;

        for (String a : bookPath) {
            edition.put(a, bookEdition);
            Scanner scanner = new Scanner(a);
            boolean flag = false; 
            boolean found = false;
            
            String title;
            String author;
            String content = "";
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
            
                if (line.contains("Title:")) {
                    title = line.substring(7);
                    found = true;
                    bookInfo.put("Title", title);
                
                } if (line.contains("Author:")) {
                    author = line.substring(8);
                    bookInfo.put("Author", author);
                
                } if (line.contains("*** START")) {
                    flag = true;
                
                } if (flag) {
                    content += line;
                    bookInfo.put("Content", content); 
                }  
            } 
            if (!found) {
                throw new IOException();
            }
            LinkedList<Book> linkedList = new LinkedList<>();
            
            try {
            
                linkedList.addAll(print(a));
                shelf.put(a, linkedList);
            
            } catch (IllegalAccessException error) {
                throw error;
            }    
        }
    }         

    public List<Book> print(String ID) throws IllegalAccessException {

        List<Book> bookList = new ArrayList<Book>();
        File f = new File(path);
        String[] pathname = f.list();
        
        for (String a: pathname) {
            boolean found = false;
            int i = 0;
            if (ID == a) {
                found = true;
            } else {
                throw new IllegalAccessException();
            }
            if (found) {
                while (i < booksPerEdition) {
                    bookList.add(new Book(bookInfo.get("Title"), bookInfo.get("Author"), bookInfo.get("Content"), bookEdition));
                    i++;
                }
            }
        }    
        return bookList;
    }

    public List<String> getCatalogue() {

       List<String> catalogue = new ArrayList<String>();
       for (String key: shelf.keySet()) {
          catalogue.add(key);
        }
       return catalogue;
       }

 /*   public List<Book> request(String ID, int n) {
        
        
        
        if (!(edition.containsKey(ID))) {
            IllegalAccessException error = new IllegalAccessException();
            throw error;
        } 
    }
*/
}    

