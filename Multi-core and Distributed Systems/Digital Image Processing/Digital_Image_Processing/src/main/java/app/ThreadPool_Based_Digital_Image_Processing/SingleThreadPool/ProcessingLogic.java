package app.ThreadPool_Based_Digital_Image_Processing.SingleThreadPool;

import app.ThreadPool_Based_Digital_Image_Processing.FilterTypes;
import app.ThreadPool_Based_Digital_Image_Processing.Filters;
import app.ThreadPool_Based_Digital_Image_Processing.Utils;

import java.awt.*;

public class ProcessingLogic {
    String file;
    Color[][] image;

    // Constructor with filename for source image
    public ProcessingLogic(String filename) {
        this.file = filename;
        // Load image to be processed
        image = Utils.loadImage(filename);
    }

    public void applyFiltersThreadPoolSingleThread(FilterTypes filterType) {
        applyFiltersSingleThreadRecursive(0, image.length, filterType);
        // Save the processed image after all recursive processing is done
        saveImage(image, filterType);
    }

    private void applyFiltersSingleThreadRecursive(int startRow, int endRow, FilterTypes filterType) {
        int imageWidth = image[0].length;
        int midRow = (startRow + endRow) / 2;

        // Base case: if the height of the image segment is 1, process the pixels in that segment
        if (startRow == endRow - 1) {
            for (int col = 0; col < imageWidth; col++) {
                image[startRow][col] = applyFilter(startRow, col, filterType);
            }
        } else {
            // Recursive case: split the image vertically in half and process each half recursively
            applyFiltersSingleThreadRecursive(startRow, midRow, filterType);
            applyFiltersSingleThreadRecursive(midRow, endRow, filterType);
        }
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
