package laskin;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa extends Komento {
    //private List<Integer> edellisetSyotteet;

    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        sovellus.plus(Integer.valueOf(syotekentta.getText()));
        tuloskentta.setText(String.valueOf(sovellus.tulos()));
        edellisetSyotteet.add(Integer.valueOf(syotekentta.getText()));
        syotekentta.setText("");
    }

    @Override
    public void peru() {
        //System.out.println("koko: "+edellisetSyotteet.size());
        if (edellisetSyotteet.size()>=2) {
            int edellinenSyote = edellisetSyotteet.get(edellisetSyotteet.size()-1);
            System.out.println(">=2: "+edellinenSyote);
            sovellus.miinus(edellinenSyote);
        } 
         else if (edellisetSyotteet.size()==1) {
            int edellinenSyote = edellisetSyotteet.get(0);
            //System.out.println("==1: "+edellinenSyote);
            sovellus.miinus(edellinenSyote);
        }
        else {
            //System.out.println("else");
            sovellus.nollaa();
        }
        this.tuloskentta.setText(String.valueOf(sovellus.tulos()));
        
    }
}