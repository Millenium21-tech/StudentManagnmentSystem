package org.example;

import java.util.List;

public interface MarkDAO {
    void addOrUpdateMark(Mark mark);
    Mark getMark(int student_id, int course_id);
    List<Mark> getAllMarksForStudent(int student_id);
    void deleteMark(int student_id, int course_id);
}