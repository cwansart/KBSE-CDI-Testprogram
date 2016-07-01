package de.ksw.kbse.cdi.testprogram.model;

import de.ksw.kbse.cdi.testprogram.interfaces.Person;
import javax.inject.Named;

@Named("verwalter")
public class Verwalter implements Person {

    private String vorname = "Alter";
    private String nachname = "Verwalter";

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
        return "Verwalter{" + "vorname=" + vorname + ", nachname=" + nachname + '}';
    }
}
