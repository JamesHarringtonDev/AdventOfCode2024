package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class XmasFinder {
    List<List<String>>  letters;

    XmasFinder(String fileName)throws IOException {
        Path filePath = Paths.get(fileName);

        try {
              List<String> lines = Files.lines(filePath, StandardCharsets.UTF_8).toList();

              letters = lines.stream().map(line -> Arrays.stream(line.split("")).toList()).toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Integer countTheMasX() {
        Integer howMany = 0;
        for (int rowIndex = 0; rowIndex < letters.size(); rowIndex++) {
            for (int columnIndex = 0; columnIndex < letters.get(rowIndex).size(); columnIndex++) {
                if (letters.get(rowIndex).get(columnIndex).equals("X")) {
                    if (isThereAnMasGoingThisWay(rowIndex, columnIndex) &&
                            isThereAnMasGoingThatWay(rowIndex, columnIndex)){
                        howMany++;
                    }
                }
            }
        }

        return howMany;
    }

    // / <- this way
    Boolean isThereAnMasGoingThisWay(int rowIndex, int columnIndex){
        // Checking we're not to closes to top right
        if (rowIndex - 1 < 0 && columnIndex > letters.get(rowIndex).get(columnIndex).length()) {
            return false;
        }

        //Check we're not too close to the bottom left
        if (rowIndex + 1 > letters.size() && columnIndex - 1 < 0) {
            return false;
        }

        if (letters.get(rowIndex - 1).get(columnIndex + 1).equals("M") &&
                letters.get(rowIndex + 1).get(columnIndex - 1).equals("S")){
            return true;
        }

        if (letters.get(rowIndex - 1).get(columnIndex + 1).equals("S") &&
                letters.get(rowIndex + 1).get(columnIndex - 1).equals("M")){
            return true;
        }


        return false;
    }

    // \ <- that way
    Boolean isThereAnMasGoingThatWay(int rowIndex, int columnIndex){
        // Checking we're not to closes to top left
        if (rowIndex + 1 > letters.size() && columnIndex - 1 < 0) {
            return false;
        }

        // Checking we're not to closes to bottom right
        if (rowIndex - 1 < 0 && columnIndex + 1 > letters.size()) {
            return false;
        }

        if (letters.get(rowIndex - 1).get(columnIndex - 1).equals("M") &&
                letters.get(rowIndex + 1).get(columnIndex + 1).equals("S")){
            return true;
        }

        if (letters.get(rowIndex - 1).get(columnIndex - 1).equals("S") &&
                letters.get(rowIndex + 1).get(columnIndex + 1).equals("M")){
            return true;
        }

        return false;
    }

    Integer countTheXmas() {
        Integer howMany = 0;
        for (int rowIndex = 0; rowIndex < letters.size(); rowIndex++) {
            for (int columnIndex = 0; columnIndex < letters.get(rowIndex).size(); columnIndex++) {
                if (letters.get(rowIndex).get(columnIndex).equals("X")) {
                    if (isThereAnXmasGoingUp(rowIndex, columnIndex)){
                        howMany++;
                    }
                    if (isThereAnXmasGoingDiagonallyNE(rowIndex, columnIndex)){

                        howMany++;
                    }
                    if (isThereAnXmasGoingRight(rowIndex, columnIndex)){

                        howMany++;
                    }
                    if (isThereAnXmasGoingDiagonallySE(rowIndex, columnIndex)){
                        howMany++;
                    }
                    if (isThereAnXmasGoingDown(rowIndex, columnIndex)){
                        howMany++;
                    }
                    if (isThereAnXmasGoingDiagonallySW(rowIndex, columnIndex)){
                        howMany++;
                    }
                    if (isThereAnXmasGoingLeft(rowIndex, columnIndex)){

                        howMany++;
                    }
                    if (isThereAnXmasGoingDiagonallyNW(rowIndex, columnIndex)){
                        System.out.println("Row " + rowIndex + " column " + columnIndex);
                        howMany++;
                    }
                }
            }
        }

        return howMany;
    }

    Boolean isThereAnXmasGoingUp(int rowIndex, int columnIndex) {
        if (rowIndex - 3 < 0) {
            return false;
        }

        if ( letters.get(rowIndex - 1).get(columnIndex).equals("M") &&
                letters.get(rowIndex - 2).get(columnIndex).equals("A") &&
                letters.get(rowIndex - 3).get(columnIndex).equals("S")
        ) {
            return true;
        }
        return false;
    }

    Boolean isThereAnXmasGoingDown(int rowIndex, int columnIndex) {
        if (rowIndex + 3 > letters.size() - 1) {
            return false;
        }

        if ( letters.get(rowIndex + 1).get(columnIndex).equals("M") &&
                letters.get(rowIndex + 2).get(columnIndex).equals("A") &&
                letters.get(rowIndex + 3).get(columnIndex).equals("S")
        ) {
            return true;
        }
        return false;
    }

    Boolean isThereAnXmasGoingLeft(int rowIndex, int columnIndex) {
        if (columnIndex - 3 < 0) {
            return false;
        }

        if ( letters.get(rowIndex).get(columnIndex - 1).equals("M") &&
                letters.get(rowIndex).get(columnIndex - 2).equals("A") &&
                letters.get(rowIndex).get(columnIndex - 3).equals("S")
        ) {
            return true;
        }
        return false;
    }

    Boolean isThereAnXmasGoingRight(int rowIndex, int columnIndex) {
        if (columnIndex + 3 > letters.getFirst().size() - 1) {
            return false;
        }

        if ( letters.get(rowIndex).get(columnIndex + 1).equals("M") &&
                letters.get(rowIndex).get(columnIndex + 2).equals("A") &&
                letters.get(rowIndex).get(columnIndex + 3).equals("S")
        ) {
            return true;
        }
        return false;
    }

    Boolean isThereAnXmasGoingDiagonallyNE(int rowIndex, int columnIndex) {
        if (columnIndex + 3 > letters.getFirst().size() - 1 ||
                rowIndex - 3 < 0
          ) {
            return false;
        }

        if ( letters.get(rowIndex - 1).get(columnIndex + 1).equals("M") &&
                letters.get(rowIndex - 2).get(columnIndex + 2).equals("A") &&
                letters.get(rowIndex - 3).get(columnIndex + 3).equals("S")
        ) {
            return true;
        }
        return false;
    }

    Boolean isThereAnXmasGoingDiagonallySE(int rowIndex, int columnIndex) {
        if (columnIndex + 3 > letters.getFirst().size() - 1 ||
                rowIndex + 3 > letters.size() - 1
        ) {
            return false;
        }

        if ( letters.get(rowIndex + 1).get(columnIndex + 1).equals("M") &&
                letters.get(rowIndex + 2).get(columnIndex + 2).equals("A") &&
                letters.get(rowIndex + 3).get(columnIndex + 3).equals("S")
        ) {
            return true;
        }
        return false;
    }

    Boolean isThereAnXmasGoingDiagonallyNW(int rowIndex, int columnIndex) {
        if (columnIndex - 3 < 0 ||
                rowIndex - 3 < 0
        ) {
            return false;
        }

        if ( letters.get(rowIndex - 1).get(columnIndex - 1).equals("M") &&
                letters.get(rowIndex - 2).get(columnIndex - 2).equals("A") &&
                letters.get(rowIndex - 3).get(columnIndex - 3).equals("S")
        ) {
            return true;
        }
        return false;
    }

    Boolean isThereAnXmasGoingDiagonallySW(int rowIndex, int columnIndex) {
        if (columnIndex - 3 < 0 ||
                rowIndex + 3 > letters.size() - 1
        ) {
            return false;
        }

        if ( letters.get(rowIndex + 1).get(columnIndex - 1).equals("M") &&
                letters.get(rowIndex + 2).get(columnIndex - 2).equals("A") &&
                letters.get(rowIndex + 3).get(columnIndex - 3).equals("S")
        ) {
            return true;
        }
        return false;
    }
}
