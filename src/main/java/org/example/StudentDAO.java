package org.example;

public interface StudentDAO {
    public void addStudent(Student student);
    public Student getStudent(int id);
    public void updateStudent(Student student);
    public void deleteStudent(int id);
}
