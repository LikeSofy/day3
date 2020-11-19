package com.sofy.studing.report;

import com.sofy.studing.entity.Birthday;
import com.sofy.studing.entity.EducationalEstablishment;
import com.sofy.studing.entity.Groupe;
import com.sofy.studing.entity.Student;

import java.util.Arrays;
import java.util.Formatter;

import static java.lang.System.*;

public class StudentsReport {
    public void closesStudents(EducationalEstablishment educationalEstablishment, String searchFacilty, Groupe[] studentsByFaculty, int numCourse, Groupe[] studentsByFacultyNumCourse, Birthday day, Student[] studentsBornAfter, double averageGroupScore) {
        Formatter f = new Formatter();
        f.format(" .....closes..... :%nИсходные группы: %s", educationalEstablishment.toString());
        f.format("%nСтуденты факультета %s: %s", searchFacilty, Arrays.toString(studentsByFaculty));
        f.format("%nСтуденты факультета %s и %s: %s", searchFacilty, numCourse, Arrays.toString(studentsByFacultyNumCourse));
        f.format("%nСтуденты родившиеся после %s: %s", day, Arrays.toString(studentsBornAfter));
        f.format("%nСредний балл первой группы %f", averageGroupScore);
        out.print(f);
    }
}
