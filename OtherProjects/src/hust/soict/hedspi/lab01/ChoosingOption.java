import javax.swing.JOptionPane;
public class ChoosingOption {
    public static void main(String[] args) {
        String strNotification = "";
        Object[] options = {"I do", "I don't"};
        int option = JOptionPane.showOptionDialog(null, "Do you want to change to the first class ticket?", "Choose your option", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null, options, options[0]);
        switch (option){
            case 0:
            strNotification = "I do";
            break;
            case 1:
            strNotification = "I don't";
            break;
            case -1:
            strNotification = "Closed the dialog";
            break;
        }
        JOptionPane.showMessageDialog(null, "You've chosen: " + strNotification);
        System.exit(0);
    }
}
