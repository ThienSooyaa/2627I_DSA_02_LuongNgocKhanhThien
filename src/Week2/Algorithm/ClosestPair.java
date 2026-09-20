package Week2.Algorithm;

/*1.4.16. Closest pair. Viết một chương trình nhận input là một mảng a[] gồm N giá trị double, tìm một cặp gần nhất
(closest pair) - là hai giá trị có hiệu không vượt quá hiệu của cặp số bất kì khác trong mảng. Hiệu ở đây tính bằng
giá trị tuyệt đối. Thuật toán cần có thời gian chạy NlogN trong trường hợp tồi nhất.
*/

import java.util.Arrays;

public class ClosestPair {

    /**
     * Tìm cặp giá trị gần nhất trong mảng a[]
     * @param a mảng các số double
     * @return mảng gồm 2 phần tử {val1, val2} là cặp số gần nhau nhất
     */
    public static double[] findClosestPair(double[] a) {
        // Kiểm tra trường hợp biên
        if (a == null || a.length < 2) {
            return new double[0]; // Mảng không đủ 2 phần tử
        }

        // Bước 1: Sắp xếp mảng tăng dần - O(N log N)
        Arrays.sort(a);

        int n = a.length;
        double minDiff = Double.MAX_VALUE;
        double firstNum = a[0];
        double secondNum = a[1];

        // Bước 2: Duyệt 1 vòng lặp kiểm tra các cặp kề nhau - O(N)
        for (int i = 1; i < n; i++) {
            double currentDiff = Math.abs(a[i] - a[i - 1]);

            if (currentDiff < minDiff) {
                minDiff = currentDiff;
                firstNum = a[i - 1];
                secondNum = a[i];
            }
        }

        return new double[]{firstNum, secondNum};
    }

    public static void main(String[] args) {
        double[] a = {3.5, 1.2, 9.8, 4.1, 1.25, 7.0};

        double[] result = findClosestPair(a);

        if (result.length == 2) {
            System.out.println("Cặp số gần nhất là: " + result[0] + " và " + result[1]);
            System.out.println("Khoảng cách nhỏ nhất: " + Math.abs(result[1] - result[0]));
        } else {
            System.out.println("Mảng không hợp lệ!");
        }
    }
}
