package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculationWithDosAndDontsExtractor {
    List<String> commands;

    CalculationWithDosAndDontsExtractor(String corruptedString) {
        String pattern = "(mul\\((\\d{1,3}),(\\d{1,3})\\)|do\\(\\)|don't\\(\\))";

        Matcher m = Pattern.compile(pattern).matcher(corruptedString);

        Boolean doReadData = true;

        List<String> commands = new ArrayList<>();

        while(m.find()) {
            commands.add(m.group());
        }

        this.commands = commands;
    }

    public List<String> getCommands() {
        return commands;
    }
}
