package Arrays.TwoDArrayDS;

import java.io.*;
import java.util.*;


public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {

        int numberOfRows = arr[0].length;
        int maximum = Integer.MIN_VALUE;

        for (int column = 0; column < numberOfRows - 2; column++) {
            int counter = 0;
            for (int row = 0; row < numberOfRows - 2; row++) {
                counter += arr[column][row] + arr[column][row + 1] + arr[column][row + 2] + arr[column + 1][row + 1] + arr[column + 2][row] + arr[column + 2][row + 1] + arr[column + 2][row + 2];
                if (counter > maximum) {
                    maximum = counter;
                }
                counter = 0;
            }

        }

        return maximum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("HackerRank/InterviewPreparationKit/Arrays/TwoDArrayDS/test.txt"));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
