package Week3.Homework.Algorithm;

import java.util.NoSuchElementException;

public class FixedCapacityStackOfStrings {
    private String[] a; // Mảng chứa các phần tử của Stack
    private int N;      // Số lượng phần tử hiện có trong Stack

    // Khởi tạo Stack với sức chứa cố định (capacity)
    public FixedCapacityStackOfStrings(int capacity) {
        a = new String[capacity];
        N = 0;
    }

    // Kiểm tra Stack có rỗng hay không
    public boolean isEmpty() {
        return N == 0;
    }

    // 1.3.1: Hàm isFull() kiểm tra Stack đã đầy chưa
    public boolean isFull() {
        return N == a.length;
    }

    // Trả về số lượng phần tử hiện có
    public int size() {
        return N;
    }

    // Thêm một phần tử vào đỉnh Stack
    public void push(String item) {
        if (isFull()) {
            throw new RuntimeException("Stack overflow: Stack đã đầy!");
        }
        a[N++] = item; // Thêm item vào vị trí N, sau đó tăng N lên 1
    }

    // Lấy và xóa phần tử ở đỉnh Stack
    public String pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow: Stack đang rỗng!");
        }
        String item = a[--N]; // Giảm N xuống 1, sau đó lấy item ở vị trí N
        a[N] = null;          // Tối ưu bộ nhớ (tránh loitered reference)
        return item;
    }
}

