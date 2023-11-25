package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        //Create a new cart
        Cart cart = new Cart();

        //Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95f, 87, "Roger Allers");
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95f, 87, "George Lucas");
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addMedia(dvd3);

        CompactDisc cd1 = new CompactDisc("Rurouni Kenshin Original Soundtrack", "Live Action", 20f, "Naoki Sato");
        cart.addMedia(cd1);

        Book book1 = new Book("The Exorcist", "Novel", 21.68f, "William Peter Blatty");
        cart.addMedia(book1);

        //Test the print method
        cart.print();
        System.out.println();

        //Test the search method
        cart.serachByID(1);
        cart.serachByID(6);
        cart.serachByTitle("star wars");
        cart.serachByTitle("morbius");
        cart.serachByTitle("rurouni kenshin original soundtrack");
        cart.serachByTitle("the exorcist");
    }
}
