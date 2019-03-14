package HackerRankExercises;

import java.util.Arrays;
import java.util.Scanner;

/**
 * HackerRank: Hourglass sum
 *
 * This program will take a 6*6 2D
 * array as input, organise the array
 * into a total 16 hourglasses and calculate
 * the largest sum value from all
 * of these hourglasses.
 *
 * An hourglass in the 2D array will be
 * defined using the following format:
 *
 *      a b c
 *        d
 *      e f g
 *
 * Where each letter will represent a number store in the array
 * to form the hourglass.
 *
 * @author Ben Silveston
 */
public class HourglassSum {
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Define an hourglass from the 2D array
     * and find the maximum sum based on all
     * of the hourglasses.
     *
     * @param array The 6*6 2D array containing the 16 hourglass
     * @return The maximum hourglass sum value
     */
    private static int hourglassSum(int[][] array) {
        int maxHourglassSum = 0;
        int[] hourglassesArray = new int[16];
        int hourGlassCount = 0;

        for(int i = 0; i < array.length - 2; i++) {
            for(int j = 0; j < array[i].length - 2; j++) {
                hourglassesArray[hourGlassCount] =
                        array[i][j] + array[i][j + 1] + array[i][j + 2]
                        + array[i + 1][j + 1]
                        + array[i + 2][j] + array[i + 2][j + 1] + array[i + 2][j + 2];
                hourglassesArray[j] += maxHourglassSum;
                hourGlassCount++;
            }
        }
        Arrays.sort(hourglassesArray);

        // Test: print all hourglass values:
        System.out.println("\nHourglass sum values (in ascending order): ");
        for(int k = 0; k < hourglassesArray.length; k++) {
            System.out.print(hourglassesArray[k] + " ");
        }

        maxHourglassSum = hourglassesArray[hourglassesArray.length -1];
        return maxHourglassSum;
    }

    /**
     * Main method
     *
     * @param args The command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("Enter all the elements for the 6*6 (2D) array: ");
        int[][] array = new int[6][6];

        // Enter elements for the 2D array:
        for(int i = 0; i < 6; i++) {
            String[] arrayRowElements = SCANNER.nextLine().split(" ");
            for(int j = 0; j < 6; j++) {
                int arrayItem = Integer.parseInt(arrayRowElements[j]);
                array[i][j] = arrayItem;
            }
        }
        System.out.println("\nMaximum hourglass sum is: " + hourglassSum(array));
    }
}
