class Solution:
    def isPossible(self, nums: List[int]) -> bool:
        lookup = defaultdict(list)
        
        for num in nums: 
            if not lookup[num - 1]:
                heapq.heappush(lookup[num], 1)
            else:
                heapq.heappush(
                    lookup[num], 
                    heapq.heappop(lookup[num - 1]) + 1
                )
        
        for key, heap in lookup.items():
            if not heap:
                continue 
            if not all(x >= 3 for x in heap):
                return False
        return True
