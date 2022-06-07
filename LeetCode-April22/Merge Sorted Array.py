class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        tmp_nums1 = nums1[:m]    
        p1 = 0
        p2 = 0   
        for p in range(n + m):
            if p2 >= n or (p1 < m and tmp_nums1[p1] <= nums2[p2]):
                nums1[p] = tmp_nums1[p1] 
                p1 += 1
            else:
                nums1[p] = nums2[p2]
                p2 += 1