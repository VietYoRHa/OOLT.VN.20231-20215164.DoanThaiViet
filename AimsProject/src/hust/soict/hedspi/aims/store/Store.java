package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();
    private ArrayList<Media> items = new ArrayList<>();

    public void addMedia(Media item){
        itemsInStore.add(item);
    }

    public void removeMedia (Media item){
        itemsInStore.remove(item);
    }

    public void print(){
        for (Media item : itemsInStore){
            System.out.println(item.toString());
        }
    }

    public ArrayList<Media> searchInStore(String title){
        items.clear();
        for (Media media : itemsInStore){
            if (media.isMatch(title)) items.add(media);
        }
        return items;
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}
