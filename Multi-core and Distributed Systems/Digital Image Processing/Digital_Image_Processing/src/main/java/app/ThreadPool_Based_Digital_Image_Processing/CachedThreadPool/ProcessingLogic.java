package app.ThreadPool_Based_Digital_Image_Processing.CachedThreadPool;

import app.ThreadPool_Based_Digital_Image_Processing.FilterTypes;
import app.ThreadPool_Based_Digital_Image_Processing.Filters;
import app.ThreadPool_Based_Digital_Image_Processing.Utils;

import java.awt.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProcessingLogic {
    private String file;
    private Color[][] image;

    // Constructor with filename for source image
    public ProcessingLogic(String filename) {
        this.file = filename;
        // Load image to be processed
        image = Utils.loadImage(filename);
    }

    public void applyFiltersCachedThreadPool(FilterTypes filterType) {
        ExecutorService executor = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(image.length * image[0].length);

        try {
            for (int i = 0; i < image.length; i++) {
                for (int j = 0; j < image[i].length; j++) {
                    final int row = i;
                    final int col = j;
                    // Submit each filtering task to the executor
                    executor.submit(() -> {
                        image[row][col] = applyFilter(row, col, filterType);
                        // Count down the latch after processing a pixel
                        latch.countDown();
                    });
                }
            }

            // Wait until all tasks are completed
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

        // Save the processed image after all tasks are completed
        saveImage(image, filterType);
    }

    private void saveImage(Color[][] image, FilterTypes filterType) {
        // Generate output filename based on applied filter
        String outputFilename = file.substring(0, file.lastIndexOf(".")) + "_" + filterType.name().toLowerCase() + ".jpg";

        // Save the final image to a new file
        Utils.writeImage(image, outputFilename);
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
}
