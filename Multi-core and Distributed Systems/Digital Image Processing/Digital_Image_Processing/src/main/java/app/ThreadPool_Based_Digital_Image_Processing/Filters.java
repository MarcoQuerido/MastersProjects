package app.ThreadPool_Based_Digital_Image_Processing;

import java.awt.*;
import java.util.Random;

public class Filters {
    // Brighter filter works by adding value to each of the red, green, and blue of each pixel up to the maximum of 255
    public static Color BrighterFilter(Color[][] image, int row, int col, int value) {
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
    public static Color GrayscaleFilter(Color[][] image, int row, int col) {
        Color pixel = image[row][col];
        int avg = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
        return new Color(avg, avg, avg);
    }

    // Swirl Filter is a non-linear image deformation that creates a whirlpool effect
    // Apply Swirl filter to the pixel at (row, col)
    public static Color SwirlFilter(Color[][] image, int row, int col, int centerX, int centerY) {
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
    public static Color GlassFilter(Color[][] image, int row, int col, int maxDistance) {
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
    public static Color BlurFilter(Color[][] image, int row, int col, int neighborhoodSize) {
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
    public static Color ConditionalBlurFilter(Color[][] image, int row, int col, int neighborhoodSize, int redThreshold) {
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
