package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();
    private ObservableList<Media> items = FXCollections.observableArrayList();

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

    public ObservableList<Media> searchInStore(String title){
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
