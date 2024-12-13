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
}

class Main {
    public static void main(String[] args) {
        HistorianHysteria id = new HistorianHysteria();
        Collections.sort(id.locationid1);
        Collections.sort(id.locationid2);
        
        System.out.println("Sorted locationid1: " + id.locationid1);
        System.out.println("Sorted locationid2: " + id.locationid2);

        long distance = 0;
        for (int i = 0; i < id.locationid2.size(); i++) {
            distance += Math.abs(id.locationid1.get(i) - id.locationid2.get(i));
        }
        System.out.println("The total distance is: " + distance);
    }
}
