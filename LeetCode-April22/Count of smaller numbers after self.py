class Solution:
    def countSmaller(self, nums: List[int]) -> List[int]:
        nums_sorted = sorted(nums)
        count_smaller = [0] * len(nums)
        for i,num in enumerate(nums):
            pos = bisect_left(nums_sorted,num)
            count_smaller[i] = pos
            del nums_sorted[pos]
        return count_smaller
