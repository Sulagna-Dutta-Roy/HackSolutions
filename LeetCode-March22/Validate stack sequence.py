class Solution:
    def validateStackSequences(self, pushed: List[int], popped: List[int]) -> bool:
        stack = []
        N= len(popped)
        i=0
        for p in pushed:
            stack.append(p)
            while stack and stack[-1] == popped[i]:
                i += 1
                stack.pop()
        return stack == []