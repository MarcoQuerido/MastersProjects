package app.MultiThreaded_Digital_Image_Processing;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ApplyFilters {

    public static void main(String[] args) throws IOException, InterruptedException {

        // Get the input image from the resource folder
        Scanner input = new Scanner(System.in);
        String filePath = "";
        System.out.println("Insert the name of the file path you would like to use:");
        filePath = input.nextLine();
        input.close();

        // Create a FileWriter and PrintWriter to write to a text file
        FileWriter fileWriter = new FileWriter("execution_times.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);

        // Time related variables
        long startTime, endTime;

        Filters filters = new Filters(filePath);

        /*
            -> Define number of threads <-
            This is where we manipulate the number of threads to test the threshold of the application
            In the project report, a series of tests will be shown with different numbers of threads used
            for each test, as well as different image sizes used
         */

        int numThreads = 10;

        // BrighterFilter
        startTime = System.currentTimeMillis();
        filters.applyFiltersMultiThreaded(numThreads, FilterTypes.BRIGHTER);
        endTime = System.currentTimeMillis();
        printWriter.println("Time taken for Brighter filter: " + (endTime - startTime) + " milliseconds");

        // GrayscaleFilter
        startTime = System.currentTimeMillis();
        filters.applyFiltersMultiThreaded(numThreads, FilterTypes.GRAYSCALE);
        endTime = System.currentTimeMillis();
        printWriter.println("Time taken for Grayscale filter: " + (endTime - startTime) + " milliseconds");

        // SwirlFilter
        startTime = System.currentTimeMillis();
        filters.applyFiltersMultiThreaded(numThreads, FilterTypes.SWIRL);
        endTime = System.currentTimeMillis();
        printWriter.println("Time taken for Swirl filter: " + (endTime - startTime) + " milliseconds");

        // GlassFilter
        startTime = System.currentTimeMillis();
        filters.applyFiltersMultiThreaded(numThreads, FilterTypes.GLASS);
        endTime = System.currentTimeMillis();
        printWriter.println("Time taken for Glass filter: " + (endTime - startTime) + " milliseconds");

        // BlurFilter
        startTime = System.currentTimeMillis();
        filters.applyFiltersMultiThreaded(numThreads, FilterTypes.BLUR);
        endTime = System.currentTimeMillis();
        printWriter.println("Time taken for Blur filter: " + (endTime - startTime) + " milliseconds");

        // ConditionalBlurFilter
        startTime = System.currentTimeMillis();
        filters.applyFiltersMultiThreaded(numThreads, FilterTypes.CONDITIONAL_BLUR);
        endTime = System.currentTimeMillis();
        printWriter.println("Time taken for Conditional Blur filter: " + (endTime - startTime) + " milliseconds");

        // Close PrintWriter and FileWriter
        printWriter.close();
        fileWriter.close();
    }
}
