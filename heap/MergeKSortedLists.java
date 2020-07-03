/*Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6*/

Solution:

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
    PriorityQueue<ListNode> q=new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
    
    for(ListNode node:lists)
    {
        if(node!=null)
        {
            q.add(node);
        }
    }
        
    ListNode dummy=new ListNode(0);
    ListNode head=dummy;
        while(!q.isEmpty())
        {
            ListNode n=q.poll();
            head.next=n;
            head=head.next;
            if(n.next!=null)
            {
                q.add(n.next);
            }
        }
        return dummy.next;
    }
}
