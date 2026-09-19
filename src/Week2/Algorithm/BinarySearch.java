package Week2.Algorithm;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;


public class BinarySearch {
    public static long findFirstIndex(int x, int[] arr) {
        int result = -1;
        int left = 0;
        int right = arr.length-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < x) {
                left = mid + 1;
            } else if (arr[mid] > x) {
                right = mid - 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }
        return result;
    }
}
