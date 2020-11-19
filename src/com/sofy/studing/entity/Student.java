package com.sofy.studing.entity;

import java.util.Arrays;
import java.util.Objects;

public class Student {
    private int idStudent;
    private String firstName;
    private String lastName;
    private String middleName;
    private Subject[] subjects;
    private Birthday birthday;
    private String adress;
    private String phone;

    public Student(int idStudent, String firstName, String lastName, String middleName, Subject[] subjects, Birthday birthday, String adress, String phone) {
        this.idStudent = idStudent;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.subjects = subjects;
        this.birthday = birthday;
        this.adress = adress;
        this.phone = phone;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Subject[] getSubjects() {
        return subjects;
    }

    public void setSubjects(Subject[] subjects) {
        this.subjects = subjects;
    }

    public Birthday getBirthday() {
        return birthday;
    }

    public void setBirthday(Birthday birthday) {
        this.birthday = birthday;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return idStudent == student.idStudent &&
                Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(middleName, student.middleName) &&
                Arrays.equals(subjects, student.subjects) &&
                Objects.equals(birthday, student.birthday) &&
                Objects.equals(adress, student.adress) &&
                Objects.equals(phone, student.phone);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(idStudent, firstName, lastName, middleName, birthday, adress, phone);
        result = 31 * result + Arrays.hashCode(subjects);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("idStudent=").append(idStudent);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", middleName='").append(middleName).append('\'');
        sb.append(", subjects=").append(Arrays.toString(subjects));
        sb.append(", birthday=").append(birthday);
        sb.append(", adress='").append(adress).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
