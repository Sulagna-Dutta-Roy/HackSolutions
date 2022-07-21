Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
       self.val = val
        self.next = next
class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        values = []                        
        nodes = []                         
        counter = 0
        curr = head
        while curr:
            counter += 1
            if counter >= left and counter <= right:
                values.append(curr.val)    
                nodes.append(curr)         
            curr = curr.next
        for node in nodes:
            node.val = values.pop(-1)       
        return head
