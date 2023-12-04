package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookToStoreScreen extends JFrame {
    private Store store;
    private StoreManagerScreen previousScreen;
    private JTextField tfTitle, tfCategory, tfCost, tfAuthor;

    JPanel createNorth(){
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar(){
        JMenu menu = new JMenu("Options");

        JMenuItem viewStoreMenuItem = new JMenuItem("View Store");
        viewStoreMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                previousScreen.setVisible(true);
                dispose();
            }
        });

        menu.add(viewStoreMenuItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
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

    private void createComponents(Store store) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        panel.add(new JLabel("Title:"));
        tfTitle = new JTextField();
        panel.add(tfTitle);

        panel.add(new JLabel("Category:"));
        tfCategory = new JTextField();
        panel.add(tfCategory);

        panel.add(new JLabel("Cost:"));
        tfCost = new JTextField();
        panel.add(tfCost);

        panel.add(new JLabel("Author:"));
        tfAuthor = new JTextField();
        panel.add(tfAuthor);

        JButton btnAdd = new JButton("Add Book to Store");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBookToStore(store);
            }
        });
        panel.add(btnAdd);

        add(panel, BorderLayout.CENTER);
    }

    private void addBookToStore(Store store) {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());
        String author = tfAuthor.getText();

        Book book = new Book(title, category, cost, author);

        store.addMedia(book);
        previousScreen.mediaInStore.add(book);
        MediaStore cell = new MediaStore(book);
        previousScreen.center.add(cell);

        JOptionPane.showMessageDialog(this, "Book added successfully to the store.");

        tfTitle.setText("");
        tfCategory.setText("");
        tfCost.setText("");
        tfAuthor.setText("");
    }

    public AddBookToStoreScreen(StoreManagerScreen previousScreen, Store store){
        this.previousScreen = previousScreen;
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        createComponents(store);

        setTitle("Add Book to Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
