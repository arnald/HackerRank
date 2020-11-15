package DictionariesAndHashmaps.TwoStrings;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Solution {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {

        HashMap<Character, Integer> firstString = createMap(s1);
        HashMap<Character, Integer> secondString = createMap(s2);

        for (Map.Entry f : firstString.entrySet()) {
            boolean check = secondString.containsKey(f.getKey());
            if (secondString.containsKey(f.getKey())){
                return "YES";
            }
        }


        return "NO";
    }

    private static HashMap<Character, Integer> createMap(String words) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : words.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        return map;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("HackerRank/InterviewPreparationKit/DictionariesAndHashmaps/TwoStrings/test.txt"));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
