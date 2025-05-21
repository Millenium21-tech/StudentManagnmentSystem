package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpleme implements StudentDAO {

    @Override
    public void addStudent(Student student) {
        String sql = "INSERT INTO students(first_name, last_name, email, date_of_birth) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, student.getFirst_name());
            st.setString(2, student.getLast_name());
            st.setString(3, student.getEmail());
            st.setDate(4, Date.valueOf(student.getBirth_date()));
            st.executeUpdate();
            System.out.println("Student added successfully.");
        } catch (Exception e) {
            System.out.println("Error while creating student: " + e.getMessage());
        }
    }

    @Override
    public Student getStudent(int id) {
        String sql = "SELECT * FROM students WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Student(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getDate("date_of_birth").toLocalDate()
                );
            }
        } catch (Exception e) {
            System.out.println("Error retrieving student: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void updateStudent(Student student) {
        String sql = "UPDATE students SET first_name = ?, last_name = ?, email = ?, date_of_birth = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, student.getFirst_name());
            st.setString(2, student.getLast_name());
            st.setString(3, student.getEmail());
            st.setDate(4, Date.valueOf(student.getBirth_date()));
            st.setInt(5, student.getId());
            int updated = st.executeUpdate();
            if (updated > 0) {
                System.out.println("Student updated successfully.");
            } else {
                System.out.println("Student not found.");
            }
        } catch (Exception e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }

    @Override
    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, id);
            int deleted = st.executeUpdate();
            if (deleted > 0) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student not found.");
            }
        } catch (Exception e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getDate("date_of_birth").toLocalDate()
                ));
            }
        } catch (Exception e) {
            System.out.println("Error fetching students: " + e.getMessage());
        }
        return students;
    }
}
