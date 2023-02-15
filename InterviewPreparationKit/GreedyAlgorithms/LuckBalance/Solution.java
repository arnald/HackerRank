package GreedyAlgorithms.LuckBalance;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {

        Arrays.sort(contests, (a, b) -> Integer.compare(b[0], a[0]));
        int totalLuck = 0;
        int maxImportantLoss = k;

        for (int i = 0; i < contests.length; i++) {
            if (contests[i][1] == 0) {
                totalLuck += contests[i][0];
            }
            if (contests[i][1] == 1 && maxImportantLoss <= 0) {
                totalLuck -= contests[i][0];
            }
            if (contests[i][1] == 1 && maxImportantLoss > 0) {
                totalLuck += contests[i][0];
                maxImportantLoss--;
            }

        }

        return totalLuck;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new
        // FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("InterviewPreparationKit/GreedyAlgorithms/LuckBalance/input.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("InterviewPreparationKit/GreedyAlgorithms/LuckBalance/output.txt"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
