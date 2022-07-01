class Solution:
    def maximumUnits(self, boxTypes: List[List[int]], truckSize: int) -> int:
        boxTypes.sort(key=lambda box: box[1], reverse=True)    
        totalUnits = 0
        for numberOfBoxes, unitsPerBox in boxTypes:
            numBoxes = min(truckSize, numberOfBoxes)
            totalUnits += numBoxes * unitsPerBox
            truckSize -= numBoxes
        return totalUnits
