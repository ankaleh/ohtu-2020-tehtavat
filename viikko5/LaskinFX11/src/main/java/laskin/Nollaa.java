package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa extends Komento {

    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        sovellus.nollaa();
        tuloskentta.setText("0");
        edellisetSyotteet.add(Integer.valueOf(syotekentta.getText()));
        syotekentta.setText("");
    }

    @Override
    public void peru() {
        if (edellisetSyotteet.size()>=2) {
            int edellinenSyote = edellisetSyotteet.get(edellisetSyotteet.size()-1);
            sovellus.plus(edellinenSyote);
        } 
        else if (edellisetSyotteet.size()==1) {
            int edellinenSyote = edellisetSyotteet.get(0);
            sovellus.plus(edellinenSyote);
        }
        else {
            sovellus.nollaa();
        }
        this.tuloskentta.setText(String.valueOf(sovellus.tulos()));
        
    }

    
}