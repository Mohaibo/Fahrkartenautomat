import java.util.Scanner;

public class Treppe {
    public static void main(String[] args) {

        Scanner tastatur = new Scanner(System.in);

        int hoehe = 0;
        int breite = 0;
        System.out.print("Treppenhöhe: ");
        hoehe = tastatur.nextInt();
        System.out.print("Stufenbreite: ");
        breite = tastatur.nextInt();


        for(int x = 1; x <= hoehe; x++) {

            int i = 1;

            int y = breite * hoehe - x * breite;

            while(y > 0) {
                System.out.print(" ");
                y--;
            }
            while(i <= x * breite) {
                System.out.print("*");
                i++;
            }
            System.out.print("\n");
        }
    }
}
