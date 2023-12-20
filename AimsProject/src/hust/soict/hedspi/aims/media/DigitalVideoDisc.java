package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.screen.manager.PlayerDialog;

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

//    @Override
//    public void play(){
//        System.out.println("Playing DVD: " + this.getTitle());
//        System.out.println("Director: " + this.director);
//        System.out.println("DVD length: " + this.getLength() + " minutes");
//    }

    @Override
    public Object play() throws PlayerException {
        if(this.getLength() > 0) {
            StringBuilder info = new StringBuilder();
            info.append("Playing DVD: ").append(this.getTitle()).append("\n");
            info.append("Director: ").append(this.director).append("\n");
            info.append("Length: ").append(this.getLength()).append(" minutes\n");
            info.append("Category: ").append(this.getCategory()).append("\n");

            PlayerDialog dialog = new PlayerDialog(null, "DVD Player", true);
            dialog.showInfo(info.toString());
            return null;
        } else {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }
}
