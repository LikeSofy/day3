package com.sofy.studing.service;

import java.lang.Math;

import com.sofy.studing.birthday.Birthday;
import com.sofy.studing.groupe.Groupe;
import com.sofy.studing.student.Student;
import com.sofy.studing.subject.Subject;

public class MainService {
    public Groupe[] createRandomGroupes() {
        final int NUMS_GROUPE = 5;
        final int NUMS_COURSES = 5;
        String[] facilty = {"facilty1", "facilty2", "facilty3", "facilty4", "facilty5"};
        int[] numGroupes = {10701100, 10701200, 10501100, 11201100, 10711100};

        Groupe[] groupes = new Groupe[NUMS_GROUPE];
        for (int i = 0; i < NUMS_GROUPE; i++) {
            String groupeFacilty = facilty[(int) (Math.random() * 5)];
            int numCourse = (int) (Math.random() * NUMS_COURSES);
            int numGroupe = numGroupes[(int) (Math.random() * 5)] + (2020 - numCourse);
            Student[] students = createRandomStudents(numGroupe);
            groupes[i] = new Groupe(groupeFacilty, numGroupe, numCourse, students);
        }

        return groupes;
    }

    private Student[] createRandomStudents(int groupe) {
        final int NUMS_STUDENTS = 10;
        String[] names = {"Denis", "Nikita", "Aleksandr", "Petr", "Zahar"};
        String[] lastNames = {"Margun", "Ivanchinko", "Kluchnik", "Petrov", "Ivanov"};
        String[] middleNames = {"Grigor'evich", "Konstantinovich", "Petrovich", "Zaharovich", "Aleksanrovich"};
        String[] addresses = {"Address 1", "Address 2", "Address 3", "Address 4", "Address 5"};
        String[] phones = {"phone1", "phone2", "phone3", "phone4", "phone5"};

        Student[] students = new Student[NUMS_STUDENTS];
        for (int i = 0; i < NUMS_STUDENTS; i++) {
            int id = groupe * 10 + i;
            String name = names[(int) (Math.random() * 5)];
            String lastName = lastNames[(int) (Math.random() * 5)];
            String middleName = middleNames[(int) (Math.random() * 5)];
            String address = addresses[(int) (Math.random() * 5)];
            String phone = phones[(int) (Math.random() * 5)];
            Subject[] subjects = createRandomSubjects();
            Birthday birthday = createRandomBirthday();
            students[i] = new Student(id, name, lastName, middleName, subjects, birthday, address, phone);
        }

        return students;
    }

    private Birthday createRandomBirthday() {
        int day = (int) (Math.random() * 28);
        int month = (int) (Math.random() * 12);
        int year = 2000 + (int) (Math.random() * 5);

        return new Birthday(day, month, year);
    }

    private Subject[] createRandomSubjects() {
        int randomNumSubjects = 5 + (int) (Math.random() * 5);
        Subject[] subjects = new Subject[randomNumSubjects];
        for (int i = 0; i < randomNumSubjects; i++) {
            String subjectName = "Subject" + i;
            int[] marks = createRandomMarks();
            subjects[i] = new Subject(subjectName, marks);
        }

        return subjects;
    }

    private int[] createRandomMarks() {
        int randomNumMarks = 3 + (int) (Math.random() * 5);
        int[] marks = new int[randomNumMarks];
        for (int i = 0; i < randomNumMarks; i++) {
            marks[i] = (int) (Math.random() * 10);
        }

        return marks;
    }
}
