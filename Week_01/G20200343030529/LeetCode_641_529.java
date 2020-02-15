import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=641 lang=java
 *
 * [641] 设计循环双端队列
 */

// @lc code=start

/*
* 方法一：采用单链表，缺点在于每次插入新value，都要new一个node。
*/
// class MyCircularDeque {

//     private LinkedList<Integer> linkedList = new LinkedList<>();
//     private int size = 0;
//     private int n = 0;

//     public MyCircularDeque(int k) {
//         size = k;
//     }

//     public boolean insertFront(int value) {
//         if (isFull()) {
//             return false;
//         }
//         linkedList.addFirst(value);
//         n++;
//         return n <= size;
//     }

//     public boolean insertLast(int value) {
//         if (isFull()) {
//             return false;
//         }
//         linkedList.addLast(value);
//         n++;
//         return n <= size;
//     }

//     public boolean deleteFront() {
//         if (isEmpty()) {
//             return false;
//         }
//         linkedList.removeFirst();
//         n--;
//         return true;
//     }

//     public boolean deleteLast() {
//         if (isEmpty()) {
//             return false;
//         }
//         linkedList.removeLast();
//         n--;
//         return true;
//     }

//     public int getFront() {
//         if (isEmpty()) {
//             return -1;
//         }
//         return linkedList.getFirst();
//     }

//     public int getRear() {
//         if (isEmpty()) {
//             return -1;
//         }
//         return linkedList.getLast();
//     }

//     public boolean isEmpty() {
//         return n == 0;
//     }

//     /** Checks whether the circular deque is full or not. */
//     public boolean isFull() {
//         return n == size;
//     }
// }

/*
* 方法二：采用数组+双指针，一个指针为head，一个指针为tail
*/
// class MyCircularDeque {
//     private int[] array;
//     private int head = 0;
//     private int tail = 0;
//     //队列中数据大小
//     private int n = 0;

//     public MyCircularDeque(int k) {
//         array = new int[k];
//     }

//     /*
//     * 向队列头插入元素，需要递增head指针，但需要处理head指针指向数组末尾情况，
//     * head到达末尾，需要回到数组0位置
//     */
//     public boolean insertFront(int value) {
//         if (isFull()) {
//             return false;
//         }
//         //处理队列为空时，在array数组中0位置插入数据
//         if (n == 0) {
//             array[head] = value;
//             n++;
//             return true;
//         }
//         if (head + 1 == array.length) {
//             head = 0;
//         } else {
//             head++;
//         }
//         array[head] = value;
//         n++;
//         return true;
//     }

//     /*
//     * 向队列尾插入元素，需要递减tail指针，但需要处理tail指针指向数组0位置的情况，
//     * tail到数组0位置，需要回到数组末尾
//     */
//     public boolean insertLast(int value) {
//         if (isFull()) {
//             return false;
//         }
//         //处理队列为空时，在array数组中0位置插入数据
//         if (n == 0) {
//             array[tail] = value;
//             n++;
//             return true;
//         }
//         if (tail == 0) {
//             tail = array.length - 1;
//         } else {
//             tail--;
//         }
//         array[tail] = value;
//         n++;
//         return true;
//     }

//     /*
//     * 删除队列头，head指针递减，但需要处理head指针到达数组0位置后，需要回到数组末尾
//     */
//     public boolean deleteFront() {
//         if (isEmpty()) {
//             return false;
//         }
//         n--;
//         array[head] = 0;
//         if (n == 0) {
//             return true;
//         }
//         if (head == 0) {
//             head = array.length - 1;
//         } else {
//             head--;
//         }
//         return true;
//     }

//     /*
//     * 删除队列尾，tail指针递增，但需要处理tail指针到达数组末尾位置后，需要回到数组0位置
//     */
//     public boolean deleteLast() {
//         if (isEmpty()) {
//             return false;
//         }
//         n--;
//         array[tail] = 0;
//         if (n == 0) {
//             return true;
//         }
//         if (tail == array.length - 1) {
//             tail = 0;
//         } else {
//             tail++;
//         }
//         return true;
//     }

//     public int getFront() {
//         if (isEmpty()) {
//             return -1;
//         }
//         return array[head];
//     }

//     public int getRear() {
//         if (isEmpty()) {
//             return -1;
//         }
//         return array[tail];
//     }

//     public boolean isEmpty() {
//         if (n == 0) {
//             return true;
//         }
//         return false;
//     }

//     public boolean isFull() {
//         if (n == array.length) {
//             return true;
//         }
//         return false;
//     }
// }

/*
* 方法三：采用数组+双指针，一个指针为head，一个指针为tail，
* 但数组大小为输入大小的2n+1倍，且head和tail指向(2n + 1) / 2位置，
* 即数组中间。此做法不用处理head和tail指针分别在数组两端位置的情况，缺点是空间复杂度为O(2n)
*/
class MyCircularDeque {
    private int[] array;
    private int head = 0;
    private int tail = 0;
    private int n = 0;
    private int size = 0;

    public MyCircularDeque(int k) {
        size = k;
        array = new int[2 * size + 1];
        head = array.length / 2;
        tail = head;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        if (n != 0) {
            head++;
        }
        n++;
        array[head] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        if (n != 0) {
            tail--;
        }
        n++;
        array[tail] = value;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        array[head] = 0;
        n--;
        if (n != 0) {
            head--;
        }
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        array[tail] = 0;
        n--;
        if (n != 0) {
            tail++;
        }

        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return array[head];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return array[tail];
    }

    public boolean isEmpty() {
        if (n == 0) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (n == size) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyCircularDeque obj = new MyCircularDeque(3);
        boolean param_0 = obj.insertFront(3);
        boolean param_1 = obj.insertFront(3);
        boolean param_2 = obj.insertLast(1);
        boolean param_3 = obj.insertLast(2);
        boolean param_4 = obj.insertFront(4);
        int param_5 = obj.getRear();
        boolean param_6 = obj.isFull();
        boolean param_7 = obj.deleteLast();
        boolean param_8 = obj.insertFront(4);
        int param_9 = obj.getFront();

    }
}

// @lc code=end
