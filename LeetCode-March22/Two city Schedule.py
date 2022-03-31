class Solution:
    def twoCitySchedCost(self, costs: List[List[int]]) -> int:
        diff = []
        for c1,c2 in costs:
            diff.append([c2-c1,c1,c2])
        diff.sort()
        res = 0
        for i in range(len(diff)):
            if i < len(diff)//2:
                res += diff[i][2]
            else:
                res += diff[i][1]
        return res
        