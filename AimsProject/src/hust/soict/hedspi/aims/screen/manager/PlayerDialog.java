package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;

public class PlayerDialog extends JDialog {
    public PlayerDialog(Frame owner, String title, boolean modal) {
        super(owner, title, modal);
        setLayout(new BorderLayout());
        setSize(400, 300);
    }

    public void showInfo(String info) {
        JTextArea textArea = new JTextArea(info);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
