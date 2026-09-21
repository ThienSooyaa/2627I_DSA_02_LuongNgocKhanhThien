package Week3.InClass;
//Sử dụng ngăn xếp để cài đặt bài toán biến đổi biểu
//thức toán học với các phép toán +, - , *, / từ dạng trung tố sang dạng hậu tố (Biểu thức Ba Lan ngược)

/*
 * QUY TẮC CHUYỂN INFIX SANG POSTFIX (Duyệt từ Trái -> Phải)
 * Độ ưu tiên toán tử: (*, /) = 2  >  (+, -) = 1  >  '(' trong Stack = 0
 *
 * 1. Toán hạng (Số/Biến) : Đưa thẳng ra Output.
 * 2. Dấu mở ngoặc '('    : Push vào Stack.
 * 3. Toán tử (+, -, *, /): Pop từ Stack ra Output khi Độ_Ưu_Tiên(Đỉnh) >= Độ_Ưu_Tiên(Hiện_Tại).
 *                          Sau đó Push toán tử hiện tại vào Stack.
 * 4. Dấu đóng ngoặc ')'  : Pop từ Stack ra Output cho đến khi gặp '(', rồi Pop bỏ '('.
 * 5. Kết thúc chuỗi      : Pop tất cả toán tử còn lại trong Stack ra Output.
 */

import java.util.Stack;

public class w3_tailop_25020404 {

    // Hàm trả về độ ưu tiên của toán tử
    private static int priority(char c) {
        if (c == '+' || c == '-') return 1;
        if (c == '*' || c == '/') return 2;
        return 0; // Dấu '(' có độ ưu tiên bằng 0 khi nằm trong Stack
    }

    public static String postFix(String str) {
        // Dùng Stack<Character> để xử lý ký tự c tiết kiệm bộ nhớ và dễ so sánh
        Stack<Character> stack = new Stack<>();
        StringBuffer result = new StringBuffer();
        int n = str.length();

        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);

            // Bỏ qua khoảng trắng nếu có
            if (Character.isWhitespace(c)) {
                continue;
            }

            // 1. Toán hạng (chữ cái hoặc chữ số, xử lý cả số nhiều chữ số)
            if (Character.isLetterOrDigit(c)) {
                while (i < n && Character.isLetterOrDigit(str.charAt(i))) {
                    result.append(str.charAt(i));
                    i++;
                }
                result.append(" "); // Thêm khoảng trắng phân cách các toán hạng
                i--; // Lùi i lại 1 đơn vị vì vòng lặp for sẽ tự ++i
            }
            // 2. Dấu mở ngoặc '(' -> Push vào Stack
            else if (c == '(') {
                stack.push(c);
            }
            // 3. Dấu đóng ngoặc ')' -> Pop ra cho đến khi gặp '('
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop()).append(" ");
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop(); // Bỏ dấu '(' ra khỏi stack
                }
            }
            // 4. Toán tử (+, -, *, /)
            else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
                    result.append(stack.pop()).append(" ");
                }
                stack.push(c);
            }
        }

        // 5. Kết thúc chuỗi: Pop tất cả toán tử còn lại trong Stack
        while (!stack.isEmpty()) {
            result.append(stack.pop()).append(" ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        String infix = "20 - (5 + 2) * 1 * 3 - 2 * (3 + 1)";
        System.out.println("Trung tố (Infix) : " + infix);
        System.out.println("Hậu tố (Postfix) : " + postFix(infix));
    }
}