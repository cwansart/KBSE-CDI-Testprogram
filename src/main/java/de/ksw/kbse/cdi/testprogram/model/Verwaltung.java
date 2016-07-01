package de.ksw.kbse.cdi.testprogram.model;

import de.ksw.kbse.cdi.testprogram.interfaces.Person;
import de.ksw.kbse.cdi.testprogram.seeder.StudentenSeeder;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

public class Verwaltung {

    @Inject
    @Named("verwalter")
    private Person verwalter;

    private List<Person> studentenListe = new ArrayList<>();

    @Inject
    public Verwaltung(StudentenSeeder studentenSeeder) {
        this.studentenListe = studentenSeeder.seed();
    }

    public void printStudentenListe() {
        System.out.println("Verwaltet von " + verwalter);
        System.out.println("StudentenListe:");
        studentenListe.stream().forEach((student) -> {
            System.out.println(student);
        });
    }
}
