package Sequential_Digital_Image_Processing;

import app.Config;
import app.Sequential_Digital_Image_Processing.Filters;
import app.Sequential_Digital_Image_Processing.FilterTypes;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FilterTest {

    public static void main(String[] args) throws IOException {

        FileWriter fileWriter = new FileWriter(Config.OUTPUT_PATH_SEQUENTIAL);
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

    private static void testFilter(Filters filters, FilterTypes filterType, PrintWriter printWriter, String size) throws IOException {
        long totalTime = 0;

        for (int i = 1; i <= Config.NUM_TESTS; i++) {
            long startTime = System.currentTimeMillis();

            // Call the appropriate filter method
            switch (filterType) {
                case BRIGHTER:
                    filters.BrighterFilter(128);
                    break;
                case GRAYSCALE:
                    filters.GrayscaleFilter();
                    break;
                case SWIRL:
                    filters.SwirlFilter(348, 261);
                    break;
                case GLASS:
                    filters.GlassFilter(10);
                    break;
                case BLUR:
                    filters.BlurFilter(15);
                    break;
                case CONDITIONAL_BLUR:
                    filters.ConditionalBlurFilter(15, 150);
                    break;
            }

            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            totalTime += elapsedTime;

            printWriter.println("|  " + size + " | \t" + filterType + " \t|    Test " + i + " \t| \t" + elapsedTime);
        }

        long averageTime = totalTime / Config.NUM_TESTS;
        printWriter.println("Average time for " + filterType + " filter: " + averageTime + " milliseconds\n");
    }
}
