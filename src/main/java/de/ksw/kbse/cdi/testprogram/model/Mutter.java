package de.ksw.kbse.cdi.testprogram.model;

import de.ksw.kbse.cdi.testprogram.interfaces.Person;
import javax.inject.Inject;
import javax.inject.Named;

public class Mutter implements Person {

    private String vorname;
    private String nachname;

    @Override
    public String getVorname() {
        return vorname;
    }

    @Override
    public String getNachname() {
        return nachname;
    }

    @Override
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    @Override
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    @Override
    public String toString() {
        return "Mutter{" + "vorname=" + vorname + ", nachname=" + nachname + '}';
    }
}
