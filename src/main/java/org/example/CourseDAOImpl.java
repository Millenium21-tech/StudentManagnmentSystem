package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {
    @Override
    public void addCourse(Course course) {
        String sql = "INSERT INTO courses(course_name, course_description) VALUES(?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, course.getCourse_name());
            st.setString(2, course.getCourse_description());
            st.executeUpdate();
            System.out.println("Course added successfully");
        } catch (Exception e) {
            System.out.println("Error adding course: " + e.getMessage());
        }
    }

    @Override
    public Course getCourse(int id) {
        String sql = "SELECT * FROM courses WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Course(
                        rs.getInt("id"),
                        rs.getString("course_name"),
                        rs.getString("course_description")
                );
            }
        } catch (Exception e) {
            System.out.println("Error getting course: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM courses";
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                courses.add(new Course(
                        rs.getInt("id"),
                        rs.getString("course_name"),
                        rs.getString("course_description")
                ));
            }
        } catch (Exception e) {
            System.out.println("Error fetching courses: " + e.getMessage());
        }
        return courses;
    }

    @Override
    public void updateCourse(Course course) {
        String sql = "UPDATE courses SET course_name = ?, course_description = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, course.getCourse_name());
            st.setString(2, course.getCourse_description());
            st.setInt(3, course.getId());
            st.executeUpdate();
            System.out.println("Course updated successfully");
        } catch (Exception e) {
            System.out.println("Error updating course: " + e.getMessage());
        }
    }

    @Override
    public void deleteCourse(int id) {
        String sql = "DELETE FROM courses WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, id);
            st.executeUpdate();
            System.out.println("Course deleted successfully");
        } catch (Exception e) {
            System.out.println("Error deleting course: " + e.getMessage());
        }
    }
}

