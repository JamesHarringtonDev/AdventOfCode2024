package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ReportGenerator {
    private List<Report> reports = new ArrayList<>();

    ReportGenerator(String fileName) throws IOException{
        Path filePath = Paths.get(fileName);
        try {
            reports = Files.lines(filePath, StandardCharsets.UTF_8).map(Report::new).toList();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Integer howManySafe(){
        return reports.stream().filter(Report::isReportSafe).toList().size();
    }

    public Integer howManySafeWithARemoval(){
        return reports.stream().filter(Report::isReportSafeWithARemoval).toList().size();
    }
}
