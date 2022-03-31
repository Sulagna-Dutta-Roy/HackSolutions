class Solution:
    def brokenCalc(self, x: int, y: int) -> int:
        steps = 0
        while x != y:
            if y<x:
                steps += (x-y)
                x=y
            else:
                if y % 2 == 0:
                    y //=2
                else:
                    y += 1
                steps += 1
        return steps
                        