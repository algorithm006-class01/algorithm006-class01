问题1：重写DequeDemo

import java.util.Deque;
import java.util.LinkedList;
public class DequeDemo {
  public static void main(String[] args) {
    Deque<String> deque = new LinkedList<String>();
    deque.offerFirst("a");
    deque.offerFirst("b");
    deque.offerFirst("c");
    System.out.println(deque);
    String str = deque.peekFirst();
    System.out.println(str);
    System.out.println(deque);
    while (deque.size() > 0) {
      System.out.println(deque.pollFirst());
    }
    System.out.println(deque);
  }
}
  
问题2：分析queue源码:
    接口Queue继承于Collection接口，除Collection中声明方法外，增加声明了六个针对队列的基本操作，根据功能性分为三组：新增元素add()/offer()、出队元素remove()/poll()、复制队首元素element()/peek()，其中 add()/remove()/element()会在操作失败时抛出相应异常。
    PriorityQueue为类，实现了基本的Queue操作，还支持在添加或删除元素时根据权值来排序，对自定义类可通过传入构造器来进行权值判定。
        1. 在添加元素时，其内部调用链为：add->offer->siftUp->siftUpUsingComparator(提供构造器)/siftUpComparable(元素自然顺序)
        2. 在删除元素时，其内部调用链为：poll->siftDownComparable(元素自然顺序)/siftDownUsingComparator(提供构造器)
    另外，在源码中，队列是以Object[] 数组来存储，以二叉树实现排序存储.在sift* 中均设定了排序及调整策略。
    PriorityQueue类支持动态扩容（grow函数），当当前容量为64以内时，每次扩容为2倍+2，大于等于64时，每次扩为1.5倍。内部设定元素最大值为2^31-8。如果扩容后大于最大值，则会判断当前所需数组大小是否大于最大值，如大于最大值，则返回2^31作为扩容后大小。
    
课后总结：第一周主要为线性结构，理解上难点不多，但是做题时经常第一想法要复杂很多，需要经过详细验算才能得出一个较为复杂的方案，还需要根据老师提供的思想进行多练习。从分析源码的过程中，对JAVA源代码的写作风格也有所学习，对自顶向下的编程思想有了更多的感悟，后续在遇到复杂编程时还需要多加练习。
  
