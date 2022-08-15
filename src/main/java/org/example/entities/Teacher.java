package org.example.entities;

import java.util.Objects;

public class Teacher {
    private int id;
    private String name;
    private String subject;
    private String grade;

    public Teacher() {}

    public Teacher(int id) {
        this.id = id;
    }

    public Teacher(int id, String name, String subject, String grade) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return id == teacher.id && Objects.equals(name, teacher.name) && Objects.equals(subject, teacher.subject) && Objects.equals(grade, teacher.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, subject, grade);
    }

}
