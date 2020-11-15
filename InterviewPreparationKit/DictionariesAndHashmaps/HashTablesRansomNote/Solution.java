package DictionariesAndHashmaps.HashTablesRansomNote;

import java.util.*;

public class Solution {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {

        HashMap<String, Integer> magazineWords = createMap(magazine);
        String isReplica = "Yes";
        for (int i = 0; i < note.length; i++) {
            if (magazineWords.containsKey(note[i]) && magazineWords.get(note[i]) > 0) {
                magazineWords.merge(note[i], -1, Integer::sum);
            } else {
                isReplica = "No";
                break;
            }
        }
        System.out.println(isReplica);
    }

    /* Creates and returns a HashMap out of an array of Strings */
    private static HashMap<String, Integer> createMap(String[] words) {
        HashMap<String, Integer> map = new HashMap();
        for (int i = 0; i < words.length; i++) {
            map.merge(words[i], 1, (oldValue, newValue) -> oldValue + newValue);
        }
        return map;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
