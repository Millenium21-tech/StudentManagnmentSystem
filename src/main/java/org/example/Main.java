package org.example;

import java.util.Scanner;
import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        StudentDAOImpleme sd = new StudentDAOImpleme();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add student");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    Student student = new Student();
                    System.out.println("First name:");
                    student.setFirst_name(scanner.nextLine());
                    System.out.println("Last name:");
                    student.setLast_name(scanner.nextLine());
                    System.out.println("Email:");
                    student.setEmail(scanner.nextLine());
                    System.out.println("Birth date (yyyy-MM-dd):");
                    String birthDateInput = scanner.nextLine();
                    student.setBirth_date(LocalDate.parse(birthDateInput));
                    sd.addStudent(student);

                    break;

                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }
    }
}
