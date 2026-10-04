"""TASK 7

Tóm tắt: Cho danh sách các số nguyên. In ra (lần lượt) số lần xuất hiện của các số từ 0 tới 99.
Gợi ý: Không cần sắp xếp, chỉ cần đếm."""

def countingSort1(arr):
    frequency=[0]*(max(arr)+1)
    for i in arr:
        frequency[i]+=1
    return frequency

if __name__=='__main__':
    arr=list(map(int, input().split()))
    result=countingSort1(arr)
    print(*result)
