package org.ies.tierno;

import org.ies.tierno.model.Highschool;
import org.ies.tierno.readers.Reader;
import org.ies.tierno.writers.Writer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HighschoolApp implements CommandLineRunner {

    private final Reader<Highschool> highschoolReader;
    private final Writer<Highschool> highschoolWriter;

    public HighschoolApp(Reader<Highschool> highschoolReader, Writer<Highschool> highschoolWriter) {
        this.highschoolReader = highschoolReader;
        this.highschoolWriter = highschoolWriter;
    }

    public void run() {
        try {
            Highschool highschool = highschoolReader.read();
            highschoolWriter.write(highschool);
            System.out.println("Datos guardados correctamente.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run(String... args) throws Exception {
        run();
    }
}