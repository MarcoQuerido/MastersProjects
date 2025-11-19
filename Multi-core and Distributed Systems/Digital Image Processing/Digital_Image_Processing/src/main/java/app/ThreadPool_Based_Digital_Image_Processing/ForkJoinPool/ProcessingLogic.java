package app.ThreadPool_Based_Digital_Image_Processing.ForkJoinPool;

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

    public void applyFiltersForkJoinPool(FilterTypes filterType) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        // Create a RecursiveAction to process the image
        RecursiveAction task = new RecursiveAction() {
            @Override
            protected void compute() {
                applyFiltersRecursively(0, 0, image.length, image[0].length, filterType);
            }
        };

        // Execute the task
        forkJoinPool.invoke(task);

        // Shutdown the ForkJoinPool
        forkJoinPool.shutdown();

        // Save the final image
        saveImage(filterType);
    }

    private void saveImage(FilterTypes filterType) {
        // Save the final image to a new file
        String outputFilename = file.substring(0, file.lastIndexOf(".")) + "_" + filterType.name().toLowerCase() + ".jpg";
        Color[][] tmp = Utils.copyImage(image);
        Utils.writeImage(tmp, outputFilename);
    }

    private void applyFiltersRecursively(int startRow, int startCol, int endRow, int endCol, FilterTypes filterType) {
        // Base case: Process a single pixel
        if (endRow - startRow == 1 && endCol - startCol == 1) {
            image[startRow][startCol] = applyFilter(startRow, startCol, filterType);
            return;
        }

        if (endRow - startRow > endCol - startCol) {
            // Split the image vertically
            int midRow = (startRow + endRow) / 2;

            // Create subtasks for each half of the image
            RecursiveAction[] subtasks = {
                    new RecursiveAction() {
                        @Override
                        protected void compute() {
                            applyFiltersRecursively(startRow, startCol, midRow, endCol, filterType);
                        }
                    },
                    new RecursiveAction() {
                        @Override
                        protected void compute() {
                            applyFiltersRecursively(midRow, startCol, endRow, endCol, filterType);
                        }
                    }
            };

            // Fork subtasks
            for (RecursiveAction subtask : subtasks) {
                subtask.fork();
            }

            // Join subtasks
            for (RecursiveAction subtask : subtasks) {
                subtask.join();
            }
        } else {
            // Split the image horizontally
            int midCol = (startCol + endCol) / 2;

            // Create subtasks for each half of the image
            RecursiveAction[] subtasks = {
                    new RecursiveAction() {
                        @Override
                        protected void compute() {
                            applyFiltersRecursively(startRow, startCol, endRow, midCol, filterType);
                        }
                    },
                    new RecursiveAction() {
                        @Override
                        protected void compute() {
                            applyFiltersRecursively(startRow, midCol, endRow, endCol, filterType);
                        }
                    }
            };

            // Fork subtasks
            for (RecursiveAction subtask : subtasks) {
                subtask.fork();
            }

            // Join subtasks
            for (RecursiveAction subtask : subtasks) {
                subtask.join();
            }
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
                return Filters.SwirlFilter(image, row, col, image.length / 2, image[0].length / 2);
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
