package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CorruptFileAnalyserTest {
    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("/Users/jamesharrington/Repos/AdventOfCode2024/java/day03/app/src/test/java/org/example/testInput1.txt", 2024),
                Arguments.of("/Users/jamesharrington/Repos/AdventOfCode2024/java/day03/app/src/test/java/org/example/testInput2.txt", 492),
                Arguments.of("/Users/jamesharrington/Repos/AdventOfCode2024/java/day03/app/src/test/java/org/example/testInput3.txt", 161),
                Arguments.of("/Users/jamesharrington/Repos/AdventOfCode2024/java/day03/app/src/test/java/org/example/testInput4.txt", 2024 + 492 + 161)
        );
    }


    @ParameterizedTest
    @MethodSource({
            "testCases"
    })
    void handlesTestCasesCorrectly(String corruptString, Integer expectedResult) throws IOException {
        CorruptFileAnalyser corruptFileAnalyser = new CorruptFileAnalyser(corruptString);
        assertEquals(expectedResult, corruptFileAnalyser.analyseFile());
    }
}
