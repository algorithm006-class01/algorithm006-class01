package G20200343030375;

import java.util.LinkedList;

class LeetCode_641_375 {
    private int size;
    private int length;
    private Node header;
    private Node end;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public LeetCode_641_375(int k) {
        this.size =k;
        LinkedList linkedList = new LinkedList();

    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(size>length){

            Node node = new Node(value);
            if(header == null){
                this.init(node);
            }else {
                node.next = header;
                header.pr = node;
                header = node;
            }
            length++;
            return true;
        }else{
            return false;
        }

    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(!isFull()){
            Node node = new Node(value);
            if(end == null){
                this.init(node);
            }else {
                node.pr = end;
                end.next = node;
                end=node;
            }
            length++;
            return true;
        }else{
            return false;
        }
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(length>1&&length!=1){
            header =  header.next;
            header.pr = null;
            length--;
            return true;
        } else if(length == 1){
            header=null;
            end =null;
            length--;
            return true;
        }
         return false;


    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(length>0&&length!=1){
            end = end.pr;
            end.next = null;

            length--;
            return true;
        }else   if(length == 1){
            header = null;
            end = null;
            length--;
            return true;
        }
        return false;

    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        int result = header.value;
        return result;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty()){
            return -1;
        }
        int result = end.value;
        return result;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if(length>0){
            return false;
        }
        return true;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        if(size >length  ){
            return false;
        }else {
            return true;
        }
    }
    private void init(Node node){
        header = node;
        end = node;
    }

    private class Node {
        Node next;
        Node pr;
        int value ;
        public  Node(int value){
            this.value = value;
        }
    }

}
