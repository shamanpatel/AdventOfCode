import java.util.*;
import java.io.*;

public class HistorianHysteria {
    List<Integer> locationid1 = new ArrayList<>();
    List<Integer> locationid2 = new ArrayList<>();

    public HistorianHysteria() {
        try {
            File myObj = new File("HysterianHistorian.txt");
            Scanner myReader = new Scanner(myObj);
            
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] values = line.split("\\s+");
                int firstNumber = Integer.parseInt(values[0]);
                int secondNumber = Integer.parseInt(values[1]);
                locationid1.add(firstNumber);
                locationid2.add(secondNumber);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
    public long calculateSimilarityScore() {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : locationid2) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        long totalScore = 0;
        for (int num : locationid1) {
            totalScore += num * count.getOrDefault(num, 0);
        }

        return totalScore;
    }

    public static void main(String[] args) {
        HistorianHysteria historian = new HistorianHysteria();
        long similarityScore = historian.calculateSimilarityScore();
        System.out.println("Similarity Score: " + similarityScore);
    }
}
