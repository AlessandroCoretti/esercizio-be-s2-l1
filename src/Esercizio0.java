public class Esercizio0 {
    public static void main(String[] args) {
        // creo Array
        int[] numeri = {10, 33, 2, 6, 24};

        for (int i = 0; i < numeri.length - 1; i++){
            for (int j = 0; j < numeri.length - i - 1; j++){
                if (numeri[j] > numeri[j + 1]){
                    // scambio elementi
                    int temp = numeri[j];
                    numeri[j] = numeri[j + 1];
                    numeri[j + 1] = temp;
                }
            }

            // stampa lo stao dell'array dopo ogni passaggio
            System.out.println("Passagggio" + (i + 1) + ": ");
            for (int num : numeri){
                System.out.println(num + " ");
            }
            System.out.println();
        }
    }
}
