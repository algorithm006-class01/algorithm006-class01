/*
 * 641. Design Circular Deque
 * 设计循环双端队列
 */
public class LeetCode_641_569 {

	public static void main(String[] args) {
		
		MyCircularDeque circularDeque = new MyCircularDeque(8);
		circularDeque.insertFront(5);
		circularDeque.getFront();
		circularDeque.isEmpty();
		circularDeque.deleteFront();
		circularDeque.insertLast(3);
		circularDeque.getRear();
		circularDeque.insertLast(7);
		circularDeque.insertFront(7);
		circularDeque.deleteLast();
		circularDeque.insertLast(4);
		circularDeque.isEmpty();
		
		
		
		
		
		

		/*circularDeque.insertFront(1);
		circularDeque.insertLast(2);
		circularDeque.getFront();
		circularDeque.insertLast(3);
		circularDeque.getFront();
		circularDeque.insertFront(5);
		circularDeque.getRear();
		circularDeque.getFront();
		circularDeque.getFront();
		circularDeque.deleteLast();
		circularDeque.getRear();*/
		
		
		/* circularDeque.insertLast(1);			        // 返回 true
		 circularDeque.insertLast(2);			        // 返回 true
		 circularDeque.insertFront(3);			        // 返回 true
		 circularDeque.insertFront(4);			        // 已经满了，返回 false
		 circularDeque.getRear();  				// 返回 2
		 circularDeque.isFull();				        // 返回 true
		 circularDeque.deleteLast();			        // 返回 true
		 circularDeque.insertFront(4);			        // 返回 true
		 circularDeque.getFront();				// 返回 4
*/		
	}


}

class MyCircularDeque {

	class Node {
		Node prev;
		int value;
		Node next;

		Node( Node prev, int value, Node next) {
			this.prev = prev;
			this.value = value;
			this.next = next;
		}
	}
	
	int maxSize;
	int size;
	Node head;
	Node tail;		
	
    public MyCircularDeque(int k) {
        this.maxSize = k;
    }
    
    public boolean insertFront(int value) {
        if ( size == maxSize )
        	return false;
        Node n = new Node( null, value, head );
        if ( head == null )
        	tail = n;
        else
        	head.prev = n;
        head = n;
        size++;
        return true;
    }
    	    
    public boolean insertLast(int value) {
    	 if ( size == maxSize )
	        return false;
    	 Node n = new Node( tail, value, null );
    	 if ( tail == null )
    		 head = n;
    	 else
    		 tail.next = n;
    	 tail = n;
    	 size++;
		 return true;
    }
    
    public boolean deleteFront() {
    	if ( head == null )
    		return false;
    	Node n = head;
    	Node next = head.next;
    	n.next = null;    	
		head = next;
		if ( head != null )
			head.prev = null;
		else 
			tail = null;
		size--;		
    	return true;
    }
    
    public boolean deleteLast() {
        if ( tail == null )
        	return false;
        Node n = tail;
        Node prev = tail.prev;
        n.prev = null;
        tail = prev;
        if ( tail != null )
        	tail.next = null;
        else 
        	head = null;
        size--;
        return true;
    }
    
    public int getFront() {
        return (size==0) ? -1 : head.value;
    }
    
    public int getRear() {
        return (size==0) ? -1 : tail.value;
    }
    
    public boolean isEmpty() {
        return (size == 0);
    }
    
    public boolean isFull() {
    	return (size == maxSize);
    }
}