package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private List<DigitalVideoDisc> itemsOrdered = new ArrayList<>();
    private int qtyOrdered = 0;
    int sequenceNum;

    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if (qtyOrdered < MAX_NUMBERS_ORDERED){
            itemsOrdered.add(disc);
            qtyOrdered++;
            System.out.println("The disc has been added");
        } else {
            System.out.println("The cart is almost full");
        }
    }

    public void addDigitalVideoDisc(List<DigitalVideoDisc> dvdList) {
        int spaceLeft = MAX_NUMBERS_ORDERED - qtyOrdered;
        if (spaceLeft >= dvdList.size()) {
            itemsOrdered.addAll(dvdList);
            qtyOrdered += dvdList.size();
            System.out.println("The discs have been added.");
        } else {
            System.out.println("Not enough space in the cart to add all the discs.");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
        for (DigitalVideoDisc dvd : dvds) {
            addDigitalVideoDisc(dvd);
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (itemsOrdered.contains(disc)) {
            itemsOrdered.remove(disc);
            qtyOrdered--;
            System.out.println("The disc has been removed.");
        } else {
            System.out.println("The disc is not found in the cart.");
        }
    }

    public float totalCost() {
        float totalCost = 0.0f;
        for (DigitalVideoDisc disc : itemsOrdered) {
            totalCost += disc.getCost();
        }
        return totalCost;
    }

    public void displayCart() {
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            sequenceNum = 1;
            System.out.println("\nYour Cart:");
            for (DigitalVideoDisc disc : itemsOrdered) {
                System.out.format("%-5d %-30s %.2f %n", sequenceNum, disc.getTitle(), disc.getCost());
                sequenceNum++;
            }
            System.out.format("%-5s %-30s %.2f %n", " ", "Total Cost", totalCost());
            System.out.println("-----------------------------------------\n");
        }
    }
}
