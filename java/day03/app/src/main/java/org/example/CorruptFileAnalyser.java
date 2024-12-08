package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CorruptFileAnalyser {
    List<CalculationExtractor> calculationExtractors;

    CorruptFileAnalyser(String fileName) throws IOException {
        Path filePath = Paths.get(fileName);

        try {
            calculationExtractors = Files.lines(filePath, StandardCharsets.UTF_8).map(CalculationExtractor::new).toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Integer analyseFile() {
        return calculationExtractors.stream().mapToInt(CalculationExtractor::sumTheMultiplications).sum();
    }
}
