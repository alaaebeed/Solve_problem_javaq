package MiniProjectTest;

import org.apache.commons.csv.*;
import edu.duke.*;
import edu.duke.FileResource;
import java.io.*;

public class Tepmereture {

    public static void main(String[] args) {
//        FileResource fr = new FileResource();

        //    totalBirths(fr);
        //    System.out.println(getRank(fr, "Owen", "M"));
        //      getName(fr, 430, "M");
//        whatIsNameInYear(fr, "Genevieve", "F");
//        yearOfHighestRank("Genevieve", "F");
//        getAvarageRank("Emily","F");
//          getAvg();
//        getBiggestRankInAll();
        // System.out.println(yearOfHighestRank("Mich","M"));
        System.out.println(getTotalBirthsRankedHigher("Ava", "F"));
    }

    public static void printNames() {
        FileResource fr = new FileResource();
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            if (numBorn <= 100) {
                System.out.println("Name " + rec.get(0)
                        + " Gender " + rec.get(1)
                        + " Num Born " + rec.get(2));
            }
        }
    }

    public static void totalBirths(FileResource fr) {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        int girlNames = 0;
        int boysNames = 0;

        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;

            if (rec.get(1).equals("M")) {
                totalBoys += numBorn;
                boysNames++;
            } else if (rec.get(1).equals("F")) {
                totalGirls += numBorn;
                girlNames++;
            }
        }
        System.out.println("total births = " + totalBirths);
        System.out.println("Female girls = " + totalGirls);
        System.out.println("Male boys = " + totalBoys);
        System.out.println("");
        System.out.println("NUMBER OF Females only  = " + girlNames);
        System.out.println("NUMBER OF Males only = " + boysNames);
    }

    public static int getRank(FileResource fr, String name, String gendre) {
        int rank = -1;
        int genderCnt = 0;

        for (CSVRecord rec : fr.getCSVParser(false)) {
            if (rec.get(1).equals(gendre)) {
                genderCnt++;
            }
            if (rec.get(0).equals(name) && rec.get(1).equals(gendre)) {
                rank = genderCnt;
            }
        }

        return rank;
    }

    public static String getName(FileResource fr, int rank, String gendre) {
        int genderCnt = 0;
        int temp = 0;

        for (CSVRecord rec : fr.getCSVParser(false)) {
            //take the rank and the gendre
            if (rec.get(1).equals(gendre)) {
                genderCnt++;
                temp = genderCnt;
            }
            if (temp == rank) {
                System.out.println("The Name is : " + rec.get(0));
            }
        }
        return "";
    }

    public static void getBiggestRankInAll() {
        int counter = 1880;
        float temp = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            int number = getRank(fr, "Genevieve", "F");
            if (number > temp) {
                temp = number;
            }
            counter++;
        }
        System.out.println("The Higest rank is : " + temp + counter);

    }

    public static void getAvg() {
        int counter = 0;
        float total = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            int number = getRank(fr, "Robert", "M");
            total += number;
            counter++;
        }
        System.out.println("The total is : " + total + "  The counter is : " + counter);
        System.out.println("The AVG is  " + total / counter);

    }

    //////////////////////////////////////
    public static int yearOfHighestRank(String name, String gender) {

        int rank = -1;
        int year = -1;
        int tempRank;

        DirectoryResource dr = new DirectoryResource();

        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);

            int tempYear = parseYear(f.getName());

            tempRank = getRank(fr, name, gender);

            if ((tempRank < rank || rank == -1) && tempRank != -1) {
                rank = tempRank;
                year = tempYear;
            }
        }

        return year;
    }

    private static int parseYear(String s) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }

        return Integer.parseInt(sb.toString());

    }

    public static int getTotalBirthsRankedHigher(String name, String gender) {

        int cnt = 0;
        FileResource fr = new FileResource();
        for (CSVRecord rec : fr.getCSVParser(false)) {
            if (rec.get(0).equals(name) && rec.get(1).equals(gender)) {
                break;
            } else if (rec.get(1).equals(gender)) {
                cnt += Integer.parseInt(rec.get(2));
            }
        }

        return cnt;
    }
}
