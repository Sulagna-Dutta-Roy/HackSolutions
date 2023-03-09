/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode low = head;
        ListNode high = head;
        while (high != null && high.next != null) {
            low = low.next;
            high = high.next.next;
            if (low == high) {
                break;
            }
        }
        if (high == null || high.next == null) {
            return null;
        }
        ListNode a = head;
        ListNode b = low;
        while (a != b) {
            a = a.next;
            b = b.next;
        }
        return a;
    }
}



