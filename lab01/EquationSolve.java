import javax.swing.JOptionPane;
public class EquationSolve {
    public static void main(String[] args) {
        int option;
        double a, b, c, x;
        double a11, a12, a21, a22, b1, b2, x1, x2;
        String strOption = "1. First-degree equation with one variable\n2. System of first-degree equations with two variables\n3. Second-degree equation with one variable\n4. Exit";
        do{
            option = Integer.parseInt(JOptionPane.showInputDialog(null, strOption, "Choose your option", JOptionPane.QUESTION_MESSAGE));
            switch (option){
                case 1:
                do {
                    a = Double.parseDouble(JOptionPane.showInputDialog(null, "Input a: ", "First-degree equation with one variable", JOptionPane.QUESTION_MESSAGE));
                    if (a == 0) JOptionPane.showMessageDialog(null, "a cannot have value 0 !", "Error", JOptionPane.ERROR_MESSAGE);
                } while (a == 0);
                b = Double.parseDouble(JOptionPane.showInputDialog(null, "Input b: ", "First-degree equation with one variable", JOptionPane.QUESTION_MESSAGE));
                x = -b / a;
                JOptionPane.showMessageDialog(null, "x = " + x, "Result", JOptionPane.INFORMATION_MESSAGE);
                break;
            }
        }while (option != 4);
        System.exit(0);
    }
}
