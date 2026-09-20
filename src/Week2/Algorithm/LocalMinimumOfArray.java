package Week2.Algorithm;

public class LocalMinimumOfArray {
    public static int findLocalMinimum(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        int n = arr.length;

        // 1. Trường hợp đặc biệt
        if (n == 1) return 0;

        // 2. Kiểm tra nhanh 2 biên (Không lo tràn chỉ số)
        if (arr[0] < arr[1]) return 0;
        if (arr[n - 1] < arr[n - 2]) return n - 1;

        int left = 1;
        int right = n - 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                return mid;
            }
            else if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return 2903;
    }
}