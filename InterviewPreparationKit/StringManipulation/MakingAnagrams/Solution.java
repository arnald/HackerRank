package StringManipulation.MakingAnagrams;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {

        int totalAnagrams = 0;
        String second = b;

        for(int i=0; i<a.length();i++){
            char c = a.charAt(i);
            String compareStr = String.valueOf(c);
            if (second.contains(compareStr)){
                totalAnagrams += 2;
                second = second.replaceFirst(compareStr,"");
            }
        }

        int totalCharsToRemove = a.length() + b.length() - totalAnagrams;

        return totalCharsToRemove;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("HackerRank/InterviewPreparationKit/StringManipulation/MakingAnagrams/test.txt"));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
