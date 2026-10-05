# Counting sort in Python programming


def countingSort(array):
    size = len(array)
    output = [0] * size

    # Initialize count array
    count = [0] * (max(array) + 1)

    # Store the count of each elements in count array
    for i in range(0, size):
        count[array[i]] += 1
    print("tần suất(đếm từ 0 đến max):")
    print(*count)
    # Store the cummulative count
    for i in range(1, (max(array) + 1)):
        count[i] += count[i - 1]
    print("tích lũy:")
    print(*count)
    print("các bước:")
    # Find the index of each element of the original array in count array
    # place the elements in output array
    i = size - 1
    while i >= 0:
        output[count[array[i]] - 1] = array[i]
        count[array[i]] -= 1
        i -= 1
        print(*output)

    # Copy the sorted elements into original array
    for i in range(0, size):
        array[i] = output[i]

if __name__=="__main__":
    data = list(map(int,input().split()))
    countingSort(data)
    print("Sorted Array in Ascending Order: ")
    print(data)