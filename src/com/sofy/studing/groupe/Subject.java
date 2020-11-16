package com.sofy.studing.groupe;

import java.util.Arrays;

public class Subject {
    private String subjectName;
    private int[] marks;

    public Subject(String subjectName, int[] marks) {
        this.subjectName = subjectName;
        this.marks = marks;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Subject{");
        sb.append("subjectName='").append(subjectName).append('\'');
        sb.append(", marks=").append(Arrays.toString(marks));
        sb.append('}');
        return sb.toString();
    }
}
