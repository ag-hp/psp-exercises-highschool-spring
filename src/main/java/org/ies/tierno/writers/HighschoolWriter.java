package org.ies.tierno.writers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.ies.tierno.model.Highschool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class HighschoolWriter implements Writer<Highschool> {

    private final ObjectMapper mapper;
    private final String outputFilePath;

    public HighschoolWriter(ObjectMapper mapper, @Value("${output.path}") String outputFilePath) {
        this.mapper = mapper;
        this.outputFilePath = outputFilePath;
    }

    @Override
    public void write(Highschool highschool) throws IOException {
        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File(outputFilePath), highschool);
    }
}