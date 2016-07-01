package de.ksw.kbse.cdi.testprogram.model;

import de.ksw.kbse.cdi.testprogram.interfaces.Person;
import de.ksw.kbse.cdi.testprogram.seeder.StudentenSeeder;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class Verwaltung {

    private List<Person> studentenListe = new ArrayList<>();

    @Inject
    public Verwaltung(StudentenSeeder studentenSeeder) {
        this.studentenListe = studentenSeeder.seed();
    }

    public void printStudentenListe() {
        System.out.println("StudentenListe:");
        studentenListe.stream().forEach((student) -> {
            System.out.println(student);
        });
    }
}
