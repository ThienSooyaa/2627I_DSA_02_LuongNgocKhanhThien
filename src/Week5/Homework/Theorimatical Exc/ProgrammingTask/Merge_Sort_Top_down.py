def merge(arr, left, mid, right):
    """
    Gộp hai mảng con đã sắp xếp: arr[left...mid] và arr[mid+1...right]
    """
    n1 = mid - left + 1
    n2 = right - mid
    
    # Tạo hai mảng tạm để chứa nửa trái (L) và nửa phải (R)
    L = [0] * n1
    R = [0] * n2
    
    # Copy dữ liệu vào mảng tạm
    for i in range(n1):
        L[i] = arr[left + i]
    for j in range(n2):
        R[j] = arr[mid + 1 + j]
        
    # Con trỏ duyệt mảng
    i = 0       # Con trỏ duyệt mảng L
    j = 0       # Con trỏ duyệt mảng R
    k = left    # Con trỏ ghi đè lên mảng gốc arr
    
    # So sánh và gộp
    while i < n1 and j < n2:
        if L[i] <= R[j]:
            arr[k] = L[i]
            i += 1
        else:
            arr[k] = R[j]
            j += 1
        k += 1
        
    # Nếu L còn thừa phần tử, đưa nốt vào mảng gốc
    while i < n1:
        arr[k] = L[i]
        i += 1
        k += 1
        
    # Nếu R còn thừa phần tử, đưa nốt vào mảng gốc
    while j < n2:
        arr[k] = R[j]
        j += 1
        k += 1
def merge_sort_top_down(arr, left, right):
    if left < right:
        # Sử dụng công thức này thay vì (left + right) // 2 
        # để phòng tránh lỗi tràn số (Integer Overflow) phổ biến trong các ngôn ngữ tĩnh (C++, Java).
        mid = left + (right - left) // 2
        
        # Đệ quy chia cắt nửa trái
        merge_sort_top_down(arr, left, mid)
        
        # Đệ quy chia cắt nửa phải
        merge_sort_top_down(arr, mid + 1, right)
        
        # Gộp hai nửa đã sắp xếp
        merge(arr, left, mid, right)

if __name__=='__main__':
    arr=list(map(int,input().split()))
    merge_sort_top_down(arr,0,len(arr)-1)
    print("Result: ",*arr)