package csv;

import org.apache.commons.csv.*;
import edu.duke.*;
import edu.duke.FileResource;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Tepmereture {

    public static void main(String[] args) {
//        testHottestInDay ();
        pringAvg();
    }

    public static CSVRecord hottestHourInFile(CSVParser parser) {
        //Start with the larger sofar with no thing 
        CSVRecord largestSoFar = null; //---------------> Updated to be first row
        //for each current row in CSV file 
        for (CSVRecord currentRow : parser) {
            largestSoFar = largerOfTwo(currentRow, largestSoFar);

        }

        return largestSoFar;

    }

    public static void testHottestInDay() {
        FileResource fr = new FileResource();
        CSVRecord largest = hottestHourInFile(fr.getCSVParser());
        System.out.println("hottest temperature was " + largest.get(0)
                + " at " + largest.get(1));
    }

    public static CSVRecord TheAvg() {
        CSVRecord largestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        // iterate over files
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            // use method to get largest in file.
            CSVRecord currentRow = hottestHourInFile(fr.getCSVParser());
            largestSoFar = largerOfTwo(currentRow, largestSoFar);

        }
        //The largestSoFar is the answer
        return largestSoFar;
    }

    public static void pringAvg() {
        CSVRecord avg = TheAvg();
        System.out.println("The Name is" + avg.get(0)
                + " at " + avg.get(1));

    }

    public static CSVRecord largerOfTwo(CSVRecord currentRow, CSVRecord smallestSoFar) {

        String currentTemp = currentRow.get(0);
        String smallestTemp = smallestSoFar.get(1);
        System.out.println("Name " + currentTemp + "Gendre" + smallestTemp);
        return smallestSoFar;
    }

}
