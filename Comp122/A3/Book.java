

public class Book {

    private String title;
    private String author;
    private String content; 
    private int edition;

    public Book(String a, String b, String c, int e) {
        title = a;
        author = b;
        content = c;
        edition = e;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public int getEdition() {
        return edition;
    }

    public int getPages() {
       return (content.length() / 800);
    }
    
    public String toString() {
        String str = String.format("Title: %s\n Author: %s\n Edition: %2d\n Pages: %2d", title, author, edition, getPages());
        return str; 
    }





}    
