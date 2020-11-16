package com.sofy.studing.entity;

import java.util.Arrays;

public class Groupe {
    private String faculty;
    private int numGroupe;
    private int numCourse;
    private Student[] students;

    public Groupe(String faculty, int numGroupe, int numCourse, Student[] students) {
        this.faculty = faculty;
        this.numGroupe = numGroupe;
        this.numCourse = numCourse;
        this.students = students;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getNumGroupe() {
        return numGroupe;
    }

    public void setNumGroupe(int numGroupe) {
        this.numGroupe = numGroupe;
    }

    public int getNumCourse() {
        return numCourse;
    }

    public void setNumCourse(int numCourse) {
        this.numCourse = numCourse;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Groupe{");
        sb.append("faculty='").append(faculty).append('\'');
        sb.append(", numGroupe=").append(numGroupe);
        sb.append(", numCourse=").append(numCourse);
        sb.append(", students=").append(Arrays.toString(students));
        sb.append('}');
        return sb.toString();
    }
}
