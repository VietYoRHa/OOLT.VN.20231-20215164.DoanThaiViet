package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
        //Create a store
        Store aStore = new Store();

        //Create new dvd objects and add them to the store
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95f, 87, "Roger Allers");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95f, 87, "George Lucas");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Turbo", "Animation", 12.29f, 96, "David Soren");
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Kung Fu Panda", "Animation", 14.99f, 92, "John Stevenson");
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Rurouni Kenshin", "Action", 29.23f, 134, "Keishi Otomo");

        //Add DVDs to store
        aStore.addMedia(dvd1);
        aStore.addMedia(dvd2);
        aStore.addMedia(dvd3);
        aStore.addMedia(dvd4);
        aStore.addMedia(dvd5);
        aStore.addMedia(dvd6);


        //Show store items
        aStore.print();
        System.out.print("\n");

        //Remove DVDs from store
        aStore.removeMedia(dvd1);
        aStore.removeMedia(dvd3);
        aStore.removeMedia(dvd5);

        //Show store items
        aStore.print();
    }
}
