package app.ThreadPool_Based_Digital_Image_Processing.FixedThreadPool;

import app.ThreadPool_Based_Digital_Image_Processing.FilterTypes;
import app.ThreadPool_Based_Digital_Image_Processing.Filters;
import app.ThreadPool_Based_Digital_Image_Processing.Utils;

import java.awt.*;
import java.util.concurrent.*;

public class ProcessingLogic {
    String file;
    Color[][] image;

    // Constructor with filename for source image
    public ProcessingLogic(String filename) {
        this.file = filename;
        // Load image to be processed
        image = Utils.loadImage(filename);
    }

    public void applyFiltersThreadPool(int numThreads, FilterTypes filterType) {
        int imageHeight = image.length;
        int imageWidth = image[0].length;

        // Calculate chunk sizes for width
        int chunkWidth = imageWidth / numThreads;

        // Create an ExecutorService with a fixed thread pool size
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        // Submit tasks for processing sections
        for (int i = 0; i < numThreads; i++) {
            final int colStart = i * chunkWidth;
            final int colEnd = (i == numThreads - 1) ? imageWidth : (colStart + chunkWidth);

            executor.submit(() -> {
                for (int row = 0; row < imageHeight; row++) {
                    for (int col = colStart; col < colEnd; col++) {
                        image[row][col] = applyFilter(row, col, filterType);
                    }
                }
            });
        }

        // Shutdown the executor
        executor.shutdown();

        // Wait for all tasks to complete
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Save the processed image
        saveImage(image, filterType);
    }

    private Color applyFilter(int row, int col, FilterTypes filterType) {
        switch (filterType) {
            case BRIGHTER:
                // Apply Brighter filter to the pixel at (row, col)
                return Filters.BrighterFilter(image, row, col, 128);
            case GRAYSCALE:
                // Apply Grayscale filter to the pixel at (row, col)
                return Filters.GrayscaleFilter(image, row, col);
            case SWIRL:
                // Apply Swirl filter to the pixel at (row, col)
                return Filters.SwirlFilter(image, row, col, 348, 261); // Example centerX and centerY values
            case GLASS:
                // Apply Glass filter to the pixel at (row, col)
                return Filters.GlassFilter(image, row, col, 10); // Example maxDistance
            case BLUR:
                // Apply Blur filter to the pixel at (row, col)
                return Filters.BlurFilter(image, row, col, 15); // Example neighborhoodSize
            case CONDITIONAL_BLUR:
                // Apply Conditional Blur filter to the pixel at (row, col)
                return Filters.ConditionalBlurFilter(image, row, col, 15, 150); // Example neighborhoodSize and redThreshold
            default:
                // Unsupported filter type
                System.out.println("Filter type not recognized!");
                return null;
        }
    }

    private void saveImage(Color[][] image, FilterTypes filterType) {
        // Generate output filename based on applied filter
        String outputFilename = file.substring(0, file.lastIndexOf(".")) + "_" + filterType.name().toLowerCase() + ".jpg";

        // Save the final image to a new file
        Utils.writeImage(image, outputFilename);
    }
}
