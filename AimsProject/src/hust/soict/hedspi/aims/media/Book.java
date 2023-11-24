package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public Book(String title) {
        super();
        setTitle(title);
    }

    public Book(String title, String category, float cost) {
        this(title);
        setCategory(category);
        setCost(cost);
    }

    public Book(String title, String category, float cost, List<String> authors) {
        this(title, category, cost);
        this.authors = authors;
    }

    public void addAuthor(String authorName){
        if (!authors.contains(authorName)){
            authors.add(authorName);
            System.out.println("Add success !");
        } else System.out.println("Author already exists !");
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Remove success !");
        } else System.out.println("Author not found !");
    }
}
