package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
    private String director;

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
        super(title, category, cost, length);
        this.director = director;
    }

    @Override
    public String toString(){
        return this.getId() + ". DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.director + " - " + this.getLength() + ": " + this.getCost() + "$";
    }

    @Override
    public void play(){
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("Director: " + this.director);
        System.out.println("DVD length: " + this.getLength() + " minutes");
    }
}
