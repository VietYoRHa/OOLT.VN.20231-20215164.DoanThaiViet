package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

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

//    @Override
//    public Object play(){
//        System.out.println("Playing track: " + this.title);
//        System.out.println("Track length: " + this.length + " seconds");
//        return null;
//    }

    @Override
    public String play() throws PlayerException {
        if (this.getLength() > 0) {
            StringBuilder info = new StringBuilder();
            info.append("Playing track: ").append(this.title).append("\n");
            info.append("Track length: ").append(this.length).append(" seconds");
            return info.toString();
        } else {
            throw new PlayerException("ERROR: Track length is non-positive!");
        }
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
