import java.nio.file.Path;
import java.io.File;
import java.nio.file.*;
import java.util.Map;
import java.util.Queue;
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
        for (File a: filesList) {
            String b = a.getName();
            edition.put(b, n);
        }

    }

    public List<Book> print(String ID) {

    }

    public List<String> getCatalogue() {

    }

    public List<Book> request(String ID, int n) {

    }

}