import javax.swing.JOptionPane;
import java.lang.Math;
public class EquationSolve {
    public static void main(String[] args) {
        int option;
        double a, b, c, x, squareRoot;
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
                
                case 2:
                a11 = Double.parseDouble(JOptionPane.showInputDialog(null, "Input a11: ", "System of first-degree equations with two variables", JOptionPane.QUESTION_MESSAGE));
                a12 = Double.parseDouble(JOptionPane.showInputDialog(null, "Input a12: ", "System of first-degree equations with two variables", JOptionPane.QUESTION_MESSAGE));
                b1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Input b1: ", "System of first-degree equations with two variables", JOptionPane.QUESTION_MESSAGE));
                a21 = Double.parseDouble(JOptionPane.showInputDialog(null, "Input a21: ", "System of first-degree equations with two variables", JOptionPane.QUESTION_MESSAGE));
                a22 = Double.parseDouble(JOptionPane.showInputDialog(null, "Input a22: ", "System of first-degree equations with two variables", JOptionPane.QUESTION_MESSAGE));
                b2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Input b2: ", "System of first-degree equations with two variables", JOptionPane.QUESTION_MESSAGE));
                //Cramer
                double D = a11*a22 - a21*a12;
                double Dx = b1*a22 - b2*a12;
                double Dy = a11*b2 - a21*b1;
                if (D != 0) { // D != 0, One Solution
                    x1 = Dx / D;
                    x2 = Dy / D;
                    JOptionPane.showMessageDialog(null, "x1 = " + x1 + "\n" + "x2 = " + x2, "Result", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // D = Dx = Dy = 0, Infinitely Many Solutions
                    if (Dx == 0 && Dy == 0) JOptionPane.showMessageDialog(null, "Infinitely Many Solutions !", "Result", JOptionPane.INFORMATION_MESSAGE);
                    // D = 0 & Dx != Dy, No Solution
                    else JOptionPane.showMessageDialog(null, "No Solution !", "Result", JOptionPane.INFORMATION_MESSAGE);
                }
                break;

                case 3:
                do {
                    a = Double.parseDouble(JOptionPane.showInputDialog(null, "Input a: ", "Second-degree equation with one variable", JOptionPane.QUESTION_MESSAGE));
                    if (a == 0) JOptionPane.showMessageDialog(null, "a cannot have value 0 !", "Error", JOptionPane.ERROR_MESSAGE);
                } while (a == 0);
                b = Double.parseDouble(JOptionPane.showInputDialog(null, "Input b: ", "Second-degree equation with one variable", JOptionPane.QUESTION_MESSAGE));
                c = Double.parseDouble(JOptionPane.showInputDialog(null, "Input c: ", "Second-degree equation with one variable", JOptionPane.QUESTION_MESSAGE));
                double delta = b*b - 4*a*c;
                if (delta < 0) JOptionPane.showMessageDialog(null, "No Solution !", "Result", JOptionPane.INFORMATION_MESSAGE);
                else if (delta == 0){
                    x = -b / (2*a);
                    JOptionPane.showMessageDialog(null, "x1 = x2 = " + x, "Result", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    squareRoot = Math.sqrt(delta);
                    x1 = (-b + squareRoot) / (2*a);
                    x2 = (-b - squareRoot) / (2*a);
                    JOptionPane.showMessageDialog(null, "x1 = " + x1 + "\n" + "x2 = " + x2, "Result", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            }
        }while (option != 4);
        JOptionPane.showMessageDialog(null, "Thank you for using !", "Quit", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
