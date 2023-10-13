import javax.swing.JOptionPane;
public class EquationSolve {
    public static void main(String[] args) {
        int option;
        double a, b, c, x;
        double a11, a12, a21, a22, b1, b2, x1, x2;
        String strOption = "1. First-degree equation with one variable\n2. System of first-degree equations with two variables\n3. Second-degree equation with one variable\n4. Exit";
        outer: do{
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
                
                case 2:
                a11 = Double.parseDouble(JOptionPane.showInputDialog(null, "Input a11: ", "System of first-degree equations with two variables", JOptionPane.QUESTION_MESSAGE));
                a12 = Double.parseDouble(JOptionPane.showInputDialog(null, "Input a12: ", "System of first-degree equations with two variables", JOptionPane.QUESTION_MESSAGE));
                b1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Input b1: ", "System of first-degree equations with two variables", JOptionPane.QUESTION_MESSAGE));
                a21 = Double.parseDouble(JOptionPane.showInputDialog(null, "Input a21: ", "System of first-degree equations with two variables", JOptionPane.QUESTION_MESSAGE));
                a22 = Double.parseDouble(JOptionPane.showInputDialog(null, "Input a22: ", "System of first-degree equations with two variables", JOptionPane.QUESTION_MESSAGE));
                b2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Input b2: ", "System of first-degree equations with two variables", JOptionPane.QUESTION_MESSAGE));
                double D = a11*a22 - a21*a12;
                double Dx = b1*a22 - b2*a12;
                double Dy = a11*b2 - a21*b1;
                if (D != 0) {
                    x1 = Dx / D;
                    x2 = Dy / D;
                    JOptionPane.showMessageDialog(null, "x1 = " + x1 + "\n" + "x2 = " + x2, "Result", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    if (Dx == 0 && Dy == 0) JOptionPane.showMessageDialog(null, "Infinitely Many Solutions !", "Result", JOptionPane.INFORMATION_MESSAGE);
                    else JOptionPane.showMessageDialog(null, "No Solution !", "Result", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            }
        }while (option != 4);
        System.exit(0);
    }
}
