package DictionariesAndHashmaps.CountTriplets;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {

        long counter = 0;
        Map<Long, Long> numberCount = new HashMap<>();
        Map<Long, Long> countNumberOfPairs = new HashMap<>();

        for (long number : arr) {
            if (number % r == 0) {
                long previous = number / r;

                Long countRight = countNumberOfPairs.get(previous);
                if (countRight != null) counter += countRight;

                Long countMap = numberCount.get(previous);
                if (countMap != null) countNumberOfPairs.put(number, countNumberOfPairs.getOrDefault(number, 0L) + countMap);
            }
            numberCount.put(number, numberCount.getOrDefault(number, 0L) + 1);
        }
        return counter;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("HackerRank/InterviewPreparationKit/DictionariesAndHashmaps/CountTriplets/test.txt"));


        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
