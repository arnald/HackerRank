package StringManipulation.Sherlock_and_the_Valid_String;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
        if (s.length() < 3)
            return "YES";

        HashMap<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (charMap.containsKey(s.charAt(i))) {
                charMap.put(s.charAt(i), charMap.get(s.charAt(i)) + 1);
            } else {
                charMap.put(s.charAt(i), 1);
            }
        }
        Collection valuesCollection = charMap.values();
        Integer[] valuesArray = (Integer[]) (valuesCollection.toArray(new Integer[valuesCollection.size()]));
        Arrays.sort(valuesArray);
        if (valuesArray[0] == 1 && valuesArray[valuesArray.length - 1] - valuesArray[1] == 0) {
            return "YES";
        }
        if (valuesArray[valuesArray.length - 1] - valuesArray[0] >= 1) {
            if (((valuesArray[valuesArray.length - 1] - valuesArray[0] > 1)
                    || (valuesArray[valuesArray.length - 2] - valuesArray[0] > 0))) {
                return "NO";
            }
        }
        return "YES";
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        // BufferedReader bufferedReader = new BufferedReader(new
        // InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new
        // FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("InterviewPreparationKit/StringManipulation/Sherlock_and_the_Valid_String/input.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("InterviewPreparationKit/StringManipulation/Sherlock_and_the_Valid_String/output.txt"));

        String s = bufferedReader.readLine();

        String result = Result.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
