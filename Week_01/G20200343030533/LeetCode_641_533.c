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
	int *arr; //存放数据
	int head; //对首
	int rear; //队尾
	int capacity; //容量

} MyCircularDeque;

/** Initialize your data structure here. Set the size of the deque to be k. */

//浪费一个空格用于检查空间
MyCircularDeque* myCircularDequeCreate(int k) {
	MycircularDeque *obj = (MyCircularDeque *)malloc(sizeof(MyCircularDeque));
	obj->head = 0;
	obj->tail = 0;
	obj->arr = (int *)malloc(sizeof(int) * (k+1));
	obj->capacity = k;
}

/** Adds an item at the front of Deque. Return true if the operation is successful. */
bool myCircularDequeInsertFront(MyCircularDeque* obj, int value) {
	if (myCircularDequeIsFull(obj)) return false;

	obj->arr[obj->rear] = value;



}

/** Adds an item at the rear of Deque. Return true if the operation is successful. */
bool myCircularDequeInsertLast(MyCircularDeque* obj, int value) {

}

/** Deletes an item from the front of Deque. Return true if the operation is successful. */
bool myCircularDequeDeleteFront(MyCircularDeque* obj) {

}

/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
bool myCircularDequeDeleteLast(MyCircularDeque* obj) {

}

/** Get the front item from the deque. */
int myCircularDequeGetFront(MyCircularDeque* obj) {

}

/** Get the last item from the deque. */
int myCircularDequeGetRear(MyCircularDeque* obj) {

}

/** Checks whether the circular deque is empty or not. */
bool myCircularDequeIsEmpty(MyCircularDeque* obj) {

	return obj->head == obj->rear ? true : false;

}

/** Checks whether the circular deque is full or not. */
bool myCircularDequeIsFull(MyCircularDeque* obj) {
	//队尾追到队首
	if ( (obj->rear + 1) % obj->capacity == obj->head) {
		return true;
	} else{
		return false;
	}

}

void myCircularDequeFree(MyCircularDeque* obj) {
	free(obj->arr);
	free(obj);
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
