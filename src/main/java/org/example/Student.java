package org.example;

import java.time.LocalDate;

public class Student {
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private LocalDate birth_date;

//    public Student(int id, String first_name, String last_name, String email, LocalDate birth_date) {
//        this.id = id;
//        this.first_name = first_name;
//        this.last_name = last_name;
//        this.email = email;
//        this.birth_date = birth_date;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", birth_date=" + birth_date +
                '}';
    }
}
