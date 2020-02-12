/* https://leetcode-cn.com/problems/design-circular-deque
设计实现双端队列。你的实现需要支持以下操作：

 - MyCircularDeque(k)：构造函数,双端队列的大小为k。
 - insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 - insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 - deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 - deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 - getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 - getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 - isEmpty()：检查双端队列是否为空。
 - isFull()：检查双端队列是否满了。
*/

//代码思路参考了 https://leetcode-cn.com/problems/design-circular-deque/solution/shu-zu-shi-xian-de-xun-huan-shuang-duan-dui-lie-by/

typedef struct {
	int *arr;
	int head;
	int tail;
	int size;
    
} MyCircularDeque;

/** Initialize your data structure here. Set the size of the deque to be k. */
bool myCircularDequeIsFull(MyCircularDeque* obj);
bool myCircularDequeIsEmpty(MyCircularDeque* obj);
MyCircularDeque* myCircularDequeCreate(int k) {

	MyCircularDeque *obj = malloc(sizeof(MyCircularDeque) * (k+1));
	obj->arr = malloc(sizeof(int) * (k+1));
	obj->head = 0;
	obj->tail = 0;
	obj->size = k + 1;
	return obj;
    
}

/** Adds an item at the front of Deque. Return true if the operation is successful. */
bool myCircularDequeInsertFront(MyCircularDeque* obj, int value) {

	if ( myCircularDequeIsFull(obj)) return false;

	int pos = (obj->head+obj->size-1) % obj->size;
	obj->arr[pos] = value;
	obj->head = pos;
	return true;

  
}

/** Adds an item at the rear of Deque. Return true if the operation is successful. */
bool myCircularDequeInsertLast(MyCircularDeque* obj, int value) {
	if ( myCircularDequeIsFull(obj)) return false;

	obj->arr[obj->tail] = value;
	obj->tail = (obj->tail+1) % obj->size;

	return true;
  
}

/** Deletes an item from the front of Deque. Return true if the operation is successful. */
bool myCircularDequeDeleteFront(MyCircularDeque* obj) {
	if ( myCircularDequeIsEmpty(obj)) return false;

	obj->head = (obj->head+1) % obj->size;
	return true;
  
}

/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
bool myCircularDequeDeleteLast(MyCircularDeque* obj) {
	if ( myCircularDequeIsEmpty(obj)) return false;
  
	obj->tail = (obj->tail-1+obj->size) % obj->size;
	return true;
}

/** Get the front item from the deque. */
int myCircularDequeGetFront(MyCircularDeque* obj) {
	if ( myCircularDequeIsEmpty(obj) ) return -1;

	return obj->arr[obj->head];
  
}

/** Get the last item from the deque. */
int myCircularDequeGetRear(MyCircularDeque* obj) {
	if ( myCircularDequeIsEmpty(obj) ) return -1;

	int pos = (obj->tail+obj->size-1) % obj->size;

	return obj->arr[pos];

  
}

/** Checks whether the circular deque is empty or not. */
bool myCircularDequeIsEmpty(MyCircularDeque* obj) {

	return (obj->head == obj->tail) ? true : false;
  
}

/** Checks whether the circular deque is full or not. */
bool myCircularDequeIsFull(MyCircularDeque* obj) {

	return (obj->head == (obj->tail+1) % obj->size) ? true : false;
  
}

void myCircularDequeFree(MyCircularDeque* obj) {
	free(obj->arr);
	free(obj);
	return ;
    
}

/**
 * Your MyCircularDeque struct will be instantiated and called as such:
 * MyCircularDeque* obj = myCircularDequeCreate(k);
 * bool param_1 = myCircularDequeInsertFront(obj, value);
 
 * bool param_2 = myCircularDequeInsertLast(obj, value);
 
 * bool param_3 = myCircularDequeDeleteFront(obj);
 
 * bool param_4 = myCircularDequeDeleteLast(obj);
 
 * int param_5 = myCircularDequeGetFront(obj);
 
 * int param_6 = myCircularDequeGetRear(obj);
 
 * bool param_7 = myCircularDequeIsEmpty(obj);
 
 * bool param_8 = myCircularDequeIsFull(obj);
 
 * myCircularDequeFree(obj);
*/
