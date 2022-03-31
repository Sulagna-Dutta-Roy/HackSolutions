class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        stack=[]
        indexes_to_remove = set()
        res = ''
        for i, c in enumerate(s):
            if c not in '()':
                continue
            if c == '(':
                stack.append(i)
            elif not stack:
                indexes_to_remove.add(i)
            else:
                stack.pop()
        indexes_to_remove = indexes_to_remove.union(set(stack))
        for i, c in enumerate(s):
            if i not in indexes_to_remove:
                res+=c
        return res