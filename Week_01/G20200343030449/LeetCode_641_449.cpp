class DoubleListNode {
public:
    DoubleListNode() {val=0,next=nullptr,pre=nullptr;}
    DoubleListNode(int _val):val(_val) {next=nullptr,pre=nullptr;}
    ~DoubleListNode() {}
    int val;
    DoubleListNode* next;
    DoubleListNode* pre;
};

class MyCircularDeque {
public:
    /** Initialize your data structure here. Set the size of the deque to be k. */
    MyCircularDeque(int k) {
        capacity = k;
        size = 0;
        head = new DoubleListNode();
        tail = new DoubleListNode();
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    bool insertFront(int value) {
        if (size == capacity) {
            return false;
        }

        size++;

        DoubleListNode* oldFirst = head->next;
        DoubleListNode* newNode = new DoubleListNode(value);

        if (oldFirst==nullptr) {
            head->next = newNode;
            newNode->pre = head;
            newNode->next = tail;
            tail->pre = newNode;
        }
        else {
            head->next = newNode;
            newNode->pre = head;
            newNode->next = oldFirst;
            oldFirst->pre = newNode;            
        }

        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    bool insertLast(int value) {
        if (size == capacity) {
            return false;
        }

        size++;

        DoubleListNode* oldLast = tail->pre;
        DoubleListNode* newNode = new DoubleListNode(value);

        if (oldLast==nullptr) {
            head->next = newNode;
            newNode->pre = head;
            newNode->next = tail;
            tail->pre = newNode;
        }
        else {
            oldLast->next = newNode;
            newNode->pre = oldLast;
            newNode->next = tail;
            tail->pre = newNode;            
        }

        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    bool deleteFront() {
        if (size==0) {
            return false;
        }

        size--;

        DoubleListNode* node = head->next;

        head->next = node->next;
        node->next->pre=head;

        delete node;

        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    bool deleteLast() {
        if (size==0) {
            return false;
        }

        size--;

        DoubleListNode* node = tail->pre;

        node->pre->next = tail;
        tail->pre = node->pre;

        delete node;

        return true;
    }
    
    /** Get the front item from the deque. */
    int getFront() {
        return size==0?-1:head->next->val;
    }
    
    /** Get the last item from the deque. */
    int getRear() {
        return size==0?-1:tail->pre->val;
    }
    
    /** Checks whether the circular deque is empty or not. */
    bool isEmpty() {
        return size==0?true:false;
    }
    
    /** Checks whether the circular deque is full or not. */
    bool isFull() {
        return size==capacity?true:false;
    }
private:
    unsigned int capacity;
    unsigned int size;
    DoubleListNode* head;
    DoubleListNode* tail;
};

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque* obj = new MyCircularDeque(k);
 * bool param_1 = obj->insertFront(value);
 * bool param_2 = obj->insertLast(value);
 * bool param_3 = obj->deleteFront();
 * bool param_4 = obj->deleteLast();
 * int param_5 = obj->getFront();
 * int param_6 = obj->getRear();
 * bool param_7 = obj->isEmpty();
 * bool param_8 = obj->isFull();
 */
