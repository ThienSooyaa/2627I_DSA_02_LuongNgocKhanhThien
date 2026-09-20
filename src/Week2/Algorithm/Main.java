package Week2.Algorithm;

import java.util.Scanner;

import static Week2.Algorithm.FourSum.fourSum;
import static Week2.Algorithm.SimilarElements.listSimilar;
import java.util.Arrays;
import java.util.List;

import static Week2.Algorithm.BinarySearch.findFirstIndex;
import static Week2.Algorithm.EqualPairs.countPairs;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of element of array(min=4): ");
        int n=sc.nextInt();
        if (n<4){System.out.println("!!! The number of elenments < 4 !!!!");}
        else {
            int[] arr = new int[n];
            System.out.println("Enter " + n + " numbers " + "(Each number is seperated by space or enter: ");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int result = fourSum(arr);
            System.out.println("The result is: " + result);
        }












        /* bài similar element

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the amount of numbers of array1: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter " + n + " number (Each number separated by a space and a new line :");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.print("Enter the amount of numbers of array2: ");
        int m = sc.nextInt();
        int[] b = new int[m];
        System.out.println("Enter " + m + " number (Each number separated by a space and a new line :");
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        List<Integer> result = listSimilar(a,b);
        System.out.println("Similar elements: "+result);*/











        /*bài fix binarySearch first index

        Tạo Scanner để đọc dữ liệu nhập từ bàn phím (Console)
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the amount of numbers of array: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter " + n + " number (Each number separated by a space and a new line :");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // Đóng Scanner sau khi nhập xong
        System.out.print("Enter the target number: ");
        int x=sc.nextInt();
        sc.close();

        // Gọi hàm tính toán và in kết quả
        long result = findFirstIndex(x,a);
        if(result==-1){
            System.out.println("Not Found");
        }
        else{
            System.out.println("The first index of the target number is: "+result);
        }*/
    }
}
