def pairs(k, arr):
    # Write your code here
    mapping=set(arr)
    count=0
    for num in arr:
        if num+k in mapping:
            count+=1
    return count