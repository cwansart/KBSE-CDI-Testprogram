package de.ksw.kbse.cdi.testprogram;

import de.ksw.kbse.cdi.testprogram.model.Verwaltung;
import de.ksw.kbse.di.CDIC;

public class App {

    public static void main(String[] args) {
        CDIC cdic = new CDIC();
        Verwaltung verwaltung = cdic.init(Verwaltung.class);
        verwaltung.printStudentenListe();
    }
}
