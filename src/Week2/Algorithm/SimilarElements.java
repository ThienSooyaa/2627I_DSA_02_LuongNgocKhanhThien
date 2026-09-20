package Week2.Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Week2.Algorithm.BinarySearch.findFirstIndex;

// Two Pointer

public class SimilarElements {
    public static List listSimilar(int[] arr1, int[] arr2) {
        List<Integer> result = new ArrayList<>();
        int length1 = arr1.length;
        int length2 = arr2.length;
        int pointer1 = 0;
        int pointer2 = 0;
        while (pointer1 < length1 && pointer2 < length2) {
            if (arr1[pointer1] == arr2[pointer2]) {
                if (result.isEmpty() || result.get(result.size() - 1) != arr1[pointer1]) {
                    result.add(arr1[pointer1]);
                pointer1++;
                pointer2++;}
                } else if (arr1[pointer1] < arr2[pointer2]) {
                    pointer1++;
                } else if (arr1[pointer1] > arr2[pointer2]) {
                    pointer2++;
                }

        }
        return result;
    }
}

