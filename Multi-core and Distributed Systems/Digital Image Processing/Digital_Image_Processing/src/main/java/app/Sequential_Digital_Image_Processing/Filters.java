package app.Sequential_Digital_Image_Processing;

import java.awt.Color;
import java.io.IOException;
import java.util.Random;

public class Filters {

    String file;
    Color[][] image;

    // Constructor with filename for source image
    public Filters(String filename) {
        this.file = filename;
        image = Utils.loadImage(filename);
    }


    // Brighter filter works by adding value to each of the red, green, and blue of each pixel up to the maximum of 255
    public void BrighterFilter(int value) throws IOException {
        Color[][] tmp = Utils.copyImage(image);
        String outputFile = file.substring(0, file.lastIndexOf('.')) + "_brighter.jpg";

        // Runs through entire matrix
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[i].length; j++) {

                // fetches values of each pixel
                Color pixel = tmp[i][j];
                int r = pixel.getRed();
                int g = pixel.getGreen();
                int b = pixel.getBlue();

                // takes average of color values
                int bright = value;
                if (r + bright > 255)
                    r = 255;
                else
                    r = r + bright;
                if (g + bright > 255)
                    g = 255;
                else
                    g = g + bright;
                if (b + bright > 255)
                    b = 255;
                else
                    b = b + bright;

                // outputs average into picture to make grayscale
                tmp[i][j] = new Color(r, g, b);
            }
        }
        Utils.writeImage(tmp, outputFile);
    }

    // Grayscale filter converts each pixel to grayscale by taking the average of RGB values
    // Apply Grayscale filter to the pixel at (row, col)
    public void GrayscaleFilter() throws IOException {
        Color[][] tmp = Utils.copyImage(image);
        String outputFile = file.substring(0, file.lastIndexOf('.')) + "_grayscale.jpg";

        // Runs through entire matrix
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[i].length; j++) {

                // fetches values of each pixel
                Color pixel = tmp[i][j];
                int r = pixel.getRed();
                int g = pixel.getGreen();
                int b = pixel.getBlue();

                // Compute the average of RGB values
                int avg = (r + g + b) / 3;

                // Set each RGB component to the average value
                tmp[i][j] = new Color(avg, avg, avg);
            }
        }
        Utils.writeImage(tmp, outputFile);
    }

    // Swirl Filter is a non-linear image deformation that creates a whirlpool effect
    // Apply Swirl filter to the pixel at (row, col)
    public void SwirlFilter(int centerX, int centerY) throws IOException {
        Color[][] tmp = Utils.copyImage(image);
        String outputFile = file.substring(0, file.lastIndexOf('.')) + "_swirl.jpg";

        // Runs through entire matrix
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[i].length; j++) {

                // Calculate distance from center
                double dx = i - centerX;
                double dy = j - centerY;
                double d = Math.sqrt(dx * dx + dy * dy);

                // Calculate angle
                double theta = Math.PI / 256 * d;

                // Compute new coordinates
                int newX = (int) ((dx * Math.cos(theta) - dy * Math.sin(theta)) + centerX);
                int newY = (int) ((dx * Math.sin(theta) + dy * Math.cos(theta)) + centerY);

                // Ensure new coordinates are within image bounds
                if (newX >= 0 && newX < tmp.length && newY >= 0 && newY < tmp[0].length) {
                    tmp[i][j] = image[newX][newY];
                }
            }
        }
        Utils.writeImage(tmp, outputFile);
    }

    // Glass filter makes an image appear as if it were being viewed through different types of glass
    // Apply Glass filter to the pixel at (row, col)
    public void GlassFilter(int maxDistance) throws IOException {
        Color[][] tmp = Utils.copyImage(image);
        String outputFile = file.substring(0, file.lastIndexOf('.')) + "_glass.jpg";
        Random random = new Random();

        // Runs through entire matrix
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[i].length; j++) {

                // Generate random offsets within maxDistance
                int offsetX = random.nextInt(2 * maxDistance + 1) - maxDistance;
                int offsetY = random.nextInt(2 * maxDistance + 1) - maxDistance;

                // Calculate new coordinates
                int newX = i + offsetX;
                int newY = j + offsetY;

                // Ensure new coordinates are within image bounds
                if (newX >= 0 && newX < tmp.length && newY >= 0 && newY < tmp[0].length) {
                    // Replace the pixel with the pixel at the new coordinates
                    tmp[i][j] = image[newX][newY];
                }
            }
        }
        Utils.writeImage(tmp, outputFile);
    }

    // The Blur filters soften a selection or an image and are useful for retouching and blurring images
    // Apply Blur filter to the pixel at (row, col)
    public void BlurFilter(int neighborhoodSize) throws IOException {
        Color[][] tmp = Utils.copyImage(image);
        String outputFile = file.substring(0, file.lastIndexOf('.')) + "_blur.jpg";

        // Runs through entire matrix
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[i].length; j++) {

                // Initialize sum of RGB values and count of neighboring pixels
                int sumR = 0, sumG = 0, sumB = 0;
                int count = 0;

                // Iterate over neighborhood
                for (int x = Math.max(0, i - neighborhoodSize); x <= Math.min(tmp.length - 1, i + neighborhoodSize); x++) {
                    for (int y = Math.max(0, j - neighborhoodSize); y <= Math.min(tmp[i].length - 1, j + neighborhoodSize); y++) {
                        sumR += tmp[x][y].getRed();
                        sumG += tmp[x][y].getGreen();
                        sumB += tmp[x][y].getBlue();
                        count++;
                    }
                }

                // Calculate average RGB values
                int avgR = sumR / count;
                int avgG = sumG / count;
                int avgB = sumB / count;

                // Replace original pixel with the averaged pixel
                tmp[i][j] = new Color(avgR, avgG, avgB);
            }
        }
        Utils.writeImage(tmp, outputFile);
    }

    // The Conditional Blur is used to improve focus on a specific part of the image
    // Apply Conditional blur filter to the pixel at (row, col)
    public void ConditionalBlurFilter(int neighborhoodSize, int redThreshold) throws IOException {
        Color[][] tmp = Utils.copyImage(image);
        String outputFile = file.substring(0, file.lastIndexOf('.')) + "_conditional_blur.jpg";

        // Runs through entire matrix
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[i].length; j++) {

                // Check if the red value exceeds the threshold
                if (tmp[i][j].getRed() > redThreshold) {
                    // Initialize sum of RGB values and count of neighboring pixels
                    int sumR = 0, sumG = 0, sumB = 0;
                    int count = 0;

                    // Iterate over neighborhood
                    for (int x = Math.max(0, i - neighborhoodSize); x <= Math.min(tmp.length - 1, i + neighborhoodSize); x++) {
                        for (int y = Math.max(0, j - neighborhoodSize); y <= Math.min(tmp[i].length - 1, j + neighborhoodSize); y++) {
                            sumR += tmp[x][y].getRed();
                            sumG += tmp[x][y].getGreen();
                            sumB += tmp[x][y].getBlue();
                            count++;
                        }
                    }

                    // Calculate average RGB values
                    int avgR = sumR / count;
                    int avgG = sumG / count;
                    int avgB = sumB / count;

                    // Replace original pixel with the averaged pixel
                    tmp[i][j] = new Color(avgR, avgG, avgB);
                }
            }
        }
        Utils.writeImage(tmp, outputFile);
    }
}