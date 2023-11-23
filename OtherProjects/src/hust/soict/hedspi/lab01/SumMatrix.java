import java.util.Scanner;
public class SumMatrix {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter size of matrix (example: 3x3 then input 3): ");
        int size = keyboard.nextInt();
        keyboard.nextLine(); //Bypass empty line
        double matrixA[][] = new double[size][size];
        double matrixB[][] = new double[size][size];
        double result[][] = new double[size][size];
        //Input matrix
        System.out.println("Enter the first matrix:");
        inputMatrix(matrixA, size, keyboard);
        System.out.println("Enter the second matrix:");
        inputMatrix(matrixB, size, keyboard);
        //Add two matrices
        sumMatrix(result, matrixA, matrixB, size);
        //Output result
        System.out.println("The Sum of two Matrices is:");
        outputMatrix(result, size);
    }

    //Input matrix method
    public static void inputMatrix(double matrix[][], int matrixSize, Scanner input){
        int row = 0;
        do{
            String tmp1 = input.nextLine();
            String tmp2[] = tmp1.split("\\s+");
            for (int col = 0; col < matrixSize; col++){
                matrix[row][col] = Double.parseDouble(tmp2[col]);
            }
            row++;
        } while (row != matrixSize);
    }

    //Output matrix method
    public static void outputMatrix(double matrix[][], int matrixSize){
        for (int row = 0; row < matrixSize; row++){
            for (int col = 0; col < matrixSize; col++){
                System.out.print(matrix[row][col] + "\t");
            }
            System.out.print("\n");
        }
    }

    //Add two matrices method
    public static void sumMatrix(double matrixSum[][], double matrix1[][], double matrix2[][], int matrixSize){
        for (int row = 0; row < matrixSize; row++){
            for (int col = 0; col < matrixSize; col++){
                matrixSum[row][col] = matrix1[row][col] + matrix2[row][col];
            }
        }        
    }
}
