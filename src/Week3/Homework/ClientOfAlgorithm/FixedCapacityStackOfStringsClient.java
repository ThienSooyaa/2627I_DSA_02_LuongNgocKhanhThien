package Week3.Homework.ClientOfAlgorithm;

import Week3.Homework.Algorithm.FixedCapacityStackOfStrings;

public class FixedCapacityStackOfStringsClient {
    public static void main(String[] args) {
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(3);

        System.out.println("Stack isEmpty? " + stack.isEmpty()); // true
        System.out.println("Stack isFull? " + stack.isFull());   // false

        stack.push("Hello");
        stack.push("World");
        stack.push("UET");

        System.out.println("Size sau khi push 3 phần tử: " + stack.size()); // 3
        System.out.println("Stack isFull? " + stack.isFull());               // true

        // Thử pop một phần tử ra
        System.out.println("Pop ra: " + stack.pop());                        // UET
        System.out.println("Stack isFull sau khi pop? " + stack.isFull());   // false
    }
}

