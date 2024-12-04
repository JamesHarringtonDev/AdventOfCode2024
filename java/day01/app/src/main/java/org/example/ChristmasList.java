package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ChristmasList {
    private final List<Integer> firstList;
    private final List<Integer> secondList;
    private final Map<Integer, Integer> secondMap;

    ChristmasList(String fileName) throws IOException {
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();
        secondMap = new HashMap<>();

        Path path = Path.of(fileName);
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(line -> {
                String[] distances = line.split(" {3}");

                firstList.add(Integer.parseInt(distances[0]));
                secondList.add(Integer.parseInt(distances[1]));

                if (
                        secondMap.containsKey(Integer.parseInt(distances[1]))){
                    secondMap.put(
                            Integer.parseInt(distances[1]),
                            secondMap.get(Integer.parseInt(distances[1])) + 1
                    );
                } else {
                    secondMap.put(Integer.parseInt(distances[1]), 1);
                }
            });
        }

        this.firstList = firstList.stream().sorted().collect(Collectors.toList());
        this.secondList = secondList.stream().sorted().collect(Collectors.toList());
    }

    public Integer getTotalDistances(){
        int totalDistance = 0;

        for(int index = 0; index < firstList.size() ; index++){
            totalDistance += Math.abs(firstList.get(index) - secondList.get(index));
        }

        return totalDistance;
    }

    public Integer getSimilarityScore(){
        int totalSimilarity = 0;

        for (Integer integer : firstList) {
            totalSimilarity += secondMap.get(integer) != null ?
                    integer * secondMap.get(integer) : 0;
        }

        return totalSimilarity;
    }
}
