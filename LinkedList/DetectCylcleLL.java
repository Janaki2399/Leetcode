/*Given a linked list, determine if it has a cycle in it.

To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.

 

Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the second node.*/

Solution:

public class Solution {
    public boolean hasCycle(ListNode head) {
        
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast!=null && fast.next!=null)
        {
             fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)
            {
                return true;
            }
           
        }
        return false;
    }
    
}

To detect and remove the loop:
Solution:
 void detectAndRemoveLoop(Node node) 
    { 
  
        // If list is empty or has only one node 
        // without loop 
        if (node == null || node.next == null) 
            return; 
  
        Node slow = node, fast = node; 
  
        // Move slow and fast 1 and 2 steps 
        // ahead respectively. 
        slow = slow.next; 
        fast = fast.next.next; 
  
        // Search for loop using slow and fast pointers 
        while (fast != null && fast.next != null) { 
            if (slow == fast) 
                break; 
  
            slow = slow.next; 
            fast = fast.next.next; 
        } 
  
        /* If loop exists */
        if (slow == fast) { 
            slow = node; 
            while (slow.next != fast.next) { 
                slow = slow.next; 
                fast = fast.next; 
            } 
  
            /* since fast->next is the looping point */
            fast.next = null; /* remove loop */
        } 
    } 
  

