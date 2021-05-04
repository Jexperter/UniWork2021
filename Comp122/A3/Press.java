
import java.nio.file.Path;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.*;



public class Press {

    private int booksPerEdition;
    private HashMap<String, Integer> edition;
    private Map<String, Queue<Book>> shelf;

    public Press(String p, int n) throws IOException {
        booksPerEdition = n;
        File directoryPath = new File("p");
        File filesList[] = directoryPath.listFiles();
        
        HashMap<String, Integer> edition = new HashMap<String, Integer>();
        for (File a: filesList) {
            edition.put(a.getName(), n);
        }        
            
        HashMap<String, LinkedList<Book>> shelf = new HashMap<String, LinkedList<Book>>();


        for (int i = 0; i < filesList.length; i++) {
            File file = filesList[i];
            String author;
            String title;
            String content;
            String all;

            all = Files.readString(file.toPath());
            Pattern patternT = Pattern.compile("Title: (.*)");
            Matcher matcherT = patternT.matcher(all);
            title = matcherT.group(1);

            Pattern patternA = Pattern.compile("Author: (.*)");
            Matcher matcherA = patternA.matcher(all);
            author = matcherA.group(1);

            Pattern patternC = Pattern.compile("(?<=(.\s/*/*/*)(?s)(.*$))");
            Matcher matcherC = patternC.matcher(all);
            content = matcherC.group(1);

            LinkedList<Book> books = new LinkedList<Book>();
            books.add(new Book(title, author, content, i++));
            
            
        }   
    }   

    //}

   // public List<Book> print(String ID) {

   // }

   // public List<String> getCatalogue() {

  //  }

   // public List<Book> request(String ID, int n) {

  //  }

}
