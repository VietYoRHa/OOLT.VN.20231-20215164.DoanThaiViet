package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Scanner;

public class Aims {
    public static void main(String[] args) throws PlayerException {
        Scanner scanner = new Scanner(System.in);
        int userOption;
        int userInputID;
        String userString, userTitle, userCategory, userDirector, userArtist, userAuthor;
        int userLength;
        float userCost;
        int exitFlag = 0;
        ObservableList<Media> items;

        //Create a store
        Store aStore = new Store();

        //Create Media objects
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95f, 87, "Roger Allers");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95f, 87, "George Lucas");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Turbo", "Animation", 12.29f, 96, "David Soren");
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Kung Fu Panda", "Animation", 14.99f, 92, "John Stevenson");
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Rurouni Kenshin: The Beginning", "Action", 29.23f, 134, "Keishi Otomo");
        DigitalVideoDisc dvd7 = new DigitalVideoDisc("The Exorcist", "Horror", 35f, 122, "William Friedkin");
        CompactDisc cd1 = new CompactDisc("Rurouni Kenshin Original Soundtrack", "Live Action", 28f, "Naoki Sato");
        CompactDisc cd2 = new CompactDisc("Rurouni Kenshin Original Soundtrack", "Anime", 25f, "Noriyuki Asakura");
        Book book1 = new Book("The Exorcist", "Novel", 21.68f, "William Peter Blatty");

        //Initialize Store
        aStore.addMedia(dvd1);
        aStore.addMedia(dvd2);
        aStore.addMedia(dvd3);
        aStore.addMedia(dvd4);
        aStore.addMedia(dvd5);
        aStore.addMedia(dvd6);
        aStore.addMedia(dvd7);
        aStore.addMedia(cd1);
        aStore.addMedia(cd2);
        aStore.addMedia(book1);

        //Create a cart
        Cart aCart = new Cart();

        //Console
        do{
            showMenu();
            userOption = scanner.nextInt();
            switch (userOption) {
                case 1:
                    do {
                        aStore.print();
                        storeMenu();
                        userOption = scanner.nextInt();
                        scanner.nextLine(); // Erase "Enter" char
                        if (userOption == 1) {
                            do {
                                System.out.print("Enter the title of the media: ");
                                userString = scanner.nextLine();
                            } while (userString.isEmpty());
                            items = aStore.searchInStore(userString);
                            if (items.isEmpty()) System.out.println("Item not found !");
                            else {
                                do {
                                    for (Media media : items) System.out.println(media.toString());
                                    mediaDetailsMenu();
                                    userOption = scanner.nextInt();
                                    scanner.nextLine(); // Erase "Enter" char
                                    if (userOption == 0){
                                        userOption = -1;
                                        break;
                                    }
                                    if (items.size() == 1) {
                                        if (userOption == 1){
                                            aCart.addMedia(items.get(0));
                                            System.out.println("Number of items in cart: " + aCart.getNumberOfItemsInCart());
                                        }
                                        if (userOption == 2) {
                                            if (items.get(0) instanceof Book)
                                                System.out.println("This option only available to CD and DVD type");
                                            else ((Playable) items.get(0)).play();
                                        }
                                    } else {
                                        System.out.print("Enter item's ID: ");
                                        userInputID = scanner.nextInt();
                                        scanner.nextLine(); // Erase "Enter" char
                                        if (userOption == 1) {
                                            for (Media media : items) {
                                                if (media.isMatch(userInputID)){
                                                    aCart.addMedia(media);
                                                    break;
                                                }
                                            }
                                            System.out.println("Number of items in cart: " + aCart.getNumberOfItemsInCart());
                                        }
                                        if (userOption == 2) {
                                            for (Media media : items) {
                                                if (media.isMatch(userInputID)) {
                                                    if (media instanceof Book) System.out.println("This option only available to CD and DVD type");
                                                    else ((Playable) media).play();
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    if (userOption != 1 && userOption != 2)
                                        System.out.println("Invalid choice. Please try again !");
                                } while (true);
                            }
                        }
                        if (userOption == 2){
                            do {
                                System.out.print("Enter the title of the media: ");
                                userString = scanner.nextLine();
                            } while (userString.isEmpty());
                            items = aStore.searchInStore(userString);
                            if (items.isEmpty()) System.out.println("Item not found !");
                            else {
                                for (Media media : items) System.out.println(media.toString());
                                if (items.size() == 1) aCart.addMedia(items.get(0));
                                else {
                                    System.out.print("Enter item's ID: ");
                                    userInputID = scanner.nextInt();
                                    scanner.nextLine(); // Erase "Enter" char
                                    for (Media media : items) {
                                        if (media.isMatch(userInputID)){
                                            aCart.addMedia(media);
                                            break;
                                        }
                                    }
                                }
                                System.out.println("Number of items in cart: " + aCart.getNumberOfItemsInCart());
                            }
                        };
                        if (userOption == 3){
                            do {
                                System.out.print("Enter the title of the media: ");
                                userString = scanner.nextLine();
                            } while (userString.isEmpty());
                            items = aStore.searchInStore(userString);
                            if (items.isEmpty()) System.out.println("Item not found !");
                            else {
                                for (Media media : items) System.out.println(media.toString());
                                if (items.size() == 1) {
                                    if (items.get(0) instanceof Book)
                                        System.out.println("This option only available to CD and DVD type");
                                    else ((Playable) items.get(0)).play();
                                } else {
                                    System.out.print("Enter item's ID: ");
                                    userInputID = scanner.nextInt();
                                    scanner.nextLine(); // Erase "Enter" char
                                    for (Media media : items) {
                                        if (media.isMatch(userInputID)) {
                                            if (media instanceof Book)
                                                System.out.println("This option only available to CD and DVD type");
                                            else ((Playable) media).play();
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        if (userOption == 4)
                            aCart.displayCart();
                        if (userOption == 0){
                            exitFlag = 2;
                        };
                    } while (exitFlag != 2);
                    break;
                case 2:
                    do {
                        System.out.println("1. Add a media");
                        System.out.println("2. Remove a media");
                        System.out.println("0. Back");
                        System.out.print("Please choose a number: ");
                        userOption = scanner.nextInt();
                        scanner.nextLine(); // Erase "Enter" char
                        if (userOption == 0){
                            break;
                        }
                        if (userOption == 1){
                            do {
                                System.out.print("Enter type of media (Book - CD - DVD): ");
                                userString = scanner.nextLine();
                            } while (!userString.equalsIgnoreCase("book") && !userString.equalsIgnoreCase("cd") && !userString.equalsIgnoreCase("dvd"));
                            System.out.print("Title: ");
                            userTitle = scanner.nextLine();
                            System.out.print("Category: ");
                            userCategory = scanner.nextLine();
                            System.out.print("Cost: ");
                            userCost = scanner.nextFloat();
                            scanner.nextLine(); //Erase "Enter" char
                            if (userString.equalsIgnoreCase("book")){
                                System.out.print("Author: ");
                                userAuthor = scanner.nextLine();
                                Book nBook = new Book(userTitle, userCategory, userCost, userAuthor);
                                aStore.addMedia(nBook);
                            }
                            if (userString.equalsIgnoreCase("cd")){
                                System.out.print("Artist: ");
                                userArtist = scanner.nextLine();
                                CompactDisc nCD = new CompactDisc(userTitle, userCategory, userCost, userArtist);
                                aStore.addMedia(nCD);
                            }
                            if (userString.equalsIgnoreCase("dvd")){
                                System.out.print("Length: ");
                                userLength = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Director: ");
                                userDirector = scanner.nextLine();
                                DigitalVideoDisc nDVD = new DigitalVideoDisc(userTitle, userCategory, userCost, userLength, userDirector);
                                aStore.addMedia(nDVD);
                            }
                        }
                        if (userOption == 2){
                            do {
                                System.out.print("Enter the title of the media: ");
                                userString = scanner.nextLine();
                            } while (userString.isEmpty());
                            items = aStore.searchInStore(userString);
                            if (items.isEmpty()) System.out.println("Item not found !");
                            else {
                                for (Media media : items) System.out.println(media.toString());
                                if (items.size() == 1){
                                    aStore.removeMedia(items.get(0));
                                    System.out.println("Removed !");
                                }
                                else {
                                    System.out.print("Enter item's ID: ");
                                    userInputID = scanner.nextInt();
                                    scanner.nextLine(); // Erase "Enter" char
                                    for (Media media : items) {
                                        if (media.isMatch(userInputID)){
                                            aStore.removeMedia(media);
                                            System.out.println("Removed !");
                                            break;
                                        }
                                    }
                                }
                            }
                        };
                        if (userOption != 1 && userOption != 2)
                            System.out.println("Invalid choice. Please try again !");
                    } while(true);
                    break;
                case 3:
                    do {
                        aCart.displayCart();
                        cartMenu();
                        userOption = scanner.nextInt();
                        scanner.nextLine();
                        if (userOption == 0){
                            break;
                        }
                        if (userOption == 1){
                            System.out.println("1. By ID");
                            System.out.println("2. By Title");
                            System.out.println("0. Back");
                            System.out.print("Please choose a number: ");
                            do{
                                userOption = scanner.nextInt();
                                scanner.nextLine();
                            } while(userOption != 0 && userOption != 1 && userOption != 2);
                            if (userOption == 1){
                                System.out.print("Enter ID: ");
                                userInputID = scanner.nextInt();
                                scanner.nextLine();
                                aCart.searchByID(userInputID);
                            }
                            if (userOption == 2){
                                System.out.print("Enter title: ");
                                userString = scanner.nextLine();
                                aCart.searchByTitle(userString);
                            }
                            if (userOption == 0) continue;
                        }
                        if (userOption == 2){
                            System.out.println("1. By Title");
                            System.out.println("2. By Cost");
                            System.out.println("0. Back");
                            System.out.print("Please choose a number: ");
                            do{
                                userOption = scanner.nextInt();
                                scanner.nextLine();
                            } while(userOption != 0 && userOption != 1 && userOption != 2);
                            if (userOption == 1){
                                aCart.sortByTitle();
                            }
                            if (userOption == 2){
                                aCart.sortByCost();
                            }
                            if (userOption == 0) continue;
                        }
                        if (userOption == 3){
                            do {
                                System.out.print("Enter the title of the media: ");
                                userString = scanner.nextLine();
                            } while (userString.isEmpty());
                            items = aStore.searchInStore(userString);
                            if (items.isEmpty()) System.out.println("Item not found !");
                            else {
                                for (Media media : items) System.out.println(media.toString());
                                if (items.size() == 1) aCart.removeMedia(items.get(0));
                                else {
                                    System.out.print("Enter item's ID: ");
                                    userInputID = scanner.nextInt();
                                    scanner.nextLine(); // Erase "Enter" char
                                    for (Media media : items) {
                                        if (media.isMatch(userInputID)){
                                            aCart.removeMedia(media);
                                            break;
                                        }
                                    }
                                }
                                System.out.println("Number of items in cart: " + aCart.getNumberOfItemsInCart());
                            }
                        }
                        if (userOption == 4){
                            items = aCart.getItemsOrdered();
                            if (items.isEmpty()) System.out.println("The cart is empty.");
                            else {
                                aCart.print();
                                System.out.print("Enter item's ID: ");
                                userInputID = scanner.nextInt();
                                scanner.nextLine(); // Erase "Enter" char
                                for (Media media : items) {
                                    if (media.isMatch(userInputID)) {
                                        if (media instanceof Book)
                                            System.out.println("This option only available to CD and DVD type");
                                        else ((Playable) media).play();
                                        break;
                                    }
                                }
                            }
                        }
                        if (userOption == 5) {
                            aCart.orderCart();
                            break;
                        }
                    } while(true);
                    break;
                case 0:
                    exitFlag = 1;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again !");
            }
        } while (exitFlag != 1);
        scanner.close();
    }

    //Main menu
    public static void showMenu(){
        System.out.println("AIMS:");
        System.out.println("-----------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("-----------------------------");
        System.out.print("Please choose a number: ");
    }

    //Store menu
    public static void storeMenu(){
        System.out.println("Options:");
        System.out.println("-----------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("-----------------------------");
        System.out.print("Please choose a number: ");
    }

    //Media menu
    public static void mediaDetailsMenu(){
        System.out.println("Options:");
        System.out.println("-----------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("-----------------------------");
        System.out.print("Please choose a number: ");
    }

    //Cart menu
    public static void cartMenu(){
        System.out.println("Options:");
        System.out.println("-----------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("-----------------------------");
        System.out.print("Please choose a number: ");
    }
}
