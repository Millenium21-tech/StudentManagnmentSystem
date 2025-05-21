package org.example;

public class Mark {
    private int student_id;
    private int course_id;
    private float marks;

    public Mark(int student_id, int course_id, float marks) {
        this.student_id = student_id;
        this.course_id = course_id;
        this.marks = marks;
    }

    public int getStudent_id() {
        return student_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public float getMarks() {
        return marks;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public void setMarks(float marks) {
        this.marks = marks;
    }
}
