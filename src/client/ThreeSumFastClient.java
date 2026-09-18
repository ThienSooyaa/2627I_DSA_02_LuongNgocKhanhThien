package client; // Package riêng nằm trong src/client/

// Import class ThreeSumFast từ thư viện algs4.jar
import edu.princeton.cs.algs4.ThreeSumFast;

// Import các công cụ nhập/xuất và bấm giờ cũng từ algs4.jar
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class ThreeSumFastClient {

    public static void main(String[] args) {
        // 1. Đọc dữ liệu từ đường dẫn file truyền vào tham số dòng lệnh
        int[] a = In.readInts(args[0]);

        // 2. Bắt đầu bấm giờ
        Stopwatch stopwatch = new Stopwatch();

        // 3. Gọi hàm count() từ class ThreeSumFast trong thư viện algs4
        int count = ThreeSumFast.count(a);

        // 4. Lấy thời gian trôi qua
        double time = stopwatch.elapsedTime();

        // 5. In kết quả
        StdOut.println("Số lượng bộ ba có tổng bằng 0: " + count);
        StdOut.println("Thời gian thực thi: " + time + " giây");
    }
}