package ThreadPool_Based_Digital_Image_Processing.CompletableFutures;

import app.Config;
import app.ThreadPool_Based_Digital_Image_Processing.CompletableFutures.ProcessingLogic;
import app.ThreadPool_Based_Digital_Image_Processing.FilterTypes;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FilterTest {
    public static void main(String[] args) throws IOException {

        // Create a FileWriter and PrintWriter to write to a text file
        FileWriter fileWriter = new FileWriter(Config.OUTPUT_PATH_COMPLETABLEFUTURES);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        // Write the table header
        printWriter.println(Config.TABLE_HEADER_NOTHREADS);

        // Apply filters for image 1
        for (FilterTypes filterType : FilterTypes.values()) {
            testFilter(filterType, Config.TEST_IMAGES_PATHS[0], printWriter, Config.TEST_IMAGES_SIZES[0]);
        }

        // Apply filters for image 2
        for (FilterTypes filterType : FilterTypes.values()) {
            testFilter(filterType, Config.TEST_IMAGES_PATHS[1], printWriter, Config.TEST_IMAGES_SIZES[1]);
        }

        // Apply filters for image 3
        for (FilterTypes filterType : FilterTypes.values()) {
            testFilter(filterType, Config.TEST_IMAGES_PATHS[2], printWriter, Config.TEST_IMAGES_SIZES[2]);
        }

        // Close PrintWriter and FileWriter
        printWriter.close();
        fileWriter.close();
    }

    private static void testFilter(FilterTypes filterType, String filePath, PrintWriter printWriter, String size) {
        long totalExecutionTime = 0;

        for (int i = 1; i <= Config.NUM_TESTS; i++) {
            long startTime = System.currentTimeMillis();

            // Apply the filter
            ProcessingLogic filters = new ProcessingLogic(filePath);
            filters.applyFiltersCompletableFuture(filterType);

            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;

            // Accumulate total execution time
            totalExecutionTime += executionTime;
            printWriter.println("|  " + size + " |   " + filterType + "   | Test " + i + " | " + executionTime + " ms");
        }

        // Calculate average execution time
        long averageExecutionTime = totalExecutionTime / Config.NUM_TESTS;

        // Write results to file
        printWriter.println("Average time taken for " + filterType.name() + " filter over " + Config.NUM_TESTS + " tests: " + averageExecutionTime + " milliseconds\n");
    }
}
