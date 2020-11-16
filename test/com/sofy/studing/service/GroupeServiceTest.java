package com.sofy.studing.service;

import com.sofy.studing.groupe.Birthday;
import com.sofy.studing.groupe.Groupe;
import com.sofy.studing.groupe.Student;
import com.sofy.studing.groupe.Subject;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class GroupeServiceTest {
    @Test
    public void findAverageGroupScoreTest() {
        GroupeService service = new GroupeService();
        Student[] students = new Student[3];
        Subject[] subjects = new Subject[2];
        subjects[0] = new Subject("subject1", new int[]{1, 2, 3, 4, 5, 6});
        subjects[1] = new Subject("subject2", new int[]{1, 2, 3, 4, 5, 6});
        students[0] = new Student(1, "Student1", "Student1", "Student1", subjects, new Birthday(1, 1, 2000), "", "");
        students[1] = new Student(1, "Student2", "Student2", "Student2", subjects, new Birthday(1, 1, 2000), "", "");
        students[2] = new Student(1, "Student3", "Student3", "Student3", subjects, new Birthday(1, 1, 2000), "", "");
        Groupe groupe = new Groupe("POIT", 2, 10701119, students);
        double actual = service.calculateAverageGradeInGroup(groupe);
        assertEquals(actual, 3.5);
    }

    @Test
    public void getStudetsBornAfterTest() {
        GroupeService service = new GroupeService();
        Student[] students = new Student[3];
        Groupe[] groupes = new Groupe[2];
        students[0] = new Student(1, "Student1", null, null, null, new Birthday(1, 1, 2005), null, null);
        students[1] = new Student(2, "Student2", null, null, null, new Birthday(1, 1, 2006), null, null);
        students[2] = new Student(3, "Student3", null, null, null, new Birthday(1, 1, 2004), null, null);
        groupes[0] = new Groupe("POIT", 2, 10701119, students);
        students = new Student[3];
        students[0] = new Student(4, "Student4", null, null, null, new Birthday(1, 1, 2007), null, null);
        students[1] = new Student(5, "Student5", null, null, null, new Birthday(1, 1, 2002), null, null);
        students[2] = new Student(6, "Student6", null, null, null, new Birthday(1, 1, 2005), null, null);
        groupes[1] = new Groupe("POIT", 2, 10721119, students);
        Student[] actual = service.getStudetsBornAfter(groupes, new Birthday(1, 1, 2005));
        Student[] expected = new Student[]{new Student(1, "Student1", null, null, null, new Birthday(1, 1, 2005), null, null),
                new Student(2, "Student2", null, null, null, new Birthday(1, 1, 2006), null, null),
                new Student(4, "Student4", null, null, null, new Birthday(1, 1, 2007), null, null),
                new Student(6, "Student6", null, null, null, new Birthday(1, 1, 2005), null, null)};

        assertEquals(Arrays.toString(actual), Arrays.toString(expected));
    }

    @Test
    public void getGroupesByFacultyTest() {
        String searchFacilty = "POIT";
        GroupeService service = new GroupeService();
        Groupe[] groupes = new Groupe[2];
        groupes[0] = new Groupe("POIT", 10701119, 2, null);
        groupes[1] = new Groupe("ATF", 10722118, 3, null);
        Groupe[] expected = {groupes[0]};
        Groupe[] actual = service.getGroupesByFaculty(groupes, searchFacilty);
        assertEquals(Arrays.toString(actual), Arrays.toString(expected));
    }

    @Test
    public void getGroupesByFacultyNumCourseTest() {
        String searchFacilty = "POIT";
        int numCourse = 2;
        GroupeService service = new GroupeService();
        Groupe[] groupes = new Groupe[3];
        groupes[0] = new Groupe("POIT", 10701119, 2, null);
        groupes[1] = new Groupe("ATF", 10722118, 3, null);
        groupes[2] = new Groupe("POIT", 10702219, 2, null);
        Groupe[] expected = {groupes[0], groupes[2]};
        Groupe[] actual = service.getGroupesByFacultyNumCourse(groupes, searchFacilty, numCourse);
        assertEquals(Arrays.toString(actual), Arrays.toString(expected));
    }
}