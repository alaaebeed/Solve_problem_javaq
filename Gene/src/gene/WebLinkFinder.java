/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gene;

import edu.duke.*;
import java.io.*;

/**
 *
 * @author alaa
 */
//public class StringClass {
//
//    public void twoOccurrences(String a, String b) {
//
//        int length = b.length();
//        int counter = 0;
//        for (int i = 0; i <= length; i++) {
//            if (b.indexOf(a, i) == i) {
//                counter++;
//                if (counter >= 2) {
//                    System.out.println("TRUE " + counter);
//                    break;
//                } else {
//                    System.out.println("FALSE " + counter);
//                }
//            }
//        }
//
//    }
//
//    public String lastPart(String y, String x, String z) {
//        String result = "";
//        int startIndex = y.indexOf(x);
//        int endIndex = y.indexOf(z);
//        int length = result.length();
//        result= y.substring(startIndex, endIndex+startIndex);
//        System.out.println(result);
//        return result;
//    }
//    
public class WebLinkFinder {

    private URLResource urlRes = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");

    public void printVideoUrls() {

        for (String word : urlRes.words()) {

            printVideoURL(word);

        }

    }

    private void printVideoURL(String s) {

        final String S_LOW_CASE = s.toLowerCase();

        //get the youtube in web page
        int startIndex = S_LOW_CASE.indexOf("youtube.com");
        if (startIndex == -1) {
            return;
        }
        //StratFrom
        int firstQuoteIndex = S_LOW_CASE.indexOf("/");
        if (firstQuoteIndex == -1) {
            return;
        }
        //End 
        int lastQuoteIndex = S_LOW_CASE.lastIndexOf("\"");
        if (lastQuoteIndex == -1) {
            return;
        }
        //Connect Start & End 
        String outString = s.substring(firstQuoteIndex + 2, lastQuoteIndex);
        System.out.println(outString.toLowerCase());

    }
}
