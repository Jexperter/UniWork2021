
import java.awt.print.Book;
import java.io.File;
import java.nio.file.*;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.regex.*;
import java.io.IOException;
import java.util.List;



public class Press {

    private int booksPerEdition;
    private Map<String, Integer> edition;
    private Map<String, Queue<Book>> shelf;
    private LinkedList<Book> books;
    private int editionBook = 1;
    private String path; 


    public Press(String p, int n) throws IOException {
        booksPerEdition = n;
        path = p;
        File directoryPath = new File(path);
        File filesList[] = directoryPath.listFiles();
        
        HashMap<String, Integer> edition = new HashMap<String, Integer>();
        HashMap<String, LinkedList<Book>> shelf = new HashMap<String, LinkedList<Book>>();

        for (File a: filesList) {
            edition.put(a.getName(), editionBook);
            Scanner scanner = new Scanner(new File(a));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String title;
                String author;
                String content;

                if (line.contains("Title:")) {
                    title = line.split((" ?<=Title: ) ");
                } else if (line.contains("Author:")) {
                    author = line.split();
                } else if (line.contains("START OF THE PROJECT")) {
                    content = line.split();
                }

            }
        
        
        }     
    }      

    public List<Book> print(String ID) {

        List<Book> bookList = new ArrayList<Book>();


        return bookList;
    }

   // public List<String> getCatalogue() {

  //  }

   // public List<Book> request(String ID, int n) {

  //  }

}
