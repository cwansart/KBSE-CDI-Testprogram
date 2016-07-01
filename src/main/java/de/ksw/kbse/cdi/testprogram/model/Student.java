package de.ksw.kbse.cdi.testprogram.model;

import de.ksw.kbse.cdi.testprogram.interfaces.Person;
import de.ksw.kbse.cdi.testprogram.interfaces.Auto;
import de.ksw.kbse.cdi.testprogram.qualifier.Ford;
import javax.inject.Inject;

public class Student implements Person {

    private String vorname;
    private String nachname;

    @Inject
    @Ford
    private Auto auto;

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
        return "Student{" + "vorname=" + vorname + ", nachname=" + nachname + ", auto=" + auto + '}';
    }
}
