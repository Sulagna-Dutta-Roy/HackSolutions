class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        c = len(matrix)
        heap_a = []
        for i in range(len(matrix)): 
            heapq.heappush( heap_a, (matrix[i][0], matrix[i], 0) )
        
        heapq.heapify(heap_a)

        j = 0
        while j < k:
            ele, min_heap, pos = heapq.heappop(heap_a)
            
            if j == k-1:
                return ele
                      
            if pos < c-1:
                heapq.heappush( heap_a, (min_heap[pos+1], min_heap, pos+1) ) 
            j += 1
              
        return -1   
