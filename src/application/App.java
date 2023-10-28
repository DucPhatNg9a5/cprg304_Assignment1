package application;

import java.io.File;
import java.util.Comparator;

import shape.*;

public class App {
    public static void main(String[] args) {

        String filePath = null;
        String sortType = null;
        String sortAlgorithm = null;

        for (int i = 0; i < args.length; i++) {
            if (args[i].equalsIgnoreCase("-f")) {
                filePath = args[i+1];
            } else if (args[i].equalsIgnoreCase("-t")) {
                sortType = args[i+1];
            } else if (args[i].equalsIgnoreCase("-s")) {
                sortAlgorithm = args[i+1];
            }
        }

        // Comparator for sorting volume
        Comparator<Shape> compareVolume = new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                return Double.compare(s2.calcVolume(), s1.calcVolume());
            }
        };

        // Comparator for sorting base area
        Comparator<Shape> compareBaseArea = new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                return Double.compare(s2.calcBaseArea(), s1.calcBaseArea());
            }
        };

        // FILE READ
        filePath = "src/resources/" + filePath;
        File file = new File(filePath); 
        Shape[] shapeArray = ReadFileClass.ReadFile(file);

        System.out.println("filePath: " + filePath);
        System.out.println("sortType: " + sortType);
        System.out.println("sortAlgorithm: " + sortAlgorithm);

        long startTime = System.currentTimeMillis(); // set current time
        //Sort shape list based on user input
        if (sortType.equalsIgnoreCase("v")) {
            if (sortAlgorithm.equalsIgnoreCase("b")) {
                Utility.bubbleSort(shapeArray, compareVolume);
            }  else if (sortAlgorithm.equalsIgnoreCase("i")) {
                Utility.insertionSort(shapeArray, compareVolume);
            } else if (sortAlgorithm.equalsIgnoreCase("m")) {
                Utility.mergSort(shapeArray, 0, shapeArray.length - 1, compareVolume);
            } else if (sortAlgorithm.equalsIgnoreCase("q")) {
                Utility.quicksort(shapeArray, 0, shapeArray.length - 1, compareVolume);
            } else if (sortAlgorithm.equalsIgnoreCase("s")) {
                Utility.selectionSort(shapeArray, compareVolume);
            } 
        } else if (sortType.equalsIgnoreCase("h")) {
            if (sortAlgorithm.equalsIgnoreCase("b")) {
                Utility.bubbleSort(shapeArray);
            }  else if (sortAlgorithm.equalsIgnoreCase("i")) {
                Utility.insertionSort(shapeArray);
            } else if (sortAlgorithm.equalsIgnoreCase("m")) {
                Utility.mergeSort(shapeArray, 0, shapeArray.length - 1);
            } else if (sortAlgorithm.equalsIgnoreCase("q")) {
                Utility.quickSort(shapeArray, 0, shapeArray.length - 1);
            } else if (sortAlgorithm.equalsIgnoreCase("s")) {
                Utility.selectionSort(shapeArray);
            } 
        } else if (sortType.equalsIgnoreCase("a")) {        
            if (sortAlgorithm.equalsIgnoreCase("b")) {
                Utility.bubbleSort(shapeArray, compareBaseArea);
            }  else if (sortAlgorithm.equalsIgnoreCase("i")) {
                Utility.insertionSort(shapeArray, compareBaseArea);
            } else if (sortAlgorithm.equalsIgnoreCase("m")) {
                Utility.mergSort(shapeArray, 0, shapeArray.length - 1, compareBaseArea);
            } else if (sortAlgorithm.equalsIgnoreCase("q")) {
                Utility.quicksort(shapeArray, 0, shapeArray.length - 1, compareBaseArea);
            } else if (sortAlgorithm.equalsIgnoreCase("s")) {
                Utility.selectionSort(shapeArray, compareBaseArea);
            } 
        } else {
            System.out.println("Invalid sort type");
        }
        
        long endTime = System.currentTimeMillis();

        if (sortType == "h") {
            for (int i = 0; i < shapeArray.length; i += 1000) {
                System.out.println(String.format("Sorted by %s at index %d using %s: %.2f", sortType, i, sortAlgorithm, shapeArray[i].getHeight()));
            }
        } else if (sortType == "v") {
            for (int i = 0; i < shapeArray.length; i += 1000) {
                System.out.println(String.format("Sorted by %s at index %d using %s: %.2f", sortType, i, sortAlgorithm, shapeArray[i].calcVolume()));
        }
        } else if (sortType == "a") {
            for (int i = 0; i < shapeArray.length; i += 1000) {
                System.out.println(String.format("Sorted by %s at index %d using %s: %.2f", sortType, i, sortAlgorithm, shapeArray[i].calcBaseArea()));        }
        } else {
            System.out.println("Please enter valid comparing type");
        }

        // for (Shape s : shapeArray) {
        //     System.out.println(s);
        // }

        long elapsedTime = endTime - startTime;
        System.out.println("\nShape array length: " + shapeArray.length); // test code
        System.out.println("\nEXECUTION TIME: " + elapsedTime + " milliseconds\n"); // print algotithm execution time
    }
}
