package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public Book(String title) {
        super(title);
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Book(String title, String category, float cost, String... authors) {
        super(title, category, cost);
        this.authors.addAll(Arrays.asList(authors));
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

    @Override
    public String toString(){
        return this.getId() + ". Book - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getCost() + " - " + this.authors;
    }
}
