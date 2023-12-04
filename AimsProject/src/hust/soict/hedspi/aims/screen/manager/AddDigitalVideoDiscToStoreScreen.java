package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDigitalVideoDiscToStoreScreen extends JFrame {
    private Store store;
    private JTextField tfTitle, tfCategory, tfCost, tfLength, tfDirector;

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
        panel.setLayout(new GridLayout(6, 2));

        panel.add(new JLabel("Title:"));
        tfTitle = new JTextField();
        panel.add(tfTitle);

        panel.add(new JLabel("Category:"));
        tfCategory = new JTextField();
        panel.add(tfCategory);

        panel.add(new JLabel("Cost:"));
        tfCost = new JTextField();
        panel.add(tfCost);

        panel.add(new JLabel("Length:"));
        tfLength = new JTextField();
        panel.add(tfLength);

        panel.add(new JLabel("Director:"));
        tfDirector = new JTextField();
        panel.add(tfDirector);

        JButton btnAdd = new JButton("Add DVD to Store");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDigitalVideoDiscToStore(store);
            }
        });
        panel.add(btnAdd);

        add(panel, BorderLayout.CENTER);
    }

    private void addDigitalVideoDiscToStore(Store store) {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());
        int length = Integer.parseInt(tfLength.getText());
        String director = tfDirector.getText();

        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost, length, director);

        store.addMedia(dvd);

        JOptionPane.showMessageDialog(this, "DVD added successfully to the store.");

        tfTitle.setText("");
        tfCategory.setText("");
        tfCost.setText("");
        tfLength.setText("");
        tfDirector.setText("");
    }

    public AddDigitalVideoDiscToStoreScreen(Store store){
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        createComponents(store);

        setTitle("Add DVD to Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        Store a = new Store();
        new AddDigitalVideoDiscToStoreScreen(a);
    }
}
