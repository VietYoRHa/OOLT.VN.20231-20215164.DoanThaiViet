package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{

    public DigitalVideoDisc(String title) {
        super(title);
    }
    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
    }
    public DigitalVideoDisc(String title, String category, float cost, int length) {
        super(title, category, cost, length);
    }
    public DigitalVideoDisc(String title, String category, float cost, int length, String director) {
        super(title, category, cost, length, director);
    }

    @Override
    public String toString(){
        return this.getId() + ". DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + "$";
    }

    @Override
    public void play(){
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("Director: " + this.getDirector());
        System.out.println("DVD length: " + this.getLength() + " minutes");
    }
}
