package com.sofy.studing.report;

import com.sofy.studing.groupe.Birthday;
import com.sofy.studing.groupe.Groupe;
import com.sofy.studing.groupe.Student;

import java.util.Arrays;

import static java.lang.System.*;

public class StudentsReport {
    public void closesStudents(Groupe[] groupes, String searchFacilty, Groupe[] studentsByFaculty, int numCourse, Groupe[] studentsByFacultyNumCourse, Birthday day, Student[] studentsBornAfter, double averageGroupScore) {
        out.println(" .....closes..... :\n");
        out.print("Исходные группы" + Arrays.toString(groupes));
        out.print("\nСтуденты факультета " + searchFacilty + ": " + Arrays.toString(studentsByFaculty));
        out.print("\nСтуденты факультета " + searchFacilty + " и " + numCourse + " курса" + ": " + Arrays.toString(studentsByFacultyNumCourse));
        out.print("\nСтуденты родившиеся после " + day + ": " + Arrays.toString(studentsBornAfter));
        out.print("\nСредний балл первой группы " + averageGroupScore);
    }
}
