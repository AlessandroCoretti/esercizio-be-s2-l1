package Esercizio3;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static  final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
           ContoCorrente conto = new ContoCorrente("Mario Rossi", 20000.0);
           ContoOnline contoOnline = new ContoOnline("Alessandro Coretti", 1000.0, 2500.0);

        while (true) {
            try {
                System.out.println("\nSeleziona il tipo di conto (1: Normale, 2: Online, 0: Esci):");
                int scelta = scanner.nextInt();

                if (scelta == 0) break;

                System.out.print("Inserisci l'importo da prelevare: ");
                double importo = scanner.nextDouble();

                switch (scelta) {
                    case 1:
                        conto.preleva(importo);
                        System.out.printf("Prelievo effettuato. Nuovo saldo: %.2f%n",
                                conto.restituisciSaldo());
                        break;
                    case 2:
                        contoOnline.preleva(importo);
                        contoOnline.stampaSaldo();
                        break;
                    default:
                        System.out.println("Scelta non valida");
                }
            } catch (BancaException e) {
                LOGGER.log(Level.WARNING, "Errore durante l'operazione bancaria", e);
                System.out.println("Errore: " + e.getMessage());
            } catch (InputMismatchException e) {
                LOGGER.log(Level.WARNING, "Input non valido", e);
                System.out.println("Errore: inserire un valore numerico valido");
                scanner.nextLine(); // Pulisce il buffer dello scanner
            }
        }

        scanner.close();
    }

}
