package hust.soict.hedspi.aims.media;

public class Track implements Playable{
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play(){
        System.out.println("Playing track: " + this.title);
        System.out.println("Track length: " + this.length + " seconds");
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Track otherTrack = (Track) obj;
        return title != null ? title.equals(otherTrack.title) : otherTrack.title == null && length == otherTrack.length;
    }
}
