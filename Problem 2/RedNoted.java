import java.util.*;
import java.io.*;

public class RedNoted {
    public RedNoted() {
        try {
            File myObj = new File("RedNoted.txt");
            Scanner myReader = new Scanner(myObj);
            int safeCount = 0;

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                List<Integer> levels = new ArrayList<>();
                String[] values = line.split(" "); 
                for (String value : values) {
                    levels.add(Integer.parseInt(value));
                }
                if (isSafe(levels) || removingOne(levels)) {
                    safeCount++;
                }
            }
            myReader.close();
            System.out.println("Number of safe reports: " + safeCount);

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }

    public boolean isSafe(List<Integer> levels) {
        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for (int i = 0; i < levels.size() - 1; i++) {
            int difference = Math.abs(levels.get(i + 1) - levels.get(i));
            if (difference < 1 || difference > 3) {
                return false; 
            }
            if (levels.get(i) < levels.get(i + 1)) {
                isDecreasing = false;
            } 
            else if (levels.get(i) > levels.get(i + 1)) {
                isIncreasing = false;
            }
        }
        return isIncreasing || isDecreasing;
    }

    public boolean removingOne(List<Integer> levels) {
        for (int i = 0; i < levels.size(); i++) {
            List<Integer> modifiedLevels = new ArrayList<>(levels);
            modifiedLevels.remove(i);

            if (isSafe(modifiedLevels)) {
                return true; 
            }
        }
        return false;  
    }
}
class Main{
    public static void main(String[] args) {
        new RedNoted();
    }
}
