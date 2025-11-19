package app.Sequential_Digital_Image_Processing;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ApplyFilters {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String filePath = "";
        System.out.println("Insert the name of the file path you would like to use:");
        filePath = input.nextLine();
        input.close();
        Filters filters = new Filters(filePath);

        // Create a FileWriter and PrintWriter to write to a text file
        FileWriter fileWriter = new FileWriter("execution_times.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);

        long startTime, endTime;

        // BrighterFilter
        startTime = System.currentTimeMillis();
        filters.BrighterFilter(128);
        endTime = System.currentTimeMillis();
        printWriter.println("Time taken for Brighter filter: " + (endTime - startTime) + " milliseconds");

        // GrayscaleFilter
        startTime = System.currentTimeMillis();
        filters.GrayscaleFilter();
        endTime = System.currentTimeMillis();
        printWriter.println("Time taken for Grayscale filter: " + (endTime - startTime) + " milliseconds");

        // SwirlFilter
        startTime = System.currentTimeMillis();
        filters.SwirlFilter(348, 261);
        endTime = System.currentTimeMillis();
        printWriter.println("Time taken for Swirl filter: " + (endTime - startTime) + " milliseconds");

        // GlassFilter
        startTime = System.currentTimeMillis();
        filters.GlassFilter(10);
        endTime = System.currentTimeMillis();
        printWriter.println("Time taken for Glass filter: " + (endTime - startTime) + " milliseconds");

        // BlurFilter
        startTime = System.currentTimeMillis();
        filters.BlurFilter(15);
        endTime = System.currentTimeMillis();
        printWriter.println("Time taken for Blur filter: " + (endTime - startTime) + " milliseconds");

        // ConditionalBlurFilter
        startTime = System.currentTimeMillis();
        filters.ConditionalBlurFilter(15, 150);
        endTime = System.currentTimeMillis();
        printWriter.println("Time taken for Conditional Blur filter: " + (endTime - startTime) + " milliseconds");

        // Close PrintWriter and FileWriter
        printWriter.close();
        fileWriter.close();
    }
}
