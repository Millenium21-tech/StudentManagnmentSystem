package org.example;

import java.util.List;

public interface CourseDAO {
    void addCourse(Course course);
    Course getCourse(int id);
    List<Course> getAllCourses();
    void updateCourse(Course course);
    void deleteCourse(int id);
}
