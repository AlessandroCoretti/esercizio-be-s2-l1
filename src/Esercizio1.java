import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Esercizio1 {
    private static final Logger LOGGER = Logger.getLogger(Esercizio1.class.getName());

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int[] numeri = new int[5];

        //inizializzo array con numeri casuali
        for (int i = 0; i < numeri.length; i++){
            numeri[i] = random.nextInt(10) + 1;
        }

        //stampa stato iniziale
        System.out.println("Array iniziale: ");
        stampaArray(numeri);

        int posizione = 0;
        int valore = 0;

        do {
            try {
                System.out.print("Inserisci la posizione (0-4): ");
                posizione = scanner.nextInt();
                System.out.println("Inserisci il valore (0 per terminare): ");
                valore = scanner.nextInt();

                if (valore !=0){
                    numeri[posizione] = valore;
                    System.out.println("Nuovo stato dell'array: ");
                    stampaArray(numeri);
                }
            }catch (ArrayIndexOutOfBoundsException e){
                LOGGER.log(Level.WARNING, "Posizione non valida: {0}", posizione);
                System.out.println("Errore: posizione non valida!");
            }catch (Exception e){
                LOGGER.log(Level.SEVERE, "Errore generico", e);
                System.out.println("Errore durante l'inserimento");
            }
        }while (valore !=0);

        scanner.close();
    }

    private static void stampaArray(int[] array){
        for (int num : array){
            System.out.println(num + " ");
        }
        System.out.println();
    }
}
