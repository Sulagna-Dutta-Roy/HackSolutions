# Definition for singly-linked list
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        element1, element2 = head, head
        while element2 and element2.next:
            element1 = element1.next
            element2 = element2.next.next
            if element1 == element2:
                return True
        return False
        