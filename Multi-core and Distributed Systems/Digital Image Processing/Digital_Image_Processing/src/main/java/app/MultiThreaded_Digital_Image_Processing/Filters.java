package app.MultiThreaded_Digital_Image_Processing;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Filters {

    String file;
    Color[][] image;

    // Constructor with filename for source image
    public Filters(String filename) {
        this.file = filename;
        // Load image to be processed
        image = Utils.loadImage(filename);
    }

    public void applyFiltersMultiThreaded(int numThreads, FilterTypes filterType) throws InterruptedException {
        int imageHeight = image.length;
        int imageWidth = image[0].length;

        // Calculate chunk sizes for height
        int chunkHeight = (int) Math.ceil((double) imageHeight / numThreads);

        // Array to store the processed chunks
        // This will guarantee that the chunks are written in the correct order
        Color[][][] processedChunks = new Color[numThreads][][];

        // Create a ReentrantLock for synchronization
        Lock lock = new ReentrantLock();

        // Create threads for processing chunks
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < numThreads; i++) {
            final int threadIndex = i;
            final int rowStart = i * chunkHeight;
            final int rowEnd = Math.min(rowStart + chunkHeight, imageHeight);

            Thread thread = new Thread(() -> {
                Color[][] localProcessedChunk = new Color[rowEnd - rowStart][imageWidth];
                for (int row = rowStart; row < rowEnd; row++) {
                    for (int col = 0; col < imageWidth; col++) {
                        localProcessedChunk[row - rowStart][col] = applyFilter(row, col, filterType);
                    }
                }
                // Lock before accessing the shared resource
                lock.lock();
                try {
                    // Store the processed chunk in the array at the correct index
                    processedChunks[threadIndex] = localProcessedChunk;
                } finally {
                    // Ensure unlock is called even if an exception occurs
                    lock.unlock();
                }
            });
            thread.start();
            threads.add(thread);
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            thread.join();
        }

        // Combine the processed chunks into the final image
        Color[][] finalImage = new Color[imageHeight][imageWidth];
        int rowOffset = 0;
        for (Color[][] chunk : processedChunks) {
            if (chunk != null) {
                for (int row = 0; row < chunk.length; row++) {
                    System.arraycopy(chunk[row], 0, finalImage[rowOffset + row], 0, chunk[row].length);
                }
                rowOffset += chunk.length;
            }
        }

        // Save the final image to a new file
        String outputFilename = file.substring(0, file.lastIndexOf(".")) + "_" + filterType.name().toLowerCase() + ".jpg";

        Color[][] tmp = Utils.copyImage(finalImage);
        Utils.writeImage(tmp, outputFilename);
    }

    private Color applyFilter(int row, int col, FilterTypes filterType) {
        switch (filterType) {
            case BRIGHTER:
                // Apply Brighter filter to the pixel at (row, col)
                return BrighterFilter(row, col, 128);
            case GRAYSCALE:
                // Apply Grayscale filter to the pixel at (row, col)
                return GrayscaleFilter(row, col);
            case SWIRL:
                // Apply Swirl filter to the pixel at (row, col)
                return SwirlFilter(row, col, 348, 261); // Example centerX and centerY values
            case GLASS:
                // Apply Glass filter to the pixel at (row, col)
                return GlassFilter(row, col, 10); // Example maxDistance
            case BLUR:
                // Apply Blur filter to the pixel at (row, col)
                return BlurFilter(row, col, 15); // Example neighborhoodSize
            case CONDITIONAL_BLUR:
                // Apply Conditional Blur filter to the pixel at (row, col)
                return ConditionalBlurFilter(row, col, 15, 150); // Example neighborhoodSize and redThreshold
            default:
                // Unsupported filter type
                System.out.println("Filter type not recognized!");
                return null;
        }
    }

    // Brighter filter works by adding value to each of the red, green, and blue of each pixel up to the maximum of 255
    private Color BrighterFilter(int row, int col, int value) {
        Color pixel = image[row][col];
        int r = pixel.getRed() + value;
        int g = pixel.getGreen() + value;
        int b = pixel.getBlue() + value;
        r = Math.min(r, 255);
        g = Math.min(g, 255);
        b = Math.min(b, 255);
        return new Color(r, g, b);
    }

    // Grayscale filter converts each pixel to grayscale by taking the average of RGB values
    // Apply Grayscale filter to the pixel at (row, col)
    private Color GrayscaleFilter(int row, int col) {
        Color pixel = image[row][col];
        int avg = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
        return new Color(avg, avg, avg);
    }

    // Swirl Filter is a non-linear image deformation that creates a whirlpool effect
    // Apply Swirl filter to the pixel at (row, col)
    private Color SwirlFilter(int row, int col, int centerX, int centerY) {
        double dx = row - centerX;
        double dy = col - centerY;
        double d = Math.sqrt(dx * dx + dy * dy);
        double theta = Math.PI / 256 * d;
        int newX = (int) ((dx * Math.cos(theta) - dy * Math.sin(theta)) + centerX);
        int newY = (int) ((dx * Math.sin(theta) + dy * Math.cos(theta)) + centerY);
        if (newX >= 0 && newX < image.length && newY >= 0 && newY < image[0].length) {
            return image[newX][newY];
        } else {
            return new Color(0, 0, 0); // Return black if coordinates are out of bounds
        }
    }

    // Glass filter makes an image appear as if it were being viewed through different types of glass
    // Apply Glass filter to the pixel at (row, col)
    private Color GlassFilter(int row, int col, int maxDistance) {
        Random random = new Random();
        int offsetX = random.nextInt(2 * maxDistance + 1) - maxDistance;
        int offsetY = random.nextInt(2 * maxDistance + 1) - maxDistance;
        int newX = row + offsetX;
        int newY = col + offsetY;
        if (newX >= 0 && newX < image.length && newY >= 0 && newY < image[0].length) {
            return image[newX][newY];
        } else {
            return new Color(0, 0, 0); // Return black if coordinates are out of bounds
        }
    }

    // The Blur filters soften a selection or an image and are useful for retouching and blurring images
    // Apply Blur filter to the pixel at (row, col)
    private Color BlurFilter(int row, int col, int neighborhoodSize) {
        int sumR = 0, sumG = 0, sumB = 0;
        int count = 0;
        for (int x = Math.max(0, row - neighborhoodSize); x <= Math.min(image.length - 1, row + neighborhoodSize); x++) {
            for (int y = Math.max(0, col - neighborhoodSize); y <= Math.min(image[0].length - 1, col + neighborhoodSize); y++) {
                sumR += image[x][y].getRed();
                sumG += image[x][y].getGreen();
                sumB += image[x][y].getBlue();
                count++;
            }
        }
        int avgR = sumR / count;
        int avgG = sumG / count;
        int avgB = sumB / count;
        return new Color(avgR, avgG, avgB);
    }

    // The Conditional Blur is used to improve focus on a specific part of the image
    // Apply Conditional blur filter to the pixel at (row, col)
    private Color ConditionalBlurFilter(int row, int col, int neighborhoodSize, int redThreshold) {
        if (image[row][col].getRed() > redThreshold) {
            int sumR = 0, sumG = 0, sumB = 0;
            int count = 0;
            for (int x = Math.max(0, row - neighborhoodSize); x <= Math.min(image.length - 1, row + neighborhoodSize); x++) {
                for (int y = Math.max(0, col - neighborhoodSize); y <= Math.min(image[0].length - 1, col + neighborhoodSize); y++) {
                    sumR += image[x][y].getRed();
                    sumG += image[x][y].getGreen();
                    sumB += image[x][y].getBlue();
                    count++;
                }
            }
            int avgR = sumR / count;
            int avgG = sumG / count;
            int avgB = sumB / count;
            return new Color(avgR, avgG, avgB);
        } else {
            return image[row][col];
        }
    }
}
