package Week2.Algorithm;
/*1.4.15. Faster 3-sum. Để khởi động, hãy tìm thuật toán và cài TwoSumFaster sử dụng một thuật toán tuyến tính để đếm số cặp
 có tổng bằng 0 đối với mảng đã được sắp xếp (thay vì dùng tìm kiếm nhị phân như trong thuật toán NlogN). Sau đó áp dụng ý
 tưởng này để phát triển một thuật toán bậc hai cho bài tổng-3
*/

import java.util.Arrays;
//O(N^2)
public class FasterThreeSum {
    public static int fasterThreeSum(int[]arr){
        int count=0;
        Arrays.sort(arr);
        int n=arr.length;
        for(int i=0;i<n;i++){
            int left=i+1;
            int right=n-1;
            while(left<right){
                long sum=(long)arr[i]+arr[left]+arr[right];
                if(sum==0){
                    if(arr[left]==arr[right]){
                        int elementCount=right-left+1;
                        count+=elementCount*(elementCount-1)/2; // chọn 2 số trong bộ k số
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
                else if(sum<0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return count;
    }
}
