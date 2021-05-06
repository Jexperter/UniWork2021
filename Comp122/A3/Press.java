

import java.io.BufferedReader;
import java.io.*;
import java.io.File;
import java.nio.file.*;
import java.util.Map;
import java.util.Queue;
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
    private String title;
    private String author;
    private String content;
    private File bookPath[];
    private int bookEdition = 1;

    
    public Press(String p, int n) throws IOException {
        //Constructor to assigment p to path and n to bookperedition
        booksPerEdition = n;
        path = p;
        
        //creates a file array for all the file names
        File directoryPath = new File(path);
        bookPath = directoryPath.listFiles();
        
        
        Map<String, Integer> edition = new HashMap<String, Integer>();
        Map<String, Queue<Book>> shelf = new HashMap<>();
        

        for (File a : bookPath) {
            
            edition.put(a.getName(), bookEdition);
            String line;
            boolean flag, found;
            String content;
                 
            try(BufferedReader br = new BufferedReader(new FileReader(a))) {
             flag = false;  
             found = false;
             content = "";
            
                while ((line = br.readLine()) != null) {
                
                    if (line.contains("Title:")) {
                        title = line.substring(7);
                        found = true;
                 
                    } if (line.contains("Author:")) {
                        author = line.substring(8);
                    
                    } if (line.contains("*** START")) {
                        flag = true;
                    
                    } if (flag==true) {
                        content += line;
                    } if (found==false) {
                        throw new IOException();
                    }
                }    
            } catch (IOException ah) {
                throw new IOException();
            }
            shelf.put(a.getName(), (Queue)print(a.getName()));
            if (booksPerEdition == 0) {
            print(a.getName());
            booksPerEdition = n;    
            }                         
        }    
    }    
    private List<Book> print(String ID) {

        List<Book> bookList = new ArrayList<Book>();
        for (File a: bookPath) {
            int i = 0;
            boolean found = false;

            if (ID == a.getName()) {
                found = true;
            }
            if (found) {
                for (i = 0; i < booksPerEdition; i++) {
                    bookList.add(new Book(title, author, content, edition.get(a.getName())));
                }
                bookEdition++;
            } if (!found) {
                throw new IllegalArgumentException();
            }   
        }  
        return bookList;
    }

    public List<String> getCatalogue() {

       List<String> catalogue = new ArrayList<String>();
       for (String key: edition.keySet()) {
          catalogue.add(key);
        }
       return catalogue;
       }

  /*  public List<Book> request(String ID, int n) {
        
        
        
        if (!(edition.containsKey(ID))) {
            IllegalAccessException error = new IllegalAccessException();
            throw error;
        } 
    }
*/
}    

