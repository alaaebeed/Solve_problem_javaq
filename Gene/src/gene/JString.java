package gene;

import java.lang.String;

public class JString {

    public static void main(String[] args) {
//        StringClass stringClass = new StringClass();
//        stringClass.twoOccurrences("na", "gfgfbananagfgf");
//        String aa = "-----";
        
//        System.out.println(aa);
//        stringClass.lastPart("actcatgatttcgatttataat","atg","taa");
        
        System.out.println("--------------");
        WebLinkFinder weblink = new WebLinkFinder();
        weblink.printVideoUrls();
    }
}

// Gene test = new Gene();
//        String gene = "atgatagtaa";
//        int startOfGene = gene.indexOf("atg");
//        int endOfGene = gene.indexOf("taa", startOfGene + 2);
//        System.out.println("the gene is   :" + gene);
//        System.out.println(test.fingGene(gene, startOfGene, endOfGene));
//
//
//
//
//   String result = "";
//        int theDiffrence=startOfGene-endOfGene;
//        
//        if (theDiffrence%3==0){
//
//        if (startOfGene == -1) {
//            return "Start Not Found";
//        }
//
//        if (endOfGene == -1) {
//            return "End Not Found";
//        }
//        result = gene.substring(startOfGene, endOfGene + 3);
//
//        System.out.println("The result is :" + result);
//        } else {
//            return "Not valid gene";
//        }
//        
//        return "";
