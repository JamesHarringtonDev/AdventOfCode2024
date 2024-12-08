package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationExtractorTest {
    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("mul(44,46)", 44 * 46),
                Arguments.of("mul(123,4)", 123 * 4),
                Arguments.of("xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))", 2 * 4 + 5 * 5 + 11 * 8 + 8 * 5)
        );
    }


    @ParameterizedTest
    @MethodSource({
            "testCases"
    })
    void handlesTestCasesCorrectly(String corruptData, Integer expectedResult) {
        CalculationExtractor calculationExtractor = new CalculationExtractor(corruptData);
        assertEquals(expectedResult, calculationExtractor.sumTheMultiplications());
    }
}
