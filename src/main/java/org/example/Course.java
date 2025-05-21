package org.example;

public class Course {
    private int id;
    private String course_name;
    private String course_description;

    public Course(int id, String course_name, String course_description) {
        this.id = id;
        this.course_name = course_name;
        this.course_description = course_description;
    }

    public Course(String course_name, String course_description) {
        this.course_name = course_name;
        this.course_description = course_description;
    }

    public int getId() {
        return id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public String getCourse_description() {
        return course_description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }
}