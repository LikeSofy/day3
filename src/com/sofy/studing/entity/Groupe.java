package com.sofy.studing.entity;

import java.util.Arrays;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Groupe groupe = (Groupe) o;
        return numGroupe == groupe.numGroupe &&
                numCourse == groupe.numCourse &&
                Objects.equals(faculty, groupe.faculty) &&
                Arrays.equals(students, groupe.students);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(faculty, numGroupe, numCourse);
        result = 31 * result + Arrays.hashCode(students);
        return result;
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
