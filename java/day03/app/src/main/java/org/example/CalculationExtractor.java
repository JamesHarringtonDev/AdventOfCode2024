package org.example;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.List;

public class CalculationExtractor {
    Integer calculationsResult;

    CalculationExtractor(String corruptedString) {
        String pattern = "mul\\((\\d{1,3}),(\\d{1,3})\\)";

        Matcher m = Pattern.compile(pattern).matcher(corruptedString);

        Integer roughWorking = 0;

        while(m.find()) {
            Integer firstNumber = Integer.parseInt(m.group(1));
            Integer secondNumber = Integer.parseInt(m.group(2));

            roughWorking += firstNumber * secondNumber;
        }

        calculationsResult = roughWorking;
    }

    Integer sumTheMultiplications(){
        return calculationsResult;
    }
}
