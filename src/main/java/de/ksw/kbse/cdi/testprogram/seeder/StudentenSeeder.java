package de.ksw.kbse.cdi.testprogram.seeder;

import de.ksw.kbse.cdi.testprogram.factories.StudentFactory;
import de.ksw.kbse.cdi.testprogram.interfaces.Seeder;
import de.ksw.kbse.cdi.testprogram.interfaces.Person;
import de.ksw.kbse.cdi.testprogram.model.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentenSeeder implements Seeder {

    private final List<Person> studentenListe = new ArrayList<>();

    private final String[] vornamen = {
        "Mia",
        "Ben",
        "Emma",
        "Luca",
        "Hannah",
        "Jonas",
        "Sofia",
        "Leon",
        "Lea",
        "Lukas",
        "Larissa",
        "Noah",
        "Lina",
        "Elias"
    };
    
    private final String[] mutterNamen = {
        "Mia",
        "Emma",
        "Hannah",
        "Sofia",
        "Lea",
        "Larissa",
        "Lina"
    };

    private final String[] nachnamen = {
        "Müller",
        "Schmidt",
        "Schneider",
        "Fischer",
        "Weber",
        "Meier",
        "Becker",
        "Wagner",
        "Schulz",
        "Hoffmann",
        "Bauer",
        "Schäfer"
    };

    public final int COUNT = 20;

    @Override
    public List<Person> seed() {
        Random random = new Random();
        for (int i = 0; i < COUNT; i++) {
            String nachname = nachnamen[random.nextInt(nachnamen.length)];
            Student student = StudentFactory.getStudent();
            student.setVorname(vornamen[random.nextInt(vornamen.length)]);
            student.setNachname(nachname);
            student.getMutter().setVorname(mutterNamen[random.nextInt(mutterNamen.length)]);
            student.getMutter().setNachname(nachname);
            studentenListe.add(student);
        }
        
        return this.studentenListe;
    }
}
