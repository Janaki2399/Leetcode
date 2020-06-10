Sorting using temporary stack:

public static Stack<Integer> sortstack(Stack<Integer>  
                                             input) 
    { 
        Stack<Integer> tmpStack = new Stack<Integer>(); 
        while(!input.isEmpty()) 
        { 
            // pop out the first element 
            int tmp = input.pop(); 
          
            // while temporary stack is not empty and 
            // top of stack is greater than temp 
            while(!tmpStack.isEmpty() && tmpStack.peek()  
                                                 > tmp) 
            { 
                // pop from temporary stack and  
                // push it to the input stack 
            input.push(tmpStack.pop()); 
            } 
              
            // push temp in tempory of stack 
            tmpStack.push(tmp); 
        } 
        return tmpStack; 
    } 


sorting using recursion:

 static void sortedInsert(Stack<Integer> s, int x) 
    { 
        // Base case: Either stack is empty or newly inserted 
        // item is greater than top (more than all existing) 
        if (s.isEmpty() || x > s.peek()) 
        { 
            s.push(x); 
            return; 
        } 
       
        // If top is greater, remove the top item and recur 
        int temp = s.pop(); 
        sortedInsert(s, x); 
       
        // Put back the top item removed earlier 
        s.push(temp); 
    } 
       
    // Method to sort stack 
    static void sortStack(Stack<Integer> s) 
    { 
        // If stack is not empty 
        if (!s.isEmpty()) 
        { 
            // Remove the top item 
            int x = s.pop(); 
       
            // Sort remaining stack 
            sortStack(s); 
       
            // Push the top item back in sorted stack 
            sortedInsert(s, x); 
        } 
    } 
