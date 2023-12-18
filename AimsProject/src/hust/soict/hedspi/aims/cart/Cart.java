package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collections;

public class Cart {
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    int sequenceNum;

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void addMedia(Media item){
        itemsOrdered.add(item);
        System.out.println("Item has been added !");
    }

    public void removeMedia(Media item){
        itemsOrdered.remove(item);
        System.out.println("Item has been removed !");
    }

    public float totalCost() {
        float totalCost = 0.0f;
        for (Media item : itemsOrdered) {
            totalCost += item.getCost();
        }
        return totalCost;
    }

    public void displayCart() {
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            sequenceNum = 1;
            System.out.println("\nYour Cart:");
            System.out.format("%-5s %-5s %-30s %s %n", "", "ID", "Title", "Cost");
            for (Media item : itemsOrdered) {
                System.out.format("%-5d %-5d %-30s %.2f %n", sequenceNum, item.getId(), item.getTitle(), item.getCost());
                sequenceNum++;
            }
            System.out.format("%-5s %-36s %.2f %n", " ", "Total Cost", totalCost());
            System.out.println("---------------------------------------------------\n");
        }
    }

    public void print(){
        for (Media item : itemsOrdered){
            System.out.println(item.toString());
        }
    }

    public void searchByID(int id){
        boolean flag = false;
        for (Media media : itemsOrdered){
            if (media.isMatch(id)){
                System.out.println(media.toString());
                flag = true;
            }
        }
        if (!flag) System.out.println("No match found !");
    }

    public void searchByTitle(String title){
        boolean flag = false;
        for (Media media : itemsOrdered){
            if (media.isMatch(title)){
                System.out.println(media.toString());
                flag = true;
            }
        }
        if (!flag) System.out.println("No match found !");
    }

    public void sortByTitle(){
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCost(){
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }

    public int getNumberOfItemsInCart(){
        return itemsOrdered.size();
    }

    public void orderCart(){
        if (itemsOrdered.isEmpty())
            System.out.println("Cannot order because cart is empty.");
        else {
            System.out.println("Order is created !");
            itemsOrdered.clear();
        }
    }
}
