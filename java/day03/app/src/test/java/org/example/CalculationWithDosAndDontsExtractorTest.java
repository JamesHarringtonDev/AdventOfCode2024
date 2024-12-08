package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationWithDosAndDontsExtractorTest {
    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("mul(44,46)", 44 * 46),
                Arguments.of("mul(123,4)", 123 * 4),
                Arguments.of("xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))", 48)
        );
    }


    @ParameterizedTest
    @MethodSource({
            "testCases"
    })
    void handlesTestCasesCorrectly(String corruptData, Integer expectedResult) {
        CalculationWithDosAndDontsExtractor calculationWithDosAndDontsExtractor = new CalculationWithDosAndDontsExtractor(corruptData);
        assertEquals(expectedResult, calculationWithDosAndDontsExtractor.sumTheMultiplications());
    }
}
