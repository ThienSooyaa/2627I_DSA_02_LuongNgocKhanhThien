package Week2.Algorithm;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
//xét cả các số liền nhau có cùng giá trị vd như 1 2 2 2 2 2 4 5 5 6 6 8
public class EqualPairs {
    public static long countPairs(int[] a) {
        Arrays.sort(a);
        long count = 0;
        long runLength = 1;

        for (int i = 1; i < a.length; i++) {
            if (a[i] == a[i - 1]) {
                runLength++;
            }
            else {
                // Tính số cặp C(k, 2) = k * (k - 1) / 2
                count += runLength * (runLength - 1) / 2;
                runLength = 1; // reset lại
            }
        }
        // cộng nốt nhóm cuối cùng
        count += runLength * (runLength - 1) / 2;
        return count;
    }
}
