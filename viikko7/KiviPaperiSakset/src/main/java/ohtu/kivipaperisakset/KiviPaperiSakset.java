package ohtu.kivipaperisakset;
import java.util.Scanner;

public abstract class KiviPaperiSakset {
    protected final Scanner scanner; 
    protected final Tuomari tuomari;
   
    // tämä on ns template metodi, eli aliluokkien toteutusten yhteiset askeleet toteuttava metodi
    protected KiviPaperiSakset(Scanner scanner) {
        this.scanner = new Scanner(System.in);
        this.tuomari = new Tuomari();
    }
    
    public static KiviPaperiSakset luoKPSParempiTekoaly(Scanner scanner) {
        return new KPSParempiTekoaly(scanner, new TekoalyParannettu(20) );
    } 

    public static KiviPaperiSakset luoKPSTekoaly(Scanner scanner) {
        return new KPSTekoaly(scanner, new TekoalyHuonompi());
    } 

    public static KiviPaperiSakset luoKPSPelaajaVsPelaaja(Scanner scanner) {
        return new KPSPelaajaVsPelaaja(scanner);
    }
    
    public void pelaa() {
        
        String ekanSiirto = ensimmaisenSiirto();
        String tokanSiirto = toisenSiirto(ekanSiirto);
        
        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            ekanSiirto = ensimmaisenSiirto();
            tokanSiirto = toisenSiirto(ekanSiirto);
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }
    
    protected String ensimmaisenSiirto() {
        System.out.print("Ensimmäisen pelaajan siirto: ");
        return scanner.nextLine();
    }

    // tämä on abstrakti metodi sillä sen toteutus vaihtelee eri pelityypeissä
    abstract protected String toisenSiirto(String ekanSiirto);
    
    protected static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

}