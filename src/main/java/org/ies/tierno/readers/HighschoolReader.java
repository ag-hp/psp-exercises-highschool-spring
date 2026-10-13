package org.ies.tierno.readers;

import org.ies.tierno.model.Group;
import org.ies.tierno.model.Highschool;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class HighschoolReader implements Reader<Highschool> {

    private final Scanner scanner;
    private final Reader<Group> groupReader;

    public HighschoolReader(Scanner scanner, Reader<Group> groupReader) {
        this.scanner = scanner;
        this.groupReader = groupReader;
    }

    @Override
    public Highschool read() {
        System.out.print("Nombre del instituto: ");
        String name = scanner.nextLine();
        System.out.print("¿Cuántos groups tiene? ");
        int n = Integer.parseInt(scanner.nextLine().trim());

        List<Group> groups = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            System.out.println("== Grupo " + i + " de " + n + " ==");
            groups.add(groupReader.read());
        }
        return new Highschool(name, groups);
    }
}