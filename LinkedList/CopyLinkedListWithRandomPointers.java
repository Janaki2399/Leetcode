A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.
 
Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
Example 2:


Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]
Example 3:



Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]
Example 4:

Input: head = []
Output: []
Explanation: Given linked list is empty (null pointer), so return null.

Solution With Hash Map: Time Complexity-O(n), Space Complexity -O(n) 

class Solution {
    public Node copyRandomList(Node head) {
       HashMap<Node,Node> hm=new HashMap<Node,Node>();
    
         Node node = head;
        while(node!=null)
        {
             hm.put(node,new Node(node.val));
            node=node.next;
        }
        node =head;
        while(node!=null)
        {
            Node n=hm.get(node);
            n.next=hm.get(node.next);
            n.random=hm.get(node.random);
            node=node.next;
        }
        return hm.get(head);
    }
}

Efficient Solution Without Hash Map:Time Complexity-O(n), Space Complexity -O(1)

class Solution {
    public Node copyRandomList(Node head) {
        Node node=head;
        Node next=head;
        while(node !=null)
        {
            next=node.next;
            Node copy=new Node(node.val);
            node.next=copy;
            copy.next=next;
            node=next;
        }
        
        node=head;
        while(node !=null)
        {
            if(node.random!=null)
            {
                node.next.random=node.random.next;
            }
            node=node.next.next;
        }
        node=head;
        next=head;
        Node copy=head;
        Node pseudo=new Node(0);
        Node iter=pseudo;
        while(node !=null)
        {
            next=node.next.next;
            copy=node.next;
            iter.next=copy;
            iter=copy;
            node.next=next;
            node=next;
        }
        return pseudo.next;
    }
}
