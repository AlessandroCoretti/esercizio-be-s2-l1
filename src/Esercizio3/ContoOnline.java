package Esercizio3;

public class ContoOnline extends ContoCorrente{
    private double maxPrelievo;

    public ContoOnline(String titolare, double saldo, double maxP){
        super(titolare, saldo);
        this.maxPrelievo = maxP;
    }

    public void preleva(double x) throws BancaException{
        if (x > maxPrelievo){
            throw new BancaException("Il prelievo non è disponibile");
        }
        super.preleva(x);
    }

    public void stampaSaldo(){
        System.out.println("Titolare: " + titolare + "- Saldo: " + saldo + "- Num movimenti: " + nMovimenti + "- Massimo movimenti: " + maxMovimenti + "- Massimo prelievo possibile: " + maxPrelievo );
    }
}
