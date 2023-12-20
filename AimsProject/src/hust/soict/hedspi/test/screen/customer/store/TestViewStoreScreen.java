package hust.soict.hedspi.test.screen.customer.store;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
    private static Store store;
    private static Cart cart = new Cart();

    @Override
    public void start(Stage primaryStage) throws Exception{
        final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store, cart);
        fxmlLoader.setController(viewStoreController);
        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();

        //Create Media objects
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95f, 87, "Roger Allers");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95f, 87, "George Lucas");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Turbo", "Animation", 12.29f, 96, "David Soren");
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Kung Fu Panda", "Animation", 14.99f, 92, "John Stevenson");
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Rurouni Kenshin: The Beginning", "Action", 29.23f, 134, "Keishi Otomo");
        DigitalVideoDisc dvd7 = new DigitalVideoDisc("The Exorcist", "Horror", 35f, 122, "William Friedkin");
        CompactDisc cd1 = new CompactDisc("Rurouni Kenshin Original Soundtrack", "Live Action", 28f, "Naoki Sato");
        Book book1 = new Book("The Exorcist", "Novel", 21.68f, "William Peter Blatty");

        //Create Tracks
        Track track1 = new Track("Hiten", 303);
        Track track2 = new Track("Korosazu", 350);
        Track track3 = new Track("Sakabato", 0);
        cd1.addTrack(track1);
        cd1.addTrack(track2);
        cd1.addTrack(track3);

        //Initialize Store
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(dvd4);
        store.addMedia(dvd5);
        store.addMedia(dvd6);
        store.addMedia(dvd7);
        store.addMedia(cd1);
        store.addMedia(book1);

        //Add to Cart
//        cart.addMedia(dvd1);
//        cart.addMedia(dvd2);
//        cart.addMedia(dvd3);
//        cart.addMedia(dvd4);
//        cart.addMedia(dvd5);
//        cart.addMedia(dvd6);
//        cart.addMedia(dvd7);
//        cart.addMedia(cd1);
//        cart.addMedia(book1);

        launch(args);
    }
}
