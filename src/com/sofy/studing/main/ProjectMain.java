package com.sofy.studing.main;

import com.sofy.studing.entity.Birthday;
import com.sofy.studing.entity.EducationalEstablishment;
import com.sofy.studing.entity.Groupe;
import com.sofy.studing.report.StudentsReport;
import com.sofy.studing.service.MainService;
import com.sofy.studing.service.GroupeService;
import com.sofy.studing.entity.Student;


public class ProjectMain {
    public static void main(String[] args){
        MainService serviceCreate = new MainService();
        EducationalEstablishment educationalEstablishment = serviceCreate.createRandomEducationalEstablishment();
        GroupeService service = new GroupeService();
        String searchFacilty = "facilty2";
        int numCourse = 2;
        Groupe[] studentsByFaculty = service.getGroupesByFaculty(educationalEstablishment, searchFacilty);
        Groupe[] studentsByFacultyNumCourse = service.getGroupesByFacultyNumCourse(educationalEstablishment, searchFacilty, numCourse);
        Birthday day = new Birthday(1, 1, 2001);
        Student[] studentsBornAfter = service.getStudetsBornAfter(educationalEstablishment, day);
        double averageGroupScore = service.calculateAverageGradeInGroup(educationalEstablishment.getGroupes()[0]);
        StudentsReport report = new StudentsReport();
        report.closesStudents(educationalEstablishment, searchFacilty, studentsByFaculty, numCourse, studentsByFacultyNumCourse, day, studentsBornAfter, averageGroupScore);
    }

}
