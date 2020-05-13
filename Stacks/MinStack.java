/*Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2*/




class MinStack {
        
        Node top = null;
        
        public void push(int x) {
            if (top == null) {
                top = new Node(x);
                top.min = x;
            }
            else {
                Node temp = new Node(x);
                temp.next = top;
                top = temp;
                top.min = Math.min(top.next.min, x);
            }
            
            return;
        }
    
        public void pop() {
            top = top.next;
            return;
        }
    
        public int top() {
            return top == null ? 0 : top.val;
        }
    
        public int getMin() {
            return top == null ? 0 : top.min;
        }
    }
    
    class Node {
        int val;
        int min;
        Node next;
        
        public Node(int val) {
            this.val = val;
        }
    }
