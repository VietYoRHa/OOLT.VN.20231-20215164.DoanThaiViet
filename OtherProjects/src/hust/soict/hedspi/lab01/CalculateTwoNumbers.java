import javax.swing.JOptionPane;
public class CalculateTwoNumbers {
    public static void main(String[] args) {
        String strNum1, strNum2;
        String strOutput = "";
        double sum, difference, product, quotient;
        strNum1 = JOptionPane.showInputDialog(null, "Please input first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, "Please input second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        sum = num1 + num2;
        difference = num1 - num2;
        product = num1 * num2;
        quotient = num1 / num2;
        strOutput += strNum1 + " + " + strNum2 + " = " + sum + "\n"
        + strNum1 + " - " + strNum2 + " = " + difference + "\n"
        + strNum1 + " * " + strNum2 + " = " + product + "\n"
        + strNum1 + " / " + strNum2 + " = " + quotient + "\n";
        JOptionPane.showMessageDialog(null, strOutput, "Result", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
