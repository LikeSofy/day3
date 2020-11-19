package com.sofy.studing.service;

import com.sofy.studing.entity.*;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class GroupeServiceTest {
    public EducationalEstablishment educationalEstablishmentForTest(){
        Subject[] subjects = new Subject[2];
        Student[] students = new Student[3];
        Groupe[] groupes = new Groupe[3];
        subjects[0] = new Subject("subject1", new int[]{1, 2, 3, 4, 5, 6});
        subjects[1] = new Subject("subject2", new int[]{1, 2, 3, 4, 5, 6});
        students[0] = new Student(1, "Student1", "Student1", "Student1", subjects, new Birthday(1, 1, 2005), "", "");
        students[1] = new Student(1, "Student2", "Student2", "Student2", subjects, new Birthday(1, 1, 2006), "", "");
        students[2] = new Student(1, "Student3", "Student3", "Student3", subjects, new Birthday(1, 1, 2004), "", "");
        groupes[0] = new Groupe("POIT", 10701119, 2, students);
        students = new Student[3];
        students[0] = new Student(4, "Student4", null, null, null, new Birthday(1, 1, 2007), null, null);
        students[1] = new Student(5, "Student5", null, null, null, new Birthday(1, 1, 2002), null, null);
        students[2] = new Student(6, "Student6", null, null, null, new Birthday(1, 1, 2005), null, null);
        groupes[1] = new Groupe("ATF", 10701119, 3, students);
        students = new Student[3];
        students[0] = new Student(4, "Student7", null, null, null, new Birthday(1, 1, 2000), null, null);
        students[1] = new Student(5, "Student8", null, null, null, new Birthday(1, 1, 2000), null, null);
        students[2] = new Student(6, "Student9", null, null, null, new Birthday(1, 1, 2000), null, null);
        groupes[2] = new Groupe("POIT", 10701119, 2, students);

        return new EducationalEstablishment(null, groupes);
    }

    @Test
    public void findAverageGroupScoreTest() {
        GroupeService service = new GroupeService();
        EducationalEstablishment educationalEstablishment = educationalEstablishmentForTest();
        double actual = service.calculateAverageGradeInGroup(educationalEstablishment.getGroupes()[0]);
        assertEquals(actual, 3.5);
    }

    @Test
    public void getStudetsBornAfterTest() {
        GroupeService service = new GroupeService();
        EducationalEstablishment educationalEstablishment = educationalEstablishmentForTest();
        Student[] actual = service.getStudetsBornAfter(educationalEstablishment, new Birthday(1, 1, 2005));
        Student[] expected = new Student[]{educationalEstablishment.getGroupes()[0].getStudents()[0],
                educationalEstablishment.getGroupes()[0].getStudents()[1],
                educationalEstablishment.getGroupes()[1].getStudents()[0],
                educationalEstablishment.getGroupes()[1].getStudents()[2],};

        assertTrue(Arrays.equals(expected, actual));
        assertEquals(Arrays.toString(actual), Arrays.toString(expected));
    }

    @Test
    public void getGroupesByFacultyTest() {
        String searchFacilty = "POIT";
        GroupeService service = new GroupeService();
        EducationalEstablishment educationalEstablishment = educationalEstablishmentForTest();
        Groupe[] actual = service.getGroupesByFaculty(educationalEstablishment, searchFacilty);
        Groupe[] expected = {educationalEstablishment.getGroupes()[0],
                educationalEstablishment.getGroupes()[2]};
        assertTrue(Arrays.equals(expected, actual));
    }

    @Test
    public void getGroupesByFacultyNumCourseTest() {
        String searchFacilty = "POIT";
        int numCourse = 2;
        GroupeService service = new GroupeService();
        EducationalEstablishment educationalEstablishment = educationalEstablishmentForTest();
        Groupe[] actual = service.getGroupesByFacultyNumCourse(educationalEstablishment, searchFacilty, numCourse);
        Groupe[] expected = {educationalEstablishment.getGroupes()[0],
                educationalEstablishment.getGroupes()[2]};
        assertTrue(Arrays.equals(expected, actual));
    }
}