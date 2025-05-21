
package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class MarkDAOImpl implements MarkDAO {
    @Override
    public void addOrUpdateMark(Mark mark) {
        String sql = "INSERT INTO marks(student_id, course_id, marks) VALUES(?, ?, ?) ON CONFLICT (student_id, course_id) DO UPDATE SET marks = excluded.marks";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, mark.getStudent_id());
            st.setInt(2, mark.getCourse_id());
            st.setFloat(3, mark.getMarks());
            st.executeUpdate();
            System.out.println("Mark inserted/updated successfully");
        } catch (Exception e) {
            System.out.println("Error inserting/updating mark: " + e.getMessage());
        }
    }

    @Override
    public Mark getMark(int student_id, int course_id) {
        String sql = "SELECT * FROM marks WHERE student_id = ? AND course_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, student_id);
            st.setInt(2, course_id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Mark(
                        rs.getInt("student_id"),
                        rs.getInt("course_id"),
                        rs.getFloat("marks")
                );
            }
        } catch (Exception e) {
            System.out.println("Error fetching mark: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Mark> getAllMarksForStudent(int student_id) {
        List<Mark> marks = new ArrayList<>();
        String sql = "SELECT * FROM marks WHERE student_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, student_id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                marks.add(new Mark(
                        rs.getInt("student_id"),
                        rs.getInt("course_id"),
                        rs.getFloat("marks")
                ));
            }
        } catch (Exception e) {
            System.out.println("Error retrieving marks: " + e.getMessage());
        }
        return marks;
    }

    @Override
    public void deleteMark(int student_id, int course_id) {
        String sql = "DELETE FROM marks WHERE student_id = ? AND course_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, student_id);
            st.setInt(2, course_id);
            st.executeUpdate();
            System.out.println("Mark deleted successfully");
        } catch (Exception e) {
            System.out.println("Error deleting mark: " + e.getMessage());
        }
    }
}