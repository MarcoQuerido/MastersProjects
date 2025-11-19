package MultiThreaded_Digital_Image_Processing;

import app.MultiThreaded_Digital_Image_Processing.Filters;
import app.MultiThreaded_Digital_Image_Processing.FilterTypes;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import app.Config;

public class FilterTest {

    public static void main(String[] args) throws IOException, InterruptedException {

        FileWriter fileWriter = new FileWriter(Config.OUTPUT_PATH_MULTITHREADED);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        Filters[] filters = new Filters[Config.TEST_IMAGES_PATHS.length];
        for (int i = 0; i < Config.TEST_IMAGES_PATHS.length; i++) {
            filters[i] = new Filters(Config.TEST_IMAGES_PATHS[i]);
        }

        // Write the table header
        printWriter.println(Config.TABLE_HEADER);

        for (int i = 0; i < Config.TEST_IMAGES_PATHS.length; i++) {
            for (FilterTypes filterType : FilterTypes.values()) {
                testFilter(filters[i], filterType, printWriter, Config.TEST_IMAGES_SIZES[i]);
            }
        }

        printWriter.close();
        fileWriter.close();
    }

    private static void testFilter(Filters filters, FilterTypes filterType, PrintWriter printWriter, String size) throws InterruptedException {
        long totalTime = 0;

        for (int i = 1; i <= Config.NUM_TESTS; i++) {
            long startTime = System.currentTimeMillis();

            // Run the filter with multiple threads
            filters.applyFiltersMultiThreaded(Config.NUM_THREADS, filterType);

            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            totalTime += elapsedTime;

            printWriter.println("|  " + size + " |   " + filterType + "   |          " + Config.NUM_THREADS + "         | Test " + i + " | " + elapsedTime + " ms");
        }

        long averageTime = totalTime / Config.NUM_TESTS;
        printWriter.println("Average time for " + filterType + " filter with " + Config.NUM_THREADS + " threads: " + averageTime + " milliseconds\n");
    }
}
