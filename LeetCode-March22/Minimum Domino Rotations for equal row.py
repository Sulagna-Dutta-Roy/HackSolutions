class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        
        for target in [tops[0],bottoms[0]]:
            missT, missB = 0,0
            for i,pair in enumerate(zip(tops, bottoms)):
                top, bottom = pair
                if not (top == target or bottom == target):
                    break
                if top != target:
                    missT += 1
                if bottom != target:
                    missB += 1
                if i == len(tops) - 1:
                    return min(missT,missB)
        return -1