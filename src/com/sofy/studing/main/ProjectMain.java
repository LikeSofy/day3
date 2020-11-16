package com.sofy.studing.main;

import com.sofy.studing.birthday.Birthday;
import com.sofy.studing.groupe.Groupe;
import com.sofy.studing.report.StudentsReport;
import com.sofy.studing.service.MainService;
import com.sofy.studing.service.GroupeService;
import com.sofy.studing.student.Student;


public class ProjectMain {
    public static void main(String[] args){
        MainService serviceCreate = new MainService();
        Groupe[] groupes = serviceCreate.createRandomGroupes();
        GroupeService service = new GroupeService();
        String searchFacilty = "facilty2";
        int numCourse = 2;
        Groupe[] studentsByFaculty = service.getGroupesByFaculty(groupes, searchFacilty);
        Groupe[] studentsByFacultyNumCourse = service.getGroupesByFacultyNumCourse(groupes, searchFacilty, numCourse);
        Birthday day = new Birthday(1, 1, 2001);
        Student[] studentsBornAfter = service.getStudetsBornAfter(groupes, day);
        double averageGroupScore = service.calculateAverageGradeInGroup(groupes[0]);
        StudentsReport report = new StudentsReport();
        report.closesStudents(groupes, searchFacilty, studentsByFaculty, numCourse, studentsByFacultyNumCourse, day, studentsBornAfter, averageGroupScore);
    }

}
