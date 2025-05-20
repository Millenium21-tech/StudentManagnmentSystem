package org.example;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class StudentDAOImpleme implements StudentDAO {
    @Override
    public void addStudent(Student student) {
        String sql = "INSERT INTO students(first_name,last_name,email,date_of_birth) VALUES(?,?,?,?)";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement st = conn.prepareStatement(sql)){
            st.setString(1, student.getFirst_name());
            st.setString(2, student.getLast_name());
            st.setString(3,student.getEmail());
            st.setDate(4, Date.valueOf(student.getBirth_date()));
            st.executeUpdate();
            System.out.println("Student added successfully");
        }catch (Exception e){
            System.out.println("error happened while creating student"+e.getMessage());
        }
    }

    @Override
    public Student getStudent(int id) {
//        String sql = "SELECT * FROM students WHERE id=?";
//        try(Connection con = DBConnection.getConnection();
//        PreparedStatement st = con.prepareStatement(sql)){
//            st.setInt(1,id);
//            Result
//        }
//        )
        return null;
    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void deleteStudent(int id) {

    }
}
