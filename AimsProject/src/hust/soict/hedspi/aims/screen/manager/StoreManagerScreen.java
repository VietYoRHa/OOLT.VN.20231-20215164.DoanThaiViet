package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StoreManagerScreen extends JFrame{
    private Store store;
    JPanel center = new JPanel();
    ArrayList<Media> mediaInStore;
    JPanel createNorth(){
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar(){
        JMenu menu = new JMenu("Options");

        menu.add(new JMenuItem("View store"));

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem menuItemAddBook = new JMenuItem("Add Book");
        menuItemAddBook.setActionCommand("AddBook");
        menuItemAddBook.addActionListener(new UpdateStoreActionListener());
        smUpdateStore.add(menuItemAddBook);

        JMenuItem menuItemAddCD = new JMenuItem("Add CD");
        menuItemAddCD.setActionCommand("AddCD");
        menuItemAddCD.addActionListener(new UpdateStoreActionListener());
        smUpdateStore.add(menuItemAddCD);

        JMenuItem menuItemAddDVD = new JMenuItem("Add DVD");
        menuItemAddDVD.setActionCommand("AddDVD");
        menuItemAddDVD.addActionListener(new UpdateStoreActionListener());
        smUpdateStore.add(menuItemAddDVD);

        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    private class UpdateStoreActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String actionCommand = e.getActionCommand();

            switch (actionCommand) {
//                case "AddBook":
//                    dispose();
//                    new AddBookToStoreScreen(StoreManagerScreen.this);
//                    break;
//                case "AddCD":
//                    dispose();
//                    new AddCompactDiscToStoreScreen(StoreManagerScreen.this);
//                    break;
                case "AddDVD":
                    dispose();
                    new AddDigitalVideoDiscToStoreScreen(StoreManagerScreen.this, store);
                    break;
            }
        }
    }

    JPanel createHeader(){
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        center.setLayout(new GridLayout(3, 3, 2, 2));

        mediaInStore = store.getItemsInStore();
        for (int i = 0; i < mediaInStore.size(); i++){
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }

        return center;
    }

    public StoreManagerScreen(Store store){
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        //Create a store
        Store aStore = new Store();

        //Create Media objects
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95f, 87, "Roger Allers");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95f, 87, "George Lucas");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
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
        aStore.addMedia(dvd5);
        aStore.addMedia(dvd6);
        aStore.addMedia(dvd7);
//        aStore.addMedia(cd1);
//        aStore.addMedia(cd2);
//        aStore.addMedia(book1);

        new StoreManagerScreen(aStore);
        
    }
}
