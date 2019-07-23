package app.course;

import app.beanknowledge.Student;

public class Course {

    private Student[] stds;
    private String description;
    private int courseSize = 20;
    private int studentOnCourse = 0;

    public Course(String description) {
        this.description = description;
        stds = new Student[courseSize];
    }

    public boolean add(Student student) {
        if (courseSize == studentOnCourse) {
            System.out.println("The course is full");
            return false;
        } else {
            for (int i = 0; i < stds.length; i++) {
                if (stds[i] == null) {
                    stds[i] = student;
                    studentOnCourse++;
                    break;
                }
            }
            return true;
        }
    }

    public Student getAddedStudent() {
        return stds[studentOnCourse-1];
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "init course + - " + description;
    }
}