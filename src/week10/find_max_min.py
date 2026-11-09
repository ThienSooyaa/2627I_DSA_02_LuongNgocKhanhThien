def find_max_min(A, left, right):
    if left == right:
        return A[left], A[left]

    mid = (left + right) // 2

    max1, min1 = find_max_min(A, left, mid)
    max2, min2 = find_max_min(A, mid + 1, right)

    maximum = max(max1, max2)
    minimum = min(min1, min2)

    return maximum, minimum