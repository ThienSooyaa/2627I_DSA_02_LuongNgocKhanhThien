package Week3.Homework.ClientOfAlgorithm;
import java.util.Scanner;

import static Week3.Homework.Algorithm.Parentheses.isBalanced;

public class ParenthesesClient {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of test case: ");
        int t = scanner.nextInt();
        scanner.nextLine(); // bỏ ký tự Enter còn lại

        for (int i = 0; i < t; i++) {
            System.out.print("Test case #" + (i + 1) + ": ");
            String s = scanner.nextLine().replace(" ", "");
            boolean result = isBalanced(s);
            System.out.println(result);
        }

        scanner.close();
    }
}
