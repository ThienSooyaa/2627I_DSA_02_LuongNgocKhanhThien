def insertionSort1(n, arr):
    e = arr[n - 1]

    for i in range(n - 2, -1, -1):

        if i == 0 and e < arr[i]:
            arr[i + 1] = arr[i]
            arr[i] = e
            print(*arr)
            break

        if e < arr[i]:
            arr[i + 1] = arr[i]
            print(*arr)

        elif e >= arr[i]:
            arr[i + 1] = e
            print(*arr)
            break


if __name__ == '__main__':
    n = int(input().strip())

    arr = list(map(int, input().rstrip().split()))
    print("the answer:")
    insertionSort1(n, arr)