/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiniProjectTest;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import java.io.File;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author alaa
 */
public class TheBiggest {
      public static CSVRecord hottestInManyDays() {
        CSVRecord largestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        // iterate over files
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            // use method to get largest in file.
  

        }
        //The largestSoFar is the answer
        return largestSoFar;
    }

    public static void testHottestInManyDays() {
        CSVRecord largest = hottestInManyDays();
        System.out.println("lowest humadity  was " + largest.get("TemperatureF")
                + " at " + largest.get("DateUTC"));

    }
    
    
}
