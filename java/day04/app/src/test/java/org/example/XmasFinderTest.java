/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class XmasFinderTest {
    @Test void expectToCountTheXmas() throws IOException {
        XmasFinder xmasFinder = new XmasFinder("/Users/jamesharrington/Repos/AdventOfCode2024/java/day04/app/src/test/java/org/example/testInput.txt");
        assertEquals(18, xmasFinder.countTheXmas());
    }

    @Test void expectToCountTheMasX() throws IOException {
        XmasFinder xmasFinder = new XmasFinder("/Users/jamesharrington/Repos/AdventOfCode2024/java/day04/app/src/test/java/org/example/testInput.txt");
        assertEquals(9, xmasFinder.countTheMasX());
    }
}
