package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class NonOverlappingIntervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        // Sort intervals based on end points
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int nonOverlapCount = 1;
        int end = intervals[0][1];

        // Iterate through sorted intervals and find non-overlapping intervals
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                nonOverlapCount++;
                end = intervals[i][1];
            }
        }

        // Calculate the minimum number of intervals to remove
        return intervals.length - nonOverlapCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of intervals
        System.out.print("Enter the number of intervals: ");
        int n = scanner.nextInt();

        // Input intervals
        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter interval " + (i + 1) + " (start end): ");
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
        }

        int result = eraseOverlapIntervals(intervals);

        System.out.println("Minimum number of intervals to remove: " + result);
    }
}
