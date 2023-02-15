package Sorting.Comparator;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Player> playerList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // BufferedReader bufferedReader = new BufferedReader(new
        // InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new
        // FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("InterviewPreparationKit/Sorting/Comparator/input.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("InterviewPreparationKit/Sorting/Comparator/output.txt"));

        int numberOfPlayers = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, numberOfPlayers).forEach(qItr -> {
            String data;
            try {
                data = bufferedReader.readLine();
                if (!data.equals("")) {
                    String[] splittedData = data.split(" ");

                    String name = splittedData[0];

                    int score = Integer.parseInt(splittedData[1]);
                    playerList.add(new Player(name, score));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Collections.sort(playerList, new Checker());

        for (Player player : playerList) {
            bufferedWriter.write(player.toString());
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
        scanner.close();
    }
}

class Player {
    String name;
    int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return getName() + " " + getScore();
    }

}

class Checker implements Comparator<Player> {

    @Override
    public int compare(Player playerOne, Player playerTwo) {
        if (playerOne.score == playerTwo.score) {
            return playerOne.name.compareTo(playerTwo.name);
        }

        return playerTwo.score - playerOne.score;
    }

}