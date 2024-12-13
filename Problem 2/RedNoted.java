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
                String[] values = line.split(" ");  
                List<Integer> levels = new ArrayList<>();
                for (String value : values) {
                    levels.add(Integer.parseInt(value));
                }
                
                // Check if the report is safe
                if (isSafe(levels)) {
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

    // Method to check if a report is safe
    public boolean isSafe(List<Integer> levels) {        
        boolean isIncreasing = true;
        boolean isDecreasing = true;
        
        for (int i = 0; i < levels.size() - 1; i++) {
            int difference; 
            difference = Math.abs(levels.get(i + 1) - levels.get(i));
            if (difference < 1 || difference > 3) {
                return false;
            }
            if (levels.get(i) < levels.get(i + 1)) {
                isDecreasing = false;  // It's not decreasing
            } else if (levels.get(i) > levels.get(i + 1)) {
                isIncreasing = false;  // It's not increasing
            }
        }
        
        // The report is safe if it is either strictly increasing or strictly decreasing
        return isIncreasing || isDecreasing;
    }

    public static void main(String[] args) {
        new RedNoted(); 
    }
}
