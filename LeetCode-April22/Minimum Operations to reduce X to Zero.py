class Solution:
    def minOperations(self, nums: List[int], x: int) -> int:
        arr_sum = sum(nums)
        if arr_sum < x:
            return -1
        if arr_sum == x:
            return len(nums)
        
        arr_remain = arr_sum - x
        left = curr_sum = max_arr_remain_size = 0
        for right, num in enumerate(nums):
            curr_sum += num
            while curr_sum > arr_remain:
                curr_sum -=nums[left]
                left+=1
                
            if curr_sum == arr_remain:
                max_arr_remain_size = max(max_arr_remain_size, right - left + 1)
                
        
        return len(nums) - max_arr_remain_size if max_arr_remain_size > 0 else -1