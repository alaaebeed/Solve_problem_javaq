package edu.duke;

import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {

    public int getNumPoints(Shape s) {
        // set total to zero 
        int total = 0;
        //loop throught the points 
        for (Point p : s.getPoints()) {
            total = total + 1;
        }
        return total;
    }

    // Avg = Length / sum
    public double getAverageLength(Shape s) {
        //get sum 
        float sum = (float) getNumPoints(s);
        //get Lenth
        float length = (float) getPerimeter(s);
        // return length/sum 
        return length / sum;
    }
    
    
    //get the largest side of shape 
    public double getLargestSide(Shape s) {
        // var to get last point  
        Point lastPoint = s.getLastPoint(); //(3.4) 
        // initial larget prime with zero 
        double largestPint = 0.0;
        // loop throught all points 
        for (Point currPt : s.getPoints()) {
            //get the distance 
            double dist = lastPoint.distance(currPt); //(4)
            //check if largest point is the greater      
            if (largestPint < dist) {
                // initialize large point to current      
                largestPint = dist;
            }
            lastPoint = currPt;
        }

        return largestPint;
    }

    public double getLargestX(Shape s) {
        // Put code here
        Point lastPoint = s.getLastPoint();
        int lastPointX = lastPoint.getX();
        double largestX = (double) lastPointX;

        for (Point p : s.getPoints()) {
            int newX = p.getX();
            if (newX > largestX) {
                largestX = (double) newX;
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0.0;
        FileResource largestFile = null;

        for (File f : dr.selectedFiles()) {
            FileResource file = new FileResource(f);
            Shape shape = new Shape(file);
            double perim = getPerimeter(shape);
            if (perim > largestPerim) {
                largestPerim = perim;
            }
        }
        return largestPerim;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0.0;
        File largestFile = null;

        for (File f : dr.selectedFiles()) {
            FileResource file = new FileResource(f);
            Shape shape = new Shape(file);
            double perim = getPerimeter(shape);
            if (perim > largestPerim) {
                largestPerim = perim;
                largestFile = f;
            }
        }

        return largestFile.getName();
    }

    public void testPerimeterMultipleFiles() {
        // Put code here
        double largest = getLargestPerimeterMultipleFiles();
        System.out.println("Largest perimeter is: " + largest);
    }

    public void testFileWithLargestPerimeter() {
        String file = getFileWithLargestPerimeter();
        System.out.println("Largest perimeter file is: " + file);
    }

    public double getPerimeter(Shape s) {
        double totalPerim = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            totalPerim = totalPerim + currDist;
            prevPt = currPt;
        }
        return totalPerim;
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle() {
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0, 0));
        triangle.addPoint(new Point(6, 0));
        triangle.addPoint(new Point(3, 6));
        for (Point p : triangle.getPoints()) {
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = " + peri);
    }

    public void testPerimeter() {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int numPoints = getNumPoints(s);
        double averageLength = getAverageLength(s);
        double largestSide = getLargestSide(s);
        double largestX = getLargestX(s);

        System.out.println("perimeter = " + length);
        System.out.println("Number of Points: " + numPoints);
        System.out.println("Average Length: " + averageLength);
        System.out.println("Largest Side: " + largestSide);
        System.out.println("Largest X is: " + largestX);
        testPerimeterMultipleFiles();
        testFileWithLargestPerimeter();
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main(String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
