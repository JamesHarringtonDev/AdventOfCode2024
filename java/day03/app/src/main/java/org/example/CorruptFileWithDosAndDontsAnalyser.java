package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CorruptFileWithDosAndDontsAnalyser {
    List<CalculationWithDosAndDontsExtractor> calculationWithDosAndDontsExtractors;

    CorruptFileWithDosAndDontsAnalyser(String fileName) throws IOException {
        Path filePath = Paths.get(fileName);

        List<String> commands = new ArrayList<>();
        List<String> executedCommands = new ArrayList<>();

        Integer roughWorking = 0;

        try {
            List<CalculationWithDosAndDontsExtractor> calculationWithDosAndDontsExtractors = Files.lines(filePath, StandardCharsets.UTF_8).toList().stream().map(CalculationWithDosAndDontsExtractor::new).toList();

            calculationWithDosAndDontsExtractors.stream().map(CalculationWithDosAndDontsExtractor::getCommands).forEach(commands::addAll);
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean doDoCommand = true;
        for (int index = 0; index < commands.size(); index++) {
            String command = commands.get(index);

            if (command.equals("do()")) {
                doDoCommand = true;
            } else if (command.equals("don't()")) {
                doDoCommand = false;
            } else {
                if (doDoCommand){
                    executedCommands.add(command);
                }
            }
        }

        for (int index = 0; index < executedCommands.size(); index++) {
            String command = executedCommands.get(index);
            List<Integer> multiplands = Stream.of(command.substring(4, command.length() - 1).split(",")).mapToInt(Integer::parseInt).boxed().toList();

            roughWorking += multiplands.get(0) * multiplands.get(1);
        }
    }






}
