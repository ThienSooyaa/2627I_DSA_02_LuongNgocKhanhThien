package Week5.InClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Result {

    /*
     * Hàm Counting Sort sắp xếp và trả về danh sách đã được sắp xếp
     */
    public static List<Integer> countingSort(List<Integer> arr) {
        List<Integer> result = new ArrayList<>();
        List<Integer> count = new ArrayList<>(Collections.nCopies(100, 0));

        // Bước 1: Đếm tần suất xuất hiện của từng số
        for (int num : arr) {
            count.set(num, count.get(num) + 1);
        }

        // Bước 2: Dựng lại danh sách đã sắp xếp từ mảng count[cite: 3]
        for (int i = 0; i < 100; i++) {
            while (count.get(i) > 0) {
                result.add(i);
                count.set(i, count.get(i) - 1);
            }
        }

        return result;
    }
}

public class CountingSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng phần tử n: ");
        int n = scanner.nextInt();

        List<Integer> arr = new ArrayList<>();
        System.out.println("Nhập " + n + " phần tử (giá trị từ 0 đến 99):");
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }

        // Gọi hàm sắp xếp
        List<Integer> sortedArr = Result.countingSort(arr);

        // In kết quả
        System.out.println("\nMảng sau khi sắp xếp (Counting Sort):");
        System.out.println(sortedArr);

        scanner.close();
    }
}
