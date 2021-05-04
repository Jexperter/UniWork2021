
import java.nio.file.Path;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.*;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.*;



public class Press {

    private int booksPerEdition;
    private HashMap<String, Integer> edition;
    private Map<String, Queue<Book>> shelf;

    public Press(String p, int n) {
        booksPerEdition = n;
        File directoryPath = new File("p");
        File filesList[] = directoryPath.listFiles();
        
        HashMap<String, Integer> edition = new HashMap<String, Integer>();
        for (File a: filesList) {
            edition.put(a.getName(), n);
        }        
            
            

        //    Pattern patternC = Pattern.compile("", Pattern.CASE_INSENSITIVE);
        //    Matcher matcherC = patternC.matcher(input);
        //    String Content = matcherC.toString();

        //    Pattern patternD = Pattern.compile("Author", Pattern.CASE_INSENSITIVE);
        //    Matcher matcherA = patternA.matcher(input);
        //   String Author = matcherA.toString();


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
