def balancedSums(arr):
    # Write your code here
    right = sum(arr)
    left = 0
    for num in arr:
        right -= num
        if left == right:
            return 'YES'
        left += num
        
    return 'NO'