package ohtu.verkkokauppa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Pankki implements PankkiInterface {

    /* private static Pankki instanssi; //staattinen muuttuja säilöö luokan ainoan olion

    public static Pankki getInstance() { //ja staattinen metodi palauttaa luokan ainoan olion
        if (instanssi == null) {
            instanssi = new Pankki();
        }

        return instanssi;
    } */
    @Autowired
    private KirjanpitoInterface kirjanpito;

    /* public Pankki(KirjanpitoInterface kirj) {
        kirjanpito = kirj;//Kirjanpito.getInstance();
    } */

    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa) {
        kirjanpito.lisaaTapahtuma("tilisiirto: tililtä " + tilille + " tilille " + tilille
                + " viite " + viitenumero + " summa " + summa + "e");

        // täällä olisi koodi joka ottaa yhteyden pankin verkkorajapintaan
        return true;
    }
}
