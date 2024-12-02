/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class ChristmasListTest {
    @Test void distancesCalculatedCorrectly() throws IOException {
        ChristmasList christmasList = new ChristmasList("/Users/jamesharrington/Repos/AdventOfCode2024/java/day01/app/src/test/java/org/example/testsInput1.txt");
        assertEquals(11, christmasList.getTotalDistances());
    }

    @Test void similarityCalculatedCorrectly() throws IOException {
        ChristmasList christmasList = new ChristmasList("/Users/jamesharrington/Repos/AdventOfCode2024/java/day01/app/src/test/java/org/example/testsInput1.txt");
        assertEquals(31, christmasList.getSimilarityScore());
    }
}