/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        XmasFinder xmasFinder = new XmasFinder("/Users/jamesharrington/Repos/AdventOfCode2024/java/day04/app/src/main/java/org/example/input1.txt");
        System.out.println("Advent of Code: Day 3, Part 1 -- " + xmasFinder.countTheXmas());
    }
}
