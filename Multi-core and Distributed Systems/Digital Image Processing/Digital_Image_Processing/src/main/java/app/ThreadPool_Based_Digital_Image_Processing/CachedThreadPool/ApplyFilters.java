package app.ThreadPool_Based_Digital_Image_Processing.CachedThreadPool;

import app.ThreadPool_Based_Digital_Image_Processing.FilterTypes;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ApplyFilters {

    public static void main(String[] args) throws IOException {

        // Get the input image from the resource folder
        Scanner input = new Scanner(System.in);
        String filePath = "";
        System.out.println("Insert the name of the file path you would like to use:");
        filePath = input.nextLine();

        // Prompt user to choose a filter
        System.out.println("Choose a filter to apply:");
        System.out.println("1. Brighter");
        System.out.println("2. Grayscale");
        System.out.println("3. Swirl");
        System.out.println("4. Glass");
        System.out.println("5. Blur");
        System.out.println("6. Conditional Blur");
        int filterChoice = input.nextInt();

        input.close();

        // Create a FileWriter and PrintWriter to write to a text file
        FileWriter fileWriter = new FileWriter("execution_times.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);

        // Time related variables
        long startTime, endTime;

        ProcessingLogic filters = new ProcessingLogic(filePath);

        // Apply the selected filter
        switch (filterChoice) {
            case 1:
                startTime = System.currentTimeMillis();
                filters.applyFiltersCachedThreadPool(FilterTypes.BRIGHTER);
                endTime = System.currentTimeMillis();
                printWriter.println("Time taken for Brighter filter: " + (endTime - startTime) + " milliseconds");
                break;
            case 2:
                startTime = System.currentTimeMillis();
                filters.applyFiltersCachedThreadPool(FilterTypes.GRAYSCALE);
                endTime = System.currentTimeMillis();
                printWriter.println("Time taken for Grayscale filter: " + (endTime - startTime) + " milliseconds");
                break;
            case 3:
                startTime = System.currentTimeMillis();
                filters.applyFiltersCachedThreadPool(FilterTypes.SWIRL);
                endTime = System.currentTimeMillis();
                printWriter.println("Time taken for Swirl filter: " + (endTime - startTime) + " milliseconds");
                break;
            case 4:
                startTime = System.currentTimeMillis();
                filters.applyFiltersCachedThreadPool(FilterTypes.GLASS);
                endTime = System.currentTimeMillis();
                printWriter.println("Time taken for Glass filter: " + (endTime - startTime) + " milliseconds");
                break;
            case 5:
                startTime = System.currentTimeMillis();
                filters.applyFiltersCachedThreadPool(FilterTypes.BLUR);
                endTime = System.currentTimeMillis();
                printWriter.println("Time taken for Blur filter: " + (endTime - startTime) + " milliseconds");
                break;
            case 6:
                startTime = System.currentTimeMillis();
                filters.applyFiltersCachedThreadPool(FilterTypes.CONDITIONAL_BLUR);
                endTime = System.currentTimeMillis();
                printWriter.println("Time taken for Conditional Blur filter: " + (endTime - startTime) + " milliseconds");
                break;
            default:
                System.out.println("Invalid choice. Please choose a filter from 1 to 6.");
        }

        // Close PrintWriter and FileWriter
        printWriter.close();
        fileWriter.close();
    }
}
