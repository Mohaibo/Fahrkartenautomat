import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {

        Scanner tastatur = new Scanner(System.in);

        int userInput = 0;

        while (userInput < 2 || userInput > 9) {
            System.out.printf("Bitte geben Sie eine Zahl zwischen 2 und 9 ein: ");
            userInput = tastatur.nextInt();
        }

        for (int i = 0; i < 10; i++) {
            for (int x = 0; x < 10; x++) {
                if(x + i == userInput || x == userInput || (i == userInput && i > 0) || (x + i * 10) % userInput == 0) {
                    System.out.printf("%4c", '*');
                    continue;
                }
                System.out.printf("%4d", x + i * 10);
            }
            System.out.print("\n");
        }
    }
}
