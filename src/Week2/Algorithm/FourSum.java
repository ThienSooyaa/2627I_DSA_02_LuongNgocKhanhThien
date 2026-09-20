package Week2.Algorithm;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
// thuật toán của em sẽ là O(N^3) với kĩ thuật 2 Pointer dùng với mảng đã được sắp xếp tăng dần


public class FourSum {
    public static int fourSum(int[] arr){
        int count=0;
        Arrays.sort(arr);
        int n=arr.length;
        for (int i=0;i<n-3;i++){
            for (int j=i+1;j<n-2;j++){
                int left= j+1;
                int right= n-1;
                while(left<right){
                long tong=(long) arr[i]+arr[j]+arr[left]+arr[right];
                    if (tong==0){
                    if(arr[left]==arr[right]){
                        int countElements = right - left + 1;
                        count += (countElements * (countElements - 1)) / 2; // Cặp C(k, 2)
                        break;
                    }
                        // Đếm số lượng phần tử trùng lặp ở 2 đầu con trỏ
                        int leftVal = arr[left], rightVal = arr[right];
                        int leftCount = 0, rightCount = 0;

                        while (left <= right && arr[left] == leftVal) {
                            leftCount++;
                            left++;
                        }
                        while (right >= left && arr[right] == rightVal) {
                            rightCount++;
                            right--;
                        }

                        count += leftCount * rightCount;
                }
                else if (tong<0){
                    left++;
                }
                else if (tong>0){
                    right--;
                }
                }
            }
        }
        return count;
    }
}
