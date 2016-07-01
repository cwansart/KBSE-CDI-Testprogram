package de.ksw.kbse.cdi.testprogram.factories;

import de.ksw.kbse.cdi.testprogram.model.Student;
import de.ksw.kbse.di.CDIC;

public class StudentFactory {

    private static CDIC cdic = new CDIC();

    public static Student getStudent() {
        return cdic.init(Student.class);
    }
}
