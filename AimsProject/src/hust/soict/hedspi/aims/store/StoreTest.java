package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
        //Create a store
        Store aStore = new Store();

        //Create new dvd objects and add them to the store
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Turbo", "Animation", "David Soren", 96, 12.29f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Kung Fu Panda", "Animation", "John Stevenson", 92, 14.99f);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Rurouni Kenshin", "Action", "Keishi Otomo", 134, 29.23f);

        //Add DVDs to store
        aStore.addDVD(dvd1);
        aStore.addDVD(dvd2);
        aStore.addDVD(dvd3);
        aStore.addDVD(dvd4);
        aStore.addDVD(dvd5);
        aStore.addDVD(dvd6);

        //Show store items
        aStore.print();
        System.out.print("\n");

        //Remove DVDs from store
        aStore.removeDVD(dvd1);
        aStore.removeDVD(dvd3);
        aStore.removeDVD(dvd5);

        //Show store items
        aStore.print();
    }
}
