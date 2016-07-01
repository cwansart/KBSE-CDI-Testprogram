package de.ksw.kbse.cdi.testprogram.implementation;

import de.ksw.kbse.cdi.testprogram.interfaces.Auto;
import de.ksw.kbse.cdi.testprogram.qualifier.Ford;

@Ford
public class FordAuto implements Auto {

    private final String marke = "Ford";
    private final String modell = "Fiesta";

    @Override
    public String getMarke() {
        return marke;
    }

    @Override
    public String getModell() {
        return modell;
    }

    @Override
    public String toString() {
        return "FordAuto{" + "marke=" + marke + ", modell=" + modell + '}';
    }
}
