package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Erotus extends Komento {

    public Erotus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        sovellus.miinus(Integer.valueOf(syotekentta.getText()));
        tuloskentta.setText(String.valueOf(sovellus.tulos()));
        edellisetSyotteet.add(Integer.valueOf(syotekentta.getText()));
        syotekentta.setText("");
       
    }

    @Override
    public void peru() {
        System.out.println("koko: "+edellisetSyotteet.size());
        if (edellisetSyotteet.size()>=2) {
            int edellinenSyote = edellisetSyotteet.get(edellisetSyotteet.size()-1);
            System.out.println(">=2: "+edellinenSyote);
            sovellus.plus(edellinenSyote);
        } 
        else if (edellisetSyotteet.size()==1) {
            int edellinenSyote = edellisetSyotteet.get(0);
            sovellus.plus(edellinenSyote);
        }
        else {
            System.out.println("else");
            sovellus.nollaa();
        }
        this.tuloskentta.setText(String.valueOf(sovellus.tulos()));
    }

}