/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        CorruptFileAnalyser corruptFileAnalyser = new CorruptFileAnalyser("/Users/jamesharrington/Repos/AdventOfCode2024/java/day03/app/src/main/java/org/example/input.txt");
        CorruptFileWithDosAndDontsAnalyser corruptFileWithDosAndDontsAnalyser = new CorruptFileWithDosAndDontsAnalyser("/Users/jamesharrington/Repos/AdventOfCode2024/java/day03/app/src/main/java/org/example/input.txt");


        System.out.println("Advent of Code: Day 3, Part 1 -- " + corruptFileAnalyser.analyseFile());
//        System.out.println("Advent of Code: Day 3, Part 1 -- " + corruptFileWithDosAndDontsAnalyser.analyseFile());
    }
}
