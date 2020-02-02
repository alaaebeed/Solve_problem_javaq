package csv;

import org.apache.commons.csv.*;
import edu.duke.*;
import edu.duke.FileResource;
import java.util.Arrays;

public class CSV {

 
    public static void main(String[] args) {
        readFood();
        

    }

    public static void readFood() {
     
        
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        int counter = 0;
        for (CSVRecord record : parser) {
            long find =  Long.parseLong(record.get("Value").replace("$", "").replace(",", ""))/10000;
           if (find > 99999999){
            counter++;
           
            System.out.println(record.get("Country")+" : "+find*10000);
           }
        }
     
    }
}
