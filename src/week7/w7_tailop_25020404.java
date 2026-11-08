package week7;
import java.util.PriorityQueue;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class Result {
    public static List<Double> runningMedian(List<Integer> a) {
        // Cấu trúc Min-Heap mặc định của Java
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Sử dụng Collections.reverseOrder() để đảo ngược bộ so sánh, tạo thành Max-Heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        List<Double> medians = new ArrayList<>();
        
        for (int num : a) {
            // Bước 1: Thêm phần tử mới vào Max-Heap (nửa dưới)
            maxHeap.offer(num);
            
            // Bước 2: Đẩy phần tử lớn nhất của nửa dưới sang Min-Heap (nửa trên)
            // Đảm bảo tính chất: mọi phần tử trong maxHeap luôn <= mọi phần tử trong minHeap
            minHeap.offer(maxHeap.poll());
            
            // Bước 3: Cân bằng kích thước
            // Quy ước: Nếu tổng số phần tử lẻ, maxHeap sẽ chứa phần tử dư ra
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
            
            // Bước 4: Trích xuất trung vị
            if (maxHeap.size() > minHeap.size()) {
                medians.add((double) maxHeap.peek());
            } else {
                // Chia cho 2.0 để ép kiểu kết quả sang số thực (double)
                medians.add((maxHeap.peek() + minHeap.peek()) / 2.0);
            }
        }
        
        return medians;
    }
}