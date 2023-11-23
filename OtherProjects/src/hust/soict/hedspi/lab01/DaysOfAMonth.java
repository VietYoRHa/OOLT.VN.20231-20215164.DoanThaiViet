import java.util.Map;
import java.util.HashMap;
import javax.swing.JOptionPane;
public class DaysOfAMonth {
    public static void main(String[] args) {
        int varDay = 0, varMonth = 0, varYear = 0;
        Map<String, Integer> months = new HashMap<String, Integer>();
        months.put("January", 1); months.put("Jan.", 1); months.put("Jan", 1); months.put("1", 1);
        months.put("February", 2); months.put("Feb.", 2); months.put("Feb", 2); months.put("2", 2);
        months.put("March", 3); months.put("Mar.", 3); months.put("Mar", 3); months.put("3", 3);
        months.put("April", 4); months.put("Apr.", 4); months.put("Apr", 4); months.put("4", 4);
        months.put("May", 5); months.put("May", 5); months.put("May", 5); months.put("5", 5);
        months.put("June", 6); months.put("June", 6); months.put("Jun", 6); months.put("6", 6);
        months.put("July", 7); months.put("July", 7); months.put("Jul", 7); months.put("7", 7);
        months.put("August", 8); months.put("Aug.", 8); months.put("Aug", 8); months.put("8", 8);
        months.put("September", 9); months.put("Sept.", 9); months.put("Sep", 9); months.put("9", 9);
        months.put("October", 10); months.put("Oct.", 10); months.put("Oct", 10); months.put("10", 10);
        months.put("November", 11); months.put("Nov.", 11); months.put("Nov", 11); months.put("11", 11);
        months.put("December", 12); months.put("Dec.", 12); months.put("Dec", 12); months.put("12", 12);
        do{
            String strMonth = JOptionPane.showInputDialog(null, "Please input month: ", "Input", JOptionPane.QUESTION_MESSAGE);
            if (months.containsKey(strMonth)){
                varMonth = months.get(strMonth);
                break;
            }
            else JOptionPane.showMessageDialog(null, "Wrong month, please input again !", "Error", JOptionPane.ERROR_MESSAGE);
        } while(true);
        do{
            String strYear = JOptionPane.showInputDialog(null, "Please input year: ", "Input", JOptionPane.QUESTION_MESSAGE);
            if (isYear(strYear)){
                varYear = Integer.parseInt(strYear);
                break;
            }
            else JOptionPane.showMessageDialog(null, "Wrong year, please input again !", "Error", JOptionPane.ERROR_MESSAGE);
        } while(true);
        switch (varMonth){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                varDay = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                varDay = 30;
                break;
            case 2:
                if (checkYear(varYear)) varDay = 29;
                else varDay = 28;
                break;
        }
        JOptionPane.showMessageDialog(null, "Has " + varDay + " days", "Result", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    public static boolean isYear(String str){
        return str.matches("^[1-9]\\d{3}$");
    }

    public static boolean checkYear(int yearCheck){
        return ((yearCheck % 4 == 0 && yearCheck % 100 != 0) || yearCheck % 400 == 0);
    }
}
