package Week4.InClass;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
h-index (Chỉ số h) là thước đo đánh giá năng suất công bố khoa học và mức độ ảnh hưởng t
hông qua số lần trích dẫn của một nhà nghiên cứu. Một người có chỉ số h-index bằng h khi họ có h bài báo khoa học,
và mỗi bài báo đó được trích dẫn ít nhất h lần.Ví dụ: Nếu một nhà nghiên cứu có h-index = 12, điều đó có nghĩa là họ
đã xuất bản 12 bài báo, và mỗi bài trong số 12 bài đó nhận được ít nhất 12 lượt trích dẫn từ các công trình khác./
Hãy viết chương trình tính chỉ số h của một nhà nghiên cứu.
Input:
-Dòng đầu ghi số N là số bài báo đã công bố của nhà nghiên cứu
-Dòng thứ hai ghi số lượt trích dẫn của từng  bài báo của nhà nghiên cứu được ngăn cách nhau vởi dấu cách.
Output:
Chỉ số h-index
Ví dụ:
Input:
6
3 10 3 5 7 8
Output:
4
(Giải thích: Có 4 bài báo có số lượt trích dẫn lớn hơn 4  (10, 5, 7, 8) nên h-index =4)*/
public class W4_25020404 {

    public static int indexH(ArrayList<Integer> arr) {
        Collections.sort(arr);

        int count = 0;

        for (int i = arr.size() - 1; i >= 0; i--) {
            if (arr.get(i) >= count + 1) {
                count++;
            } else {
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arr.add(sc.nextInt());
        }

        System.out.println(indexH(arr));

        sc.close();
    }
}