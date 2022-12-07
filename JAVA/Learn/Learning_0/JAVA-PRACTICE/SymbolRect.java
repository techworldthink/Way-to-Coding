import java.util.Scanner;

public class SymbolRect {
    public static void main(String ar[]) {
        Scanner scanner = new Scanner(System.in);

        int rows;
        int columns;
        String symbol;

        System.out.println("Enter the number of rows :");
        rows = scanner.nextInt();
        System.out.println("Enter the number of columns :");
        columns = scanner.nextInt();
        System.out.println("Enter the symbol to be used :");
        symbol = scanner.next();

        for (int i = 0; i<rows; i++) {
            for (int j = 0; j<columns; j++) {
                System.out.print(symbol+"  ");
            }
            System.out.println("\n");
        }


        scanner.close();
    }
    
}
