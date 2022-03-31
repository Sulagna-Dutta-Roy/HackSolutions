class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode],c=0) -> Optional[ListNode]:
        val = l1.val + l2.val + c
        c = val // 10
        res = ListNode(val % 10)
        if (l1.next != None or l2.next != None or c!= 0):
            if l1.next == None:
                l1.next = ListNode(0)
            if l2.next == None:
                l2.next = ListNode(0)
            res.next = self.addTwoNumbers(l1.next,l2.next,c)
        return res
        