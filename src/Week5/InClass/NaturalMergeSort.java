package Week5.InClass;

import java.util.Arrays;

public class NaturalMergeSort {

    public static void naturalMergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;
        int[] temp = new int[n]; // Mảng phụ dùng để chứa dữ liệu khi merge
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;
            int i = 0;

            // Quét toàn bộ mảng trong một lượt
            while (i < n) {
                int start1 = i;
                int end1 = start1;

                // 1. Tìm chuỗi con tăng dần thứ nhất (Run 1)
                while (end1 < n - 1 && arr[end1] <= arr[end1 + 1]) {
                    end1++;
                }

                // Nếu Run 1 kéo dài từ đầu đến cuối mảng -> Mảng đã được sắp xếp hoàn toàn
                if (start1 == 0 && end1 == n - 1) {
                    isSorted = true;
                    break;
                }

                int start2 = end1 + 1;

                // Nếu không còn phần tử nào cho Run 2, bỏ qua để xét ở lượt quét tiếp theo
                if (start2 >= n) {
                    break;
                }

                int end2 = start2;

                // 2. Tìm chuỗi con tăng dần thứ hai (Run 2)
                while (end2 < n - 1 && arr[end2] <= arr[end2 + 1]) {
                    end2++;
                }

                // 3. Trộn (Merge) Run 1 và Run 2
                merge(arr, temp, start1, end1, end2);

                // Vì vừa thực hiện merge, mảng vẫn chưa được sắp xếp hoàn toàn trong một chuỗi duy nhất
                isSorted = false;

                // Dịch chuyển con trỏ để tìm cặp Run tiếp theo trong lượt quét này
                i = end2 + 1;
            }
        }
    }

    // Hàm hợp nhất 2 mảng con đã sắp xếp: arr[left...mid] và arr[mid+1...right]
    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        // So sánh và đưa phần tử nhỏ hơn vào mảng phụ temp
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // Đưa các phần tử còn dư của mảng bên trái vào temp
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Đưa các phần tử còn dư của mảng bên phải vào temp
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy dữ liệu từ mảng phụ temp trả lại mảng gốc arr
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }

    // Hàm main để kiểm thử
    public static void main(String[] args) {
        int[] arr = {10, 5, 7, 2, 4, 6, 1, 9, 8, 3};

        System.out.println("Mảng ban đầu: " + Arrays.toString(arr));
        naturalMergeSort(arr);
        System.out.println("Mảng lúc sau: "+Arrays.toString(arr));
    }
}