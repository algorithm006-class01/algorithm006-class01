/**
 * 
 */

/**
 * @author huangwen05
 *
 * @date:   2020年2月16日 下午8:56:10 
 */
public class LeetCode_641_G20200343030505 {

    private int front;
    private int rear;
    private int capacity;
    private int[] arr;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        arr = new int[k + 1];
        capacity = k + 1;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()) return false;
        front = (front - 1 + capacity)%capacity;
        arr[front] = value;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()) return false;
        arr[rear] = value;
        rear = (rear + 1)%capacity;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()) return false;
        arr[front] = 0;
        front = (front + 1)%capacity;    
        return true;    
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()) return false;
        rear = (rear - 1 + capacity)%capacity;
        arr[rear] = 0;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty()) return -1;
        return arr[front];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty()) return -1;
        return arr[(rear - 1 + capacity)%capacity];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if(front == rear) return true;
        return false;        
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
       if((rear + 1)%capacity == front) {
           return true;
       } else {
           return false;
       }
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */