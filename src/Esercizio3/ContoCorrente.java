package Esercizio3;

//classe contocorrente modificato
public class ContoCorrente {
    protected String titolare;
    protected int nMovimenti;
    protected final int maxMovimenti = 50;
    protected double saldo;

    public ContoCorrente(String titolare, double saldo){
        this.titolare = titolare;
        this.saldo = saldo;
        this.nMovimenti = 0;
    }

    public void preleva(double x) throws BancaException{
        if (nMovimenti < maxMovimenti){
            double nuovoSaldo = saldo - x;
            if (nuovoSaldo < 0){
                throw new BancaException("Il conto è in rosso");
            }
            saldo = nuovoSaldo;
        } else {
            saldo = saldo - x - 0.50;
        }
        nMovimenti++;
    }

    public double restituisciSaldo() {
        return saldo;
    }
}
