package org.ies.tierno.readers;

import org.ies.tierno.model.Student;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class StudentReader implements Reader<Student> {

    private final Scanner scanner;

    public StudentReader(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Student read() {
        System.out.print("Nombre del estudiante: ");
        String name = scanner.nextLine();
        System.out.print("Apellidos: ");
        String surname = scanner.nextLine();
        System.out.print("Edad: ");
        int age = Integer.parseInt(scanner.nextLine().trim());
        return new Student(name, surname, age);
    }
}