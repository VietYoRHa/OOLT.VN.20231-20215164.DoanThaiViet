package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.screen.manager.PlayerDialog;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    public CompactDisc(String title) {
        super(title);
    }
    public CompactDisc(String title, String category, float cost, String artist) {
        super(title, category, cost);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track){
        if (!tracks.contains(track)){
            tracks.add(track);
            System.out.println("Add success !");
        } else System.out.println("Track already in the list of tracks !");
    }

    public void removeTrack(Track track){
        if (tracks.contains(track)){
            tracks.remove(track);
            System.out.println("Remove success !");
        } else System.out.println("Track not exist in the list of tracks !");
    }

    @Override
    public int getLength(){
        int totalLength = 0;
        for (Track track : tracks){
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public String toString(){
        return this.getId() + ". CD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getArtist() + " - " + this.getLength() + ": " + this.getCost() + "$";
    }

//    @Override
//    public void play(){
//        System.out.println("Playing CD: " + this.getTitle());
//        System.out.println("Director: " + this.artist);
//        System.out.println("Total length: " + this.getLength() + " seconds");
//        for (Track track : tracks){
//            track.play();
//        }
//    }

    @Override
    public Object play() throws PlayerException {
        if (this.getLength() > 0) {
            StringBuilder info = new StringBuilder();
            info.append("Playing CD: ").append(this.getTitle()).append("\n");
            info.append("Director: ").append(this.artist).append("\n");
            info.append("Total length: ").append(this.getLength()).append(" seconds\n");
            info.append("---------------------------------------------\n");

            for (Track track : tracks) {
                info.append(track.play()).append("\n");
            }

            PlayerDialog dialog = new PlayerDialog(null, "CD Player", true);
            dialog.showInfo(info.toString());

            java.util.Iterator iter = tracks.iterator();
            Track nextTrack;
            while(iter.hasNext()){
                nextTrack = (Track) iter.next();
                try{
                    nextTrack.play();
                } catch (PlayerException e){
                    throw e;
                }
            }

            return null;
        } else {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }
}
