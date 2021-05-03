import java.nio.file.Path;
import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.*;
import java.util.Map;
import java.util.Queue;
import java.util.ArrayList;
import java.util.regex.*;


public class Press {

    private int booksPerEdition;
    private Map<String, Integer> edition;
    private Map<String, Queue<Book>> shelf;

    public Press(String p, int n) {
        booksPerEdition = n;
        edition.put(p, booksPerEdition);
        File file = new File("p");
        File[] matchingFiles = file.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith("txt");
            }
        });
    }

    public List<Book> print(String ID) {

    }

    public List<String> getCatalogue() {

    }

    public List<Book> request(String ID, int n) {

    }

}
