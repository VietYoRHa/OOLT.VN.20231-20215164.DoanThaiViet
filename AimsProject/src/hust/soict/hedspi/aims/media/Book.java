package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private int id;
    private String title;
    private String category;
    private float cost;
    private List<String> authors = new ArrayList<String>();
    private static int nbBooks = 0;

    public Book(String title) {
        this.title = title;
        nbBooks++;
        this.id = nbBooks;
    }

    public Book(String title, String category, float cost) {
        this(title);
        this.category = category;
        this.cost = cost;
    }

    public Book(String title, String category, float cost, List<String> authors) {
        this(title, category, cost);
        this.authors = authors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
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
