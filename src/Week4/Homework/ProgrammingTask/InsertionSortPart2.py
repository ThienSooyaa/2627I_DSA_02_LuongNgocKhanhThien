#BÀI 5

def insertionSort2(n,arr):
    for j in range(1,n):
        e=arr[j]
        for i in range(j-1,-1,-1):
            if i == 0 and e < arr[i]:
                arr[i + 1] = arr[i]
                arr[i] = e
                break

            if e < arr[i]:
                arr[i + 1] = arr[i]

            elif e >= arr[i]:
                arr[i + 1] = e
                break
        print(*arr)

if __name__ == '__main__':
    n = int(input().strip())

    arr = list(map(int, input().rstrip().split()))
    print("the answer:")
    insertionSort2(n, arr)




    