# Definition for a binary tree node.
class TreeNode:
  def __init__(self, val=0, left=None, right=None):
      self.val = val
      self.left = left
      self.right = right
class Solution:
    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        ans = []
        def dfs(root,r,c):
            if root:
                ans.append([r,c,root.val])
                dfs(root.left,r+1,c-1)
                dfs(root.right,r+1,c+1)
            return
        dfs(root,0,0)
        ans=sorted(ans,key=lambda x:(x[1],x[0],x[2]))
        d=defaultdict(list)
        for i,j,k in ans:
            d[j].append(k)
        l=[]
        for i in d.values():
            l.append(i)
        return l
