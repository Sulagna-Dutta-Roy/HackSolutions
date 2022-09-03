# Definition for a binary tree node.
 class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right
class Solution:
    def averageOfLevels(self, root: Optional[TreeNode]) -> List[float]:
        bfs = lambda st: [(sum(x.val for x in st)/len(st))] + bfs([x for r in st for x in filter(None,(r.left,r.right))]) if st else []
        return bfs([root])  
