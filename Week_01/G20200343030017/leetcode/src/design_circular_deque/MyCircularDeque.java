package design_circular_deque;

import java.util.Arrays;

public class MyCircularDeque {
    int[] deque;
    int k;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.deque=new int[k];
        this.k = k;
        for (int n=0;n<deque.length;n++){
            deque[n]=-1;
        }
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isEmpty()){
            deque[0] = value;
        }else if(isFull()){
            /*int[] temp=new int[k+1];
            System.arraycopy(deque,0,temp,1,k);
            temp[0] = value;
            deque = temp;
            k = k+1;*/
            return false;
        }else{
            for (int a=1;a<deque.length;a++){
                deque[deque.length-a]=deque[deque.length-a-1];
            }
            deque[0]=value;
        }
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isEmpty()){
            deque[0] = value;
        }else if(isFull()){
            /*int[] temp = new int[k+1];
            System.arraycopy(deque,0,temp,0,k);
            temp[k] = value;
            deque = temp;
            k = k+1;*/
            return false;
        }else{
            for (int a=0;a<deque.length;a++){
               if (deque[a]==-1){
                   deque[a] = value;
                   break;
               }
            }
        }
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()){
            return false;
        }
        int count = 0;
        boolean flag = true;
        for (int a=0;a<deque.length-1;a++){
            if (deque[a]==-1 && flag){
                count = a;
                flag = false;
            }
            deque[a]=deque[a+1];
        }
        if (!flag&&count!=0){
            deque[count-1]=-1;
        }else{
            deque[k-1]=-1;
        }
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()){
            return false;
        }
        for (int a=0;a<deque.length;a++){
            if (deque[a]==-1){
                deque[a-1]=-1;
                return true;
            }
        }
        deque[k-1]=-1;
        return true;
    }
    // [9,7,3,0,0]
    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()){
            return -1;
        }
        return deque[0];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()){
            return -1;
        }
        for (int a=0;a<deque.length;a++){
            if (deque[a]==-1){
                return deque[a-1];
            }
        }
        return deque[deque.length-1];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        for (int a=0;a<deque.length;a++){
            if (deque[a]!=-1){
                return false;
            }
        }
        return true;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        for (int a=0;a<deque.length;a++){
            if (deque[a]==-1){
                return false;
            }
        }
        return true;
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
    public static void main(String[] args) {
        MyCircularDeque obj = new MyCircularDeque(3);
        System.out.println(obj.insertFront(8));
        System.out.println(obj.insertLast(8));
        System.out.println(obj.insertLast(2));
        System.out.println(obj.getFront());
        System.out.println(obj.deleteLast());
        System.out.println(obj.getRear());
        System.out.println(obj.insertFront(9));//9,8,8
        System.out.println("111:"+Arrays.toString(obj.deque));
        System.out.println(obj.deleteFront());
        System.out.println("222:"+Arrays.toString(obj.deque));
        System.out.println(obj.getRear());
        System.out.println(obj.insertLast(2));
        System.out.println(Arrays.toString(obj.deque));
        System.out.println(obj.isFull());
        System.out.println(Arrays.toString(obj.deque));
    }
}