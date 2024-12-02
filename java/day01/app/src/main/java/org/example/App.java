package org.example;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        ChristmasList christmasList = new ChristmasList("/Users/jamesharrington/Repos/AdventOfCode2024/java/day01/app/src/main/java/org/example/input1.txt");

        System.out.println("Advent of Code: Day 1, Part 1 -- " + christmasList.getTotalDistances());
        System.out.println("Advent of Code: Day 1, Part 2 -- " + christmasList.getSimilarityScore());
    }
}
