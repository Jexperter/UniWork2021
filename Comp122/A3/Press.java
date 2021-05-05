

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
import java.io.PrintStream;
import java.util.List;



public class Press {

    private int booksPerEdition;
    private Map<String, Integer> edition;
    private Map<String, Queue<Book>> shelf;
    private LinkedList<Book> books;
    private int editionBook = 1;
    private String path; 
    private String author;
    private String title;
    private String content;


    public Press(String p, int n) throws IOException {
        booksPerEdition = n;
        path = p;
        File directoryPath = new File(path);
        String[] filesList = directoryPath.list();
        
        Map<String, Integer> edition = new HashMap<String, Integer>();
        Map<String, Queue<Book>> shelf = new HashMap<>();

        for (String a: filesList) {
            edition.put(a, editionBook);
            Scanner scanner = new Scanner(a);
            boolean flag = false; 
            boolean found = false;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
            
                if (line.contains("Title:")) {
                    title = line.substring(7);
                    found = true;
                } if (line.contains("Author:")) {
                    author = line.substring(8);
                } if (line.contains("*** START")) {
                    flag = true;
                } if (flag) {
                    content += line;
                } if (!found) {
                    throw new IOException();
                }
            }
            print(a);
            shelf.put(a,(LinkedList) books);
    }
    
    }         

    public List<Book> print(String ID) {

        
        List<Book> bookList = new ArrayList<Book>();
        File f = new File("/home/jash2002/uniWork/gitBackup/Comp122/A3/books");
        String[] pathname = f.list();
        for(int i = 0; i < booksPerEdition; i++) {
            if (ID == pathname[i]) {
                bookList.add(new Book(title, author, content, editionBook));
            }    
        }    
        return bookList;
    }

    public List<String> getCatalogue() {

        List<String> catalogue = new ArrayList<String>();
        for (String key : edition.keySet()) {
            catalogue.add(key);
        }
        return catalogue;
   }

  //  public List<Book> request(String ID, int n) {
        
        
        
  //      if (!(edition.containsKey(ID))) {
  //          IllegalAccessException error = new IllegalAccessException();
   //         throw error;
  //      } 
    }

