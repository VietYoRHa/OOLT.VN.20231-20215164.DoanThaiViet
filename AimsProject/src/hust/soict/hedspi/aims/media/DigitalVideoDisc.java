package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Media{
    private String director;
    private int length;

    public String getDirector() {
        return director;
    }
    public int getLength() {
        return length;
    }

    public DigitalVideoDisc(String title) {
        super();
        setTitle(title);
    }
    public DigitalVideoDisc(String title, String category, float cost) {
        this(title);
        setCategory(category);
        setCost(cost);
    }
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this(title, category, cost);
        this.director = director;
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this(title, category, director, cost);
        this.length = length;
    }

    @Override
    public String toString(){
        return this.getId() + ". DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.director + " - " + this.length + ": " + this.getCost() + "$";
    }

    public boolean isMatch (int id){
        return this.getId() == id;
    }

    public boolean isMatch (String title){
        return this.getTitle() != null && this.getTitle().equalsIgnoreCase(title);
    }
}
