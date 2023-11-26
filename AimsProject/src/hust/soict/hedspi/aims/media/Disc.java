package hust.soict.hedspi.aims.media;

public class Disc extends Media{
    private int length;

    public Disc(String title) {
        super(title);
    }

    public Disc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Disc(String title, String category, float cost, int length) {
        super(title, category, cost);
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}
