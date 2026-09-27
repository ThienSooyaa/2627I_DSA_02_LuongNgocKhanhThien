/*
1.3.4 Viết một chương trình client Parentheses với nhiệm vụ đọc một chuỗi text từ input chuẩn

và dùng một cấu trúc ngăn xếp (stack) để xác định xem các dấu ngoặc có cân hay không.

Ví dụ chương trình phải in true cho [()]{}{[()()]()} và false cho [(]).
*/


package Week3.Homework.Algorithm;

import java.util.Stack;
public class Parentheses {
    public static boolean checkForParentheses(char outStack, char inStack) {
        if (inStack == '{' && outStack == '}') {
            return true;
        } else if (inStack == '[' && outStack == ']') {
            return true;
        } else if (inStack == '(' && outStack == ')') {
            return true;
        }

        return false;
    }

    public static boolean isBalanced(String s){
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !Parentheses.checkForParentheses(c, stack.pop())) {
                    return false;
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }
    }

