import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Esercizio2 {
    private static final Logger LOGGER = Logger.getLogger(Esercizio2.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Inserisci i km percorsi: ");
            double km = scanner.nextDouble();

            System.out.print("Inserisci i lt consumati: ");
            double lt = scanner.nextDouble();

            if (lt == 0){
                throw new ArithmeticException("Dividione per zero non permessa");
            }

            double kmLt = km / lt;
            System.out.printf("Consumo: %.2f km/litro%n", kmLt);
        }catch (ArithmeticException e){
            LOGGER.log(Level.WARNING, "Tentativo di divisione per zero", e);
            System.out.println("Errore: impossibile dividere per zero");
        }catch (Exception e){
            LOGGER.log(Level.SEVERE, "Errore nell'input", e);
            System.out.println("Errore: input non valido");
        }finally {
            scanner.close();
        }
    }
}
