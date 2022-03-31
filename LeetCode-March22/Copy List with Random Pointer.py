# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return None 
        check={}
        
        cur = head 
        while(cur):
            node = Node(cur.val, None, None)
            check[cur] = node
            cur = cur.next
            
        cur = head
        while(cur):
            if cur.next is not None:
                check[cur].next = check[cur.next]
            if cur.random is not None:
                check[cur].random = check[cur.random]
            cur = cur.next
            
        return check[head]