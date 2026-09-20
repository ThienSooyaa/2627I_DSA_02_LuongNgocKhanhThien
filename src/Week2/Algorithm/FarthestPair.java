package Week2.Algorithm;

/*
 * Bài tập 1.4.17 - Algorithms (4th Edition) - Robert Sedgewick
 * Đề bài: Tìm cặp số double xa nhau nhất (hiệu tuyệt đối lớn nhất) trong mảng N phần tử.
 *
 * Độ phức tạp thời gian (Time Complexity): O(N) trong trường hợp tồi nhất.
 * Độ phức tạp bộ nhớ (Space Complexity): O(1) bộ nhớ phụ.
 */
public class FarthestPair {

    /**
     * Hàm tìm cặp giá trị có khoảng cách lớn nhất trong mảng
     * @param a mảng các số double
     * @return mảng 2 phần tử {min, max} có khoảng cách lớn nhất
     */
    public static double[] findFarthestPair(double[] a) {
        // Kiểm tra trường hợp biên (mảng null hoặc ít hơn 2 phần tử)
        if (a == null || a.length < 2) {
            return new double[0];
        }

        double min = a[0];
        double max = a[0];

        // Duyệt 1 lượt qua mảng để tìm min và max -> O(N)
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
            if (a[i] > max) {
                max = a[i];
            }
        }

        // Cặp xa nhất chính là (min, max)
        return new double[]{min, max};
    }

    public static void main(String[] args) {
        // Test case 1: Mảng số thực dương
        double[] test1 = {3.5, 1.2, 9.8, 4.1, 1.25, 7.0};
        double[] res1 = findFarthestPair(test1);
        System.out.println("--- Test 1 ---");
        System.out.println("Cặp số xa nhất: (" + res1[0] + ", " + res1[1] + ")");
        System.out.println("Khoảng cách lớn nhất: " + Math.abs(res1[1] - res1[0]));

        // Test case 2: Mảng gồm cả số âm và số dương
        double[] test2 = {-10.5, 0.0, 3.14, 25.0, -1.5};
        double[] res2 = findFarthestPair(test2);
        System.out.println("\n--- Test 2 ---");
        System.out.println("Cặp số xa nhất: (" + res2[0] + ", " + res2[1] + ")");
        System.out.println("Khoảng cách lớn nhất: " + Math.abs(res2[1] - res2[0]));
    }
}