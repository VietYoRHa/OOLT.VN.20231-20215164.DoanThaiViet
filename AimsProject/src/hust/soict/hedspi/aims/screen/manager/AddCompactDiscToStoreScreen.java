package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCompactDiscToStoreScreen extends JFrame{
    private Store store;
    private StoreManagerScreen previousScreen;
    private JTextField tfTitle, tfCategory, tfCost, tfArtist;

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

        panel.add(new JLabel("Artist:"));
        tfArtist = new JTextField();
        panel.add(tfArtist);

        JButton btnAdd = new JButton("Add CD to Store");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCompactDiscToStore(store);
            }
        });
        panel.add(btnAdd);

        add(panel, BorderLayout.CENTER);
    }

    private void addCompactDiscToStore(Store store) {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());
        String artist = tfArtist.getText();

        CompactDisc cd = new CompactDisc(title, category, cost, artist);

        store.addMedia(cd);
        previousScreen.mediaInStore.add(cd);
        MediaStore cell = new MediaStore(cd);
        previousScreen.center.add(cell);

        JOptionPane.showMessageDialog(this, "CD added successfully to the store.");

        tfTitle.setText("");
        tfCategory.setText("");
        tfCost.setText("");
        tfArtist.setText("");
    }

    public AddCompactDiscToStoreScreen(StoreManagerScreen previousScreen, Store store){
        this.previousScreen = previousScreen;
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        createComponents(store);

        setTitle("Add CD to Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
