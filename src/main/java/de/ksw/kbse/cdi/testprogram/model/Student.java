package de.ksw.kbse.cdi.testprogram.model;

import de.ksw.kbse.cdi.testprogram.interfaces.Person;
import de.ksw.kbse.cdi.testprogram.interfaces.Auto;
import de.ksw.kbse.cdi.testprogram.qualifier.Ford;
import javax.inject.Inject;
import javax.inject.Named;

@Named("student")
public class Student implements Person {

    private String vorname;
    private String nachname;

    @Inject
    @Ford
    private Auto auto;

    @Inject
    private Mutter mutter;

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

    public Mutter getMutter() {
        return mutter;
    }
    
    public String getMutterStr() {
        return mutter.toString();
    }

    public String getAuto() {
        return auto.getMarke() + " " + auto.getModell();
    }

    @Override
    public String toString() {
        return "Student{" + "vorname=" + vorname + ", nachname=" + nachname + ", auto=" + auto + ", mutter=" + mutter + '}';
    }
}
