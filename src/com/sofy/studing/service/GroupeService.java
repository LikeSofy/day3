package com.sofy.studing.service;

import com.sofy.studing.entity.EducationalEstablishment;
import com.sofy.studing.entity.Groupe;
import com.sofy.studing.entity.Student;
import com.sofy.studing.entity.Birthday;

public class GroupeService {
    public Groupe[] getGroupesByFaculty(EducationalEstablishment educationalEstablishment, String faculty) {
        Groupe[] groupes = educationalEstablishment.getGroupes();
        int lengthGroupeArr = getLengthArrGroupesByFaculty(groupes, faculty);
        Groupe[] filteredGroupes = new Groupe[lengthGroupeArr];
        int k = 0;
        int i = 0;
        while (i < groupes.length) {
            if (groupes[i].getFaculty() != null && groupes[i].getFaculty().equals(faculty)) {
                filteredGroupes[k] = groupes[i];
                k++;
            }
            i++;
        }

        return filteredGroupes;
    }

    private int getLengthArrGroupesByFaculty(Groupe[] groupes, String faculty) {
        int length = 0;
        int i = 0;
        while (i < groupes.length) {
            if (groupes[i].getFaculty() != null && groupes[i].getFaculty().equals(faculty)) {
                length++;
            }
            i++;
        }

        return length;
    }

    public Groupe[] getGroupesByFacultyNumCourse(EducationalEstablishment educationalEstablishment, String faculty, int numCourse) {
        Groupe[] groupes = educationalEstablishment.getGroupes();
        Groupe[] filteredGroupes = new Groupe[getLengthArrByFacultyNumCourse(groupes, faculty, numCourse)];
        int j = 0;
        int i = 0;
        while (i < groupes.length) {
            if (groupes[i].getFaculty() != null && groupes[i].getFaculty().equals(faculty) && groupes[i].getNumCourse() == numCourse) {
                filteredGroupes[j] = groupes[i];
                j++;
            }
            i++;
        }

        return filteredGroupes;
    }

    private int getLengthArrByFacultyNumCourse(Groupe[] groupes, String faculty, int numCourse) {
        int length = 0;
        int i = 0;
        while (i < groupes.length) {
            if (groupes[i].getFaculty() != null && groupes[i].getFaculty().equals(faculty) && groupes[i].getNumCourse() == numCourse) {
                length++;
            }
            i++;
        }

        return length;
    }

    public Student[] getStudetsBornAfter(EducationalEstablishment educationalEstablishment, Birthday day) {
        Groupe[] groupes = educationalEstablishment.getGroupes();
        int lengthStudentsArr = getLengthArrByBornAfter(groupes, day);
        Student[] students = new Student[lengthStudentsArr];
        int k = 0;
        int i = 0;
        while (i < groupes.length) {
            for (int j = 0; j < groupes[i].getStudents().length; j++) {
                if (date1AfterDate2(groupes[i].getStudents()[j].getBirthday(), day)) {
                    students[k] = groupes[i].getStudents()[j];
                    k++;
                }
            }
            i++;
        }

        return students;
    }

    private int getLengthArrByBornAfter(Groupe[] groupes, Birthday day) {
        int length = 0;
        int i = 0;
        while (i < groupes.length) {
            for (int j = 0; j < groupes[i].getStudents().length; j++) {
                if (date1AfterDate2(groupes[i].getStudents()[j].getBirthday(), day)) {
                    length++;
                }
            }
            i++;
        }

        return length;
    }

    public double calculateAverageGradeInGroup(Groupe groupe) {
        Student[] students = groupe.getStudents();
        double sumMarks = 0;
        int numMarks = 0;
        double averageGrade;
        int i = 0;
        while (i < students.length) {
            for (int j = 0; j < students[i].getSubjects().length; j++) {
                for (int k = 0; k < students[i].getSubjects()[j].getMarks().length; k++) {
                    numMarks++;
                    sumMarks += students[i].getSubjects()[j].getMarks()[k];
                }
            }
            i++;
        }
        if (numMarks == 0) {
            averageGrade = 0;
        } else {
            averageGrade = sumMarks / numMarks;
        }

        return averageGrade;
    }

    private boolean date1AfterDate2(Birthday date1, Birthday date2) {
        boolean yearAfter = (date1.getYearBirthday() > date2.getYearBirthday());
        boolean monAfter = (date1.getYearBirthday() == date2.getYearBirthday() && date1.getMonthBirthday() > date2.getMonthBirthday());
        boolean dayAfter = ((date1.getYearBirthday() == date2.getYearBirthday() && date1.getMonthBirthday() == date2.getMonthBirthday() && date1.getDayBirthday() >= date2.getDayBirthday()));
        return yearAfter || monAfter || dayAfter;
    }

}
