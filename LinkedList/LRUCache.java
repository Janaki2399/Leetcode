/*Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?*/

Solution:
class Node{
         int key;
    int value;
        Node pre, next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.pre = null;
            this.next = null;
        }
    }
class LRUCache{
    HashMap<Integer, Node> map;
    Node head, tail;
    int capacity, count;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.map = new HashMap<>();
        this.head = null;
        this.tail = null;
    }
    public void deleteNode(Node node){
        if(node == head && node == tail){
            head = tail = null;
        }else if(node == head){
            head = head.next;
        }else if(node == tail){
            tail = node.pre;
            tail.next = null;
        }else{
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
    }
    public void addToHead(Node node){
        if(head == null && tail == null){
            head = tail = node;
            return ;
        }
        node.next = head;
        node.next.pre = node;
        node.pre = null;
        head = node;
    }
    public int get(int key) {
        if(map.get(key) == null) return -1;
        Node node = map.get(key);
        int res = node.value;
        deleteNode(node);
        addToHead(node);
        return res;
    }
    
    public void put(int key, int value) {
        if(map.get(key) != null){
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        }else{
            Node node = new Node(key, value);
            map.put(key, node);
            if(count < capacity){
                count ++;
                addToHead(node);
            }else{
                map.remove(tail.key);
                deleteNode(tail);
                addToHead(node);
            }
        }
    }
}
