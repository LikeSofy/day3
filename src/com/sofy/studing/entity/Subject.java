package com.sofy.studing.entity;

import java.util.Arrays;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Objects.equals(subjectName, subject.subjectName) &&
                Arrays.equals(marks, subject.marks);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(subjectName);
        result = 31 * result + Arrays.hashCode(marks);
        return result;
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
