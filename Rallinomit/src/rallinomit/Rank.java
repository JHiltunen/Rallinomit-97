/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rallinomit;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Aleksi Rautiainen
 */
public class Rank {

    private final SimpleIntegerProperty sijoitus;
    private final SimpleStringProperty pelaaja;
    private final SimpleLongProperty aika;

    public Rank(int sijoitus, String pelaaja, long aika) {
        this.sijoitus = new SimpleIntegerProperty(sijoitus);
        this.pelaaja = new SimpleStringProperty(pelaaja);
        this.aika = new SimpleLongProperty(aika);
    }

    public SimpleStringProperty getPelaajaProperty() {
        return pelaaja;
    }

    public SimpleIntegerProperty getSijoitusProperty() {
        return sijoitus;
    }

    public SimpleLongProperty getAikaProperty() {
        return aika;
    }

    public String getPelaaja() {
        return pelaaja.get();
    }

    public int getSijoitus() {
        return sijoitus.get();
    }
    
    public long getAika() {
        return aika.get();
    }
}
