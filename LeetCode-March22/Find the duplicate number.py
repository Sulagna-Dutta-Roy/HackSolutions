class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        turtle = hare = nums[0]
        turtle = nums[turtle]
        hare = nums[nums[hare]]
        
        while turtle != hare:
            turtle = nums[turtle]
            hare = nums[nums[hare]]
            
        turtle = nums[0]
        while turtle != hare:
            turtle = nums[turtle]
            hare = nums[hare]
            
        return turtle