import java.util.Scanner;
public class DisplayTriangle {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Input n: ");
        int n = keyboard.nextInt();
        for(int a = 0; a < n; a++){
            for (int i = n - (a + 1); i > 0; i--) System.out.print(" ");
            for (int j = 2*a + 1; j > 0; j--) System.out.print("*");
            System.out.print("\n");
        }
    }
}
