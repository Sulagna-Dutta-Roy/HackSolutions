from heapq import heapify, heappop, heappush

class HeapBuilding:
    def __init__(self, left_edge: int, right_edge: int, height: int) -> None:
        self.left = left_edge
        self.right = right_edge
        self.height = height
    
    # guarantees that buildings will be sorted as follows in a heap:
    #     1. rightmost right-edge buildings go first
    #     2. in the case of a tie, highest buildings go first
    #     3. in the case of a tie, leftmost left-edge buildings go first
    def __lt__(self, other: 'HeapBuilding') -> bool:
        return self._key() < other._key()
    
    def _key(self) -> tuple[int, int, int]:
        return (-self.right, -self.height, self.left)


class Solution:
    def getSkyline(self, buildings: list[list[int]]) -> list[list[int]]:
        # Collect buildings into a heap
        heap = [HeapBuilding(l, r, h) for [l, r, h] in buildings]
        heapify(heap)
        
        # intialization
        ref = heappop(heap)
        skyline = [[ref.right, 0]]
        
        while heap:
            check = heappop(heap)
            
            # Gap between buildings
            if check.right < ref.left:
                skyline.append([ref.left, ref.height])
                skyline.append([check.right, 0])
                ref = check
            
            # Overlap/seam of same height
            elif check.height == ref.height:
                ref.left = min(ref.left, check.left)
            
            # Seam of different height
            elif check.right == ref.left:
                skyline.append([ref.left, ref.height])
                ref = check
            
            # Overlap of higher height
            elif check.height > ref.height:
                skyline.append([check.right, ref.height])
                if ref.left < check.left:
                    ref.right = check.left
                    heappush(heap, ref)
                ref = check
            
            # Overlap of lower height, jutting leftwards
            elif check.left < ref.left:
                check.right = ref.left
                heappush(heap, check)
        
        # Final addition, then reverse the order of skyline appends
        skyline.append([ref.left, ref.height])
        return list(reversed(skyline))
