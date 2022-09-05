
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children

class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        result = []
        
        if root is None:
            return result
        
        queue = collections.deque()
        queue.append(root)
        
        while queue:
            length = len(queue)
            levelNodes = [] 
            
            for i in range(length):
                dequeuedItem = queue.popleft()
                
                levelNodes.append(dequeuedItem.val) 
                
                for child in dequeuedItem.children:  
                    queue.append(child)
            
            result.append(levelNodes) 

        return result
