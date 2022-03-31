class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
        
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        head = ListNode()
        last = head
        
        while list1 != None and list2 != None:
            if list1.val <= list2.val:
                last.next = list1
                list1 = list1.next
            else:
                last.next = list2
                list2 = list2.next
            last = last.next
            
        if list1 != None:
            last.next = list1
        if list2 != None:
            last.next = list2
        
        return head.next