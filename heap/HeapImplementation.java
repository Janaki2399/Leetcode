// Java program to implement Max Heap 
public class HeapImplementation{ 
    private int[] Heap; 
    private int size; 
    private int maxsize; 
  
    // Constructor to initialize an 
    // empty max heap with given maximum 
    // capacity. 
    public HeapImplementation(int maxsize) 
    { 
        this.maxsize = maxsize; 
        this.size = 0; 
        Heap = new int[this.maxsize + 1]; 
        Heap[0] = Integer.MAX_VALUE; 
    } 
  

  
    private void swap(int fpos, int spos) 
    { 
        int tmp; 
        tmp = Heap[fpos]; 
        Heap[fpos] = Heap[spos]; 
        Heap[spos] = tmp; 
    } 
  
    // A recursive function to max heapify the given 
    // subtree. This function assumes that the left and 
    // right subtrees are already heapified, we only need 
    // to fix the root. 
    private void maxHeapify(int i) 
    { 
       int largest=i;
	
     int left = 2*i ;                  //left child
        int right = 2*i +1 ;       //right child
        if(left<=size && Heap[left] > Heap[i] )
              largest = left;
        if(right <= size && Heap[right] > Heap[largest] )
            largest = right;
        if(largest != i )
        {
            swap (i , largest);
            maxHeapify (largest);
        } 
    } 
  
    // Inserts a new element to max heap 
    public void insert(int element) 
    { 
        Heap[++size] = element; 
  
        // Traverse up and fix violated property 
        int current = size; 
        while (Heap[current] > Heap[(current/2)]) { 
            swap(current, current/2); 
            current = current/2; 
        } 
    } 
  
    public void print() 
    { 
        for (int i = 1; i <= size / 2; i++) { 
            System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + 
                      Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]); 
            System.out.println(); 
        } 
    } 
  
    // Remove an element from max heap 
    public int extractMax() 
    { 
        int popped = Heap[1]; 
        Heap[1] = Heap[size--]; 
        maxHeapify(1); 
        return popped; 
    } 
  
    public static void main(String[] arg) 
    { 
        System.out.println("The Max Heap is "); 
        HeapImplementation maxHeap = new HeapImplementation(15); 
        maxHeap.insert(5); 
        maxHeap.insert(3); 
        maxHeap.insert(17); 
        maxHeap.insert(10); 
        maxHeap.insert(84); 
        maxHeap.insert(19); 
        maxHeap.insert(6); 
        maxHeap.insert(22); 
        maxHeap.insert(9); 
  
        maxHeap.print(); 
        System.out.println("The max val is " + maxHeap.extractMax()); 
	  System.out.println("The max val is " + maxHeap.extractMax());
    } 
}
