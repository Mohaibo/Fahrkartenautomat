import java.util.Scanner;

class Fahrkartenautomat {
    public static void main(String[] args) {

        Scanner tastatur = new Scanner(System.in);

        double zuZahlenderBetrag;
        double eingezahlterGesamtbetrag;
        double eingeworfeneMuenze;
        double rueckgabebetrag;
        double nochZuZahlen;
        int ticketAnzahl = 1;
        int anzahlDerTickets;
        // 1 Geldbetrag eingeben
        System.out.print("Ticketpreis (Euro): ");
        zuZahlenderBetrag = tastatur.nextDouble();
        if(zuZahlenderBetrag < 0) {
            zuZahlenderBetrag = 1;
            System.out.print("Fehlerhafte Eingabe - Ticketpreis wird auf 1 gesetzt");
        }
        System.out.print("Anzahl der Tickets: ");
        ticketAnzahl = tastatur.nextInt();
        if(ticketAnzahl < 1 || ticketAnzahl > 10) {
            ticketAnzahl = 1;
            System.out.print("Fehlerhafte Eingabe - Ticketanzahl wird auf 1 gesetzt");
        }
        zuZahlenderBetrag *= ticketAnzahl;
        // 2 Geldeinwurf
        eingezahlterGesamtbetrag = 0.0;
        nochZuZahlen = 0.0;
        while (eingezahlterGesamtbetrag < zuZahlenderBetrag) {
            nochZuZahlen = zuZahlenderBetrag - eingezahlterGesamtbetrag;
            System.out.printf("Noch zu zahlen: %.2f Euro\n", nochZuZahlen);
            System.out.print("Eingabe (mind. 5 Cent, höchstens 2 Euro): ");
            eingeworfeneMuenze = tastatur.nextDouble();
            System.out.println(eingeworfeneMuenze);
            if(eingeworfeneMuenze == 0.05 || eingeworfeneMuenze == 0.1 || 
            		eingeworfeneMuenze == 0.2 || eingeworfeneMuenze == 0.5 || 
            		eingeworfeneMuenze == 1 || eingeworfeneMuenze == 2 || 
            		eingeworfeneMuenze == 5 || eingeworfeneMuenze == 10 || 
            		eingeworfeneMuenze == 20) {
            	eingezahlterGesamtbetrag = eingezahlterGesamtbetrag + eingeworfeneMuenze;
            } else {
            	 System.out.println(">> Kein gültiges Zahlungsmittel"); 	
            }
           
        }

        // 3 Fahrscheinausgabe
        System.out.println("\nFahrschein wird ausgegeben");
        for (int i = 0; i < 8; i++) {
            System.out.print("=");
            try {
                Thread.sleep(200);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n\n");

        // 4 Rückgeldberechnung und -ausgabe
        rueckgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag;
        if (rueckgabebetrag > 0.0) {
            System.out.printf("Der Rückgabebetrag in Höhe von %.2f Euro\n", rueckgabebetrag);
            System.out.println("wird in folgenden Münzen ausgezahlt:");

            while (rueckgabebetrag >= 2.0) { // 2-Euro-Münzen
                System.out.println("2 Euro ");
                rueckgabebetrag = Math.round((rueckgabebetrag - 2.0) * 100) / (float) 100;
            }
            while (rueckgabebetrag >= 1.0) { // 1-Euro-Münzen
                System.out.println("1 Euro");
                rueckgabebetrag = Math.round((rueckgabebetrag - 1.0) * 100) /  (float) 100;
            }
            while (rueckgabebetrag >= 0.5) { // 50-Cent-Münzen
                System.out.println("50 Cent");
                rueckgabebetrag = Math.round((rueckgabebetrag - 0.5) * 100) /  (float) 100;
            }
            while (rueckgabebetrag >= 0.2) { // 20-Cent-Münzen
                System.out.println("20 Cent");
                rueckgabebetrag = Math.round((rueckgabebetrag - 0.2) * 100) /  (float) 100;
            }
            while (rueckgabebetrag >= 0.1) { // 10-Cent-Münzen
                System.out.println("10 Cent");
                rueckgabebetrag = Math.round((rueckgabebetrag - 0.1) * 100) /  (float) 100;
            }
            while (rueckgabebetrag >= 0.05) { // 5-Cent-Münzen
                System.out.println("5 Cent");
                rueckgabebetrag = Math.round((rueckgabebetrag - 0.05) * 100) /  (float) 100;
            }
        }

        System.out.println("\nVergessen Sie nicht, den Fahrschein\n" + "vor Fahrtantritt entwerten zu lassen!\n"
                + "Wir wünschen Ihnen eine gute Fahrt.");

        tastatur.close();
    }
}