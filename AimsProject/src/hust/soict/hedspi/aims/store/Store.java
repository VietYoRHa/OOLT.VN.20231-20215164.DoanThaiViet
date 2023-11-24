package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<DigitalVideoDisc> itemsInStore = new ArrayList<>();

    public void addDVD (DigitalVideoDisc disc){
        itemsInStore.add(disc);
    }

    public void removeDVD (DigitalVideoDisc disc){
        itemsInStore.remove(disc);
    }

    public void print(){
        for (DigitalVideoDisc disc : itemsInStore){
            System.out.println(disc.toString());
        }
    }
}
