package app.ThreadPool_Based_Digital_Image_Processing.CompletableFutures;

import app.ThreadPool_Based_Digital_Image_Processing.FilterTypes;
import app.ThreadPool_Based_Digital_Image_Processing.Filters;
import app.ThreadPool_Based_Digital_Image_Processing.Utils;

import java.awt.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ProcessingLogic {
    String file;
    Color[][] image;

    // Constructor with filename for source image
    public ProcessingLogic(String filename) {
        this.file = filename;
        // Load image to be processed
        image = Utils.loadImage(filename);
    }

    public void applyFiltersCompletableFuture(FilterTypes filterType) {
        // Start processing asynchronously
        CompletableFuture<Void> future = applyFiltersRecursivelyAsync(0, 0, image.length, image[0].length, filterType);

        // Wait for completion
        try {
            future.get();
            // Save the processed image
            saveImage(image, filterType);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private CompletableFuture<Void> applyFiltersRecursivelyAsync(int startRow, int startCol, int endRow, int endCol, FilterTypes filterType) {
        if (endRow - startRow <= 1 && endCol - startCol <= 1) {
            // Base case: Process a single pixel
            image[startRow][startCol] = applyFilter(startRow, startCol, filterType);
            return CompletableFuture.completedFuture(null);
        } else {
            // Split the image into smaller parts based on the number of rows and columns
            int midRow = (startRow + endRow) / 2;
            int midCol = (startCol + endCol) / 2;

            // Create CompletableFuture for each quadrant
            CompletableFuture<Void>[] futures;

            if (endRow - startRow > endCol - startCol) {
                // Split vertically
                futures = new CompletableFuture[]{
                        applyFiltersRecursivelyAsync(startRow, startCol, midRow, endCol, filterType),
                        applyFiltersRecursivelyAsync(midRow, startCol, endRow, endCol, filterType)
                };
            } else {
                // Split horizontally
                futures = new CompletableFuture[]{
                        applyFiltersRecursivelyAsync(startRow, startCol, endRow, midCol, filterType),
                        applyFiltersRecursivelyAsync(startRow, midCol, endRow, endCol, filterType)
                };
            }

            // Combine all CompletableFuture instances
            return CompletableFuture.allOf(futures);
        }
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
