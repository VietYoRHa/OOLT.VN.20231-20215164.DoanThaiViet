package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        //Create a new cart
        Cart anOrder = new Cart();

        //Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Turbo", "Animation", "David Soren", 96, 12.29f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Kung Fu Panda", "Animation", "John Stevenson", 92, 14.99f);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Rurouni Kenshin", "Action", "Keishi Otomo", 134, 29.23f);

        DigitalVideoDisc dvdList[] = new DigitalVideoDisc[2];
        dvdList[0] = dvd4;
        dvdList[1] = dvd5;

        anOrder.addDigitalVideoDisc(dvd1, dvd2, dvd3);
        anOrder.addDigitalVideoDisc(dvdList);

        anOrder.displayCart();

        anOrder.removeDigitalVideoDisc(dvd2);
        anOrder.removeDigitalVideoDisc(dvd6);

        anOrder.displayCart();
    }
}
