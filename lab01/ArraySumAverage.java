import java.util.Scanner;
import java.util.Arrays;
public class ArraySumAverage {
    public static void main(String[] args) {
        double sum = 0, average;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter array (separated by space):");
        String input = keyboard.nextLine();
        String tmpArray[] = input.split("\\s+");
        double numArray[] = new double[tmpArray.length];
        for (int i = 0; i < tmpArray.length; i++){
            numArray[i] = Double.parseDouble(tmpArray[i]);
            sum += numArray[i];
        }
        average = sum / tmpArray.length;
        Arrays.sort(numArray);
        System.out.println("\nSum: " + sum);
        System.out.println("\nAverage: " + average);
        System.out.println("\nSorted array:");
        for (int i = 0; i < tmpArray.length; i++){
            System.out.print(numArray[i] + " ");
        }
    }
}
