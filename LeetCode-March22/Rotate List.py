# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if head == None:return
            values = []
            dummy = ListNode()
            cur = dummy
            while head:
                values.append(head.val)
                head = head.next
            for i in range(k % len(values)):
                values.insert(0, values.pop())
            for j in values:
                cur.next = ListNode(j)
                cur = cur.next
            return dummy.next