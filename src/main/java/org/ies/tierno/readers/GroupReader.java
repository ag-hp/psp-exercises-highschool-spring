package org.ies.tierno.readers;

import org.ies.tierno.model.Group;
import org.ies.tierno.model.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class GroupReader implements Reader<Group> {

    private final Scanner scanner;
    private final Reader<Student> studentReader;

    public GroupReader(Scanner scanner, Reader<Student> studentReader) {
        this.scanner = scanner;
        this.studentReader = studentReader;
    }


    @Override
    public Group read() {
        System.out.print("Nombre del grupo: ");
        String name = scanner.nextLine();
        System.out.print("¿Cuántos students tiene el grupo " + name + "? ");
        int n = Integer.parseInt(scanner.nextLine().trim());

        List<Student> students = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            System.out.println("-- Estudiante " + i + " de " + n + " --");
            students.add(studentReader.read());
        }
        return new Group(name, students);
    }
}
