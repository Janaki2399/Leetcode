/*Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?*/

SOlution:
By recursion:
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode res = new ListNode(0);
        res.next = head;
     dfs(res, n);
        return res.next;
    }
    
    private int dfs(ListNode head, int target) {
        if(head == null)    return 0;
        int count = dfs(head.next,  target) + 1;
		// say 1 -> 2 -> 3 -> 4  and target is 2
		// then we shall remove it when we are at node 2, which's index is (target + 1)
        if(count == target + 1) {
            head.next= head.next.next;
         //   head.next = nxt;
        }
     return count;
    }
}

Efficient SOlution:
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode dummy=new ListNode(0);
        dummy.next=head;
        
        ListNode second=dummy;
        ListNode first=dummy;
        
        for(int i=0;i<=n;i++)
        {
            first=first.next;
            
        }
        
        while(first!=null)
        {
            first=first.next;
            second=second.next;
        }
        second.next=second.next.next;
        
        return dummy.next;
    }
}
