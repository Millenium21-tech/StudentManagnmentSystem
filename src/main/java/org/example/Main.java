package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentDAOImpleme studentDAO = new StudentDAOImpleme();
        CourseDAOImpl courseDAO = new CourseDAOImpl();
        MarkDAOImpl marksDAO = new MarkDAOImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add student");
            System.out.println("2. View student by ID");
            System.out.println("3. View all students");
            System.out.println("4. Update student");
            System.out.println("5. Delete student");
            System.out.println("6. Add course");
            System.out.println("7. View all courses");
            System.out.println("8. Update course");
            System.out.println("9. Delete course");
            System.out.println("10. Add/Update mark");
            System.out.println("11. View all marks for student");
            System.out.println("12. Delete mark");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    Student student = new Student();
                    System.out.print("First name: ");
                    student.setFirst_name(scanner.nextLine());
                    System.out.print("Last name: ");
                    student.setLast_name(scanner.nextLine());
                    System.out.print("Email: ");
                    student.setEmail(scanner.nextLine());
                    System.out.print("Birth date (yyyy-MM-dd): ");
                    try {
                        student.setBirth_date(LocalDate.parse(scanner.nextLine()));
                        studentDAO.addStudent(student);
                        System.out.println("Student added.");
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid date format.");
                    }
                }
                case 2 -> {
                    System.out.print("Enter student ID: ");
                    try {
                        int id = Integer.parseInt(scanner.nextLine());
                        Student s = studentDAO.getStudent(id);
                        if (s != null) {
                            System.out.println("ID: " + s.getId() + ", Name: " + s.getFirst_name() + " " + s.getLast_name()
                                    + ", Email: " + s.getEmail() + ", DOB: " + s.getBirth_date());
                        } else {
                            System.out.println("Student not found.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID.");
                    }
                }
                case 3 -> {
                    System.out.println("--- All Students ---");
                    List<Student> students = studentDAO.getAllStudents();
                    for (Student st : students) {
                        System.out.println(st.getId() + ": " + st.getFirst_name() + " " + st.getLast_name() + " | Email: " + st.getEmail());
                    }
                }
                case 4 -> {
                    System.out.print("Enter student ID to update: ");
                    try {
                        int uid = Integer.parseInt(scanner.nextLine());
                        Student stuToUpdate = studentDAO.getStudent(uid);
                        if (stuToUpdate != null) {
                            System.out.print("New first name (" + stuToUpdate.getFirst_name() + "): ");
                            String input = scanner.nextLine();
                            if (!input.isBlank()) stuToUpdate.setFirst_name(input);

                            System.out.print("New last name (" + stuToUpdate.getLast_name() + "): ");
                            input = scanner.nextLine();
                            if (!input.isBlank()) stuToUpdate.setLast_name(input);

                            System.out.print("New email (" + stuToUpdate.getEmail() + "): ");
                            input = scanner.nextLine();
                            if (!input.isBlank()) stuToUpdate.setEmail(input);

                            System.out.print("New birth date (yyyy-MM-dd) (" + stuToUpdate.getBirth_date() + "): ");
                            input = scanner.nextLine();
                            if (!input.isBlank()) {
                                try {
                                    stuToUpdate.setBirth_date(LocalDate.parse(input));
                                } catch (DateTimeParseException e) {
                                    System.out.println("Invalid date format. Skipping birthdate update.");
                                }
                            }

                            studentDAO.updateStudent(stuToUpdate);
                            System.out.println("Student updated.");
                        } else {
                            System.out.println("Student not found.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID.");
                    }
                }
                case 5 -> {
                    System.out.print("Enter student ID to delete: ");
                    try {
                        int did = Integer.parseInt(scanner.nextLine());
                        Student s = studentDAO.getStudent(did);
                        if (s != null) {
                            studentDAO.deleteStudent(did);
                            System.out.println("Student deleted.");
                        } else {
                            System.out.println("Student not found.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID.");
                    }
                }
                case 6 -> {
                    System.out.print("Course code: ");
                    String courseCode = scanner.nextLine();
                    System.out.print("Course name: ");
                    String courseName = scanner.nextLine();
                    Course course = new Course(courseCode, courseName);
                    courseDAO.addCourse(course);
                    System.out.println("Course added.");
                }
                case 7 -> {
                    System.out.println("--- All Courses ---");
                    List<Course> courses = courseDAO.getAllCourses();
                    for (Course c : courses) {
                        System.out.println(c.getId() + ": " + c.getCourse_name() + " - " + c.getCourse_description());
                    }
                }
                case 8 -> {
                    System.out.print("Enter course ID to update: ");
                    try {
                        int cid = Integer.parseInt(scanner.nextLine());
                        Course courseToUpdate = courseDAO.getCourse(cid);
                        if (courseToUpdate != null) {
                            System.out.print("New course name (" + courseToUpdate.getCourse_name() + "): ");
                            String input = scanner.nextLine();
                            if (!input.isBlank()) courseToUpdate.setCourse_name(input);

                            System.out.print("New course description (" + courseToUpdate.getCourse_description() + "): ");
                            input = scanner.nextLine();
                            if (!input.isBlank()) courseToUpdate.setCourse_description(input);

                            courseDAO.updateCourse(courseToUpdate);
                            System.out.println("Course updated.");
                        } else {
                            System.out.println("Course not found.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID.");
                    }
                }

                case 9 -> {
                    System.out.print("Enter course ID to delete: ");
                    try {
                        int delCid = Integer.parseInt(scanner.nextLine());
                        Course c = courseDAO.getCourse(delCid);
                        if (c != null) {
                            courseDAO.deleteCourse(delCid);
                            System.out.println("Course deleted.");
                        } else {
                            System.out.println("Course not found.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID.");
                    }
                }
                case 10 -> {
                    try {
                        System.out.print("Student ID: ");
                        int studentId = Integer.parseInt(scanner.nextLine());

                        System.out.print("Course ID: ");
                        int courseId = Integer.parseInt(scanner.nextLine());

                        System.out.print("Mark: ");
                        float markValue = Float.parseFloat(scanner.nextLine()); // Use float not int


                        Mark mark = new Mark(studentId, courseId, markValue);

                        marksDAO.addOrUpdateMark(mark);
                        System.out.println("Mark added or updated.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter numbers for IDs and mark.");
                    }
                }

                case 11 -> {
                    System.out.print("Enter student ID: ");
                    try {
                        int sid = Integer.parseInt(scanner.nextLine());
                        List<Mark> marks = marksDAO.getAllMarksForStudent(sid);
                        if (!marks.isEmpty()) {
                            System.out.println("--- Marks for Student ID " + sid + " ---");
                            for (Mark m : marks) {
                                System.out.println("Course ID: " + m.getCourse_id() + " | Mark: " + m.getMarks());
                            }
                        } else {
                            System.out.println("No marks found for this student.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID.");
                    }
                }
                case 12 -> {
                    try {
                        System.out.print("Enter student ID: ");
                        int sid = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter course ID: ");
                        int cid = Integer.parseInt(scanner.nextLine());
                        marksDAO.deleteMark(sid, cid);
                        System.out.println("Mark deleted.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID.");
                    }
                }
                case 0 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}
