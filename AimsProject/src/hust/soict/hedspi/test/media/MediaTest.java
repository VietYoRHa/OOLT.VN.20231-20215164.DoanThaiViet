package hust.soict.hedspi.test.media;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class MediaTest {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();

        DigitalVideoDisc dvd = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        CompactDisc cd = new CompactDisc("Rurouni Kenshin Original Soundtrack", "Live Action", 20f, "Naoki Sato");
        Book book = new Book("The Exorcist", "Novel", 21.68f, "William Peter Blatty");

        mediae.add(dvd);
        mediae.add(cd);
        mediae.add(book);

        for (Media m : mediae){
            System.out.println(m.toString());
        }
    }
}
