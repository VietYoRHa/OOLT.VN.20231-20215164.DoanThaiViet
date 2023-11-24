package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc{

    public DigitalVideoDisc(int id, String title) {
        super(id, title);
    }
    public DigitalVideoDisc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }
    public DigitalVideoDisc(int id, String title, String category, float cost, int length) {
        super(id, title, category, cost, length);
    }
    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost, length, director);
    }

    @Override
    public String toString(){
        return this.getId() + ". DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + "$";
    }

    public boolean isMatch (int id){
        return this.getId() == id;
    }

    public boolean isMatch (String title){
        return this.getTitle() != null && this.getTitle().equalsIgnoreCase(title);
    }
}
