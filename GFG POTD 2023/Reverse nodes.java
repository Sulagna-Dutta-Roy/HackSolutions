

/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/
class Solution
{
    public static void rearrange(Node odd)
    {
        Node even = odd.next;
        Node temp = even;
        while(odd.next!=null && even.next!=null){
            odd.next = even.next;
            odd = even.next;

            even.next = odd.next;
            even = even.next;
        }
        Node curr = temp;
        Node prev = null;
        
        while(curr!=null){
            Node next = curr.next;
            
            curr.next = prev;
            
            prev = curr;
            curr = next;
        }
        odd.next = prev;
  }
}
