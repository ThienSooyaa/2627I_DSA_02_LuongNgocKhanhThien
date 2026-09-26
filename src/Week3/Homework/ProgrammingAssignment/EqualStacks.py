#https://www.hackerrank.com/challenges/equal-stacks/problem


def equalStacks(h1, h2, h3):
    sum1, sum2, sum3 = sum(h1), sum(h2), sum(h3)
    i1, i2, i3 = 0, 0, 0
    
    # Lặp cho đến khi một trong các mảng bị duyệt hết
    while i1 < len(h1) and i2 < len(h2) and i3 < len(h3):
        # Trường hợp cả 3 chiều cao đã bằng nhau
        if sum1 == sum2 == sum3:
            return sum1
            
        maxSum = max(sum1, sum2, sum3)
        
        # Chồng nào đang có tổng bằng maxSum thì pop (dịch con trỏ i)
        if sum1 == maxSum:
            sum1 -= h1[i1]
            i1 += 1
        elif sum2 == maxSum:
            sum2 -= h2[i2]
            i2 += 1
        elif sum3 == maxSum:
            sum3 -= h3[i3]
            i3 += 1
            
    return 0


if __name__ == '__main__':
    # Nhập số lượng phần tử của 3 mảng (ví dụ: 5 3 4)
    first_multiple_input = input("Nhập số lượng phần tử n1 n2 n3: ").rstrip().split()

    n1 = int(first_multiple_input[0])
    n2 = int(first_multiple_input[1])
    n3 = int(first_multiple_input[2])

    # Nhập danh sách các phần tử cho từng mảng
    h1 = list(map(int, input("Nhập mảng h1: ").rstrip().split()))
    h2 = list(map(int, input("Nhập mảng h2: ").rstrip().split()))
    h3 = list(map(int, input("Nhập mảng h3: ").rstrip().split()))

    result = equalStacks(h1, h2, h3)

    print("Chiều cao bằng nhau lớn nhất là:", result)