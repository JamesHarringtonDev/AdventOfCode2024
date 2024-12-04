package org.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReportGeneratorTest {

    @Test
    void identifiesCorrectSafeReports() throws IOException {
        ReportGenerator reportGenerator = new ReportGenerator("/Users/jamesharrington/Repos/AdventOfCode2024/java/day02/app/src/test/java/org/example/testInput1.txt");
        assertEquals(reportGenerator.howManySafe(), 2);
    }

//    @Test
    void identifiesCorrectSafeWithRemovalReports() throws IOException {
        ReportGenerator reportGenerator = new ReportGenerator("/Users/jamesharrington/Repos/AdventOfCode2024/java/day02/app/src/test/java/org/example/testInput1.txt");
        assertEquals(reportGenerator.howManySafeWithARemoval(), 4);
    }
}
