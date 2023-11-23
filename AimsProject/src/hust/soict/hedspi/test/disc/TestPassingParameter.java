package hust.soict.hedspi.test.disc;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        //TODO Auto-generated method stub
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
        // Put the objects into an array for swapping
        DigitalVideoDisc[] dvdArray = new DigitalVideoDisc[]{jungleDVD, cinderellaDVD};

        swap(dvdArray, 0, 1);
        System.out.println("jungle dvd title: " + dvdArray[0].getTitle());
        System.out.println("cinderella dvd title: " + dvdArray[1].getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("\njungle dvd title: " + jungleDVD.getTitle());
    }

    public static void swap(DigitalVideoDisc[] dvdArray, int idx1, int idx2) {
        if (idx1 < 0 || idx1 >= dvdArray.length || idx2 < 0 || idx2 >= dvdArray.length) {
            System.out.println("Invalid indices. Swapping failed.");
            return;
        }

        DigitalVideoDisc tmp = dvdArray[idx1];
        dvdArray[idx1] = dvdArray[idx2];
        dvdArray[idx2] = tmp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title){
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}

