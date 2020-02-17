# 学习笔记（第一周）

**学号：** G20200343030601

**姓名：** 冯学智

**微信：** SDMrFeng

## 1. 用add first或add last这套新的API改写Deque的代码

        Deque<String> deque = new LinkedList<String>();
        deque.addFirst("a");
        deque.addLast("b");
        deque.addLast("c");
        System.out.println(deque);

        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size() > 0){
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);

## 2. 分析Queue源码

java中Queue是实现了Collection的接口，包括以下接口函数：

- boolean add(E e)
  
  向队列中添加一个元素。一些队列有大小限制，因此如果想在一个满的队列中加入一个新项，调用 add() 方法就会抛出一个 unchecked 异常。

- boolean offer(E e)
  向队列中添加一个元素。一些队列有大小限制，因此如果想在一个满的队列中加入一个新项，调用 offer() 方法会返回 false。

- E remove()
  
  从队列中删除第一个元素。如果队列元素为空，调用remove() 的行为与 Collection 接口的版本相似会抛出异常。

- E poll()

  从队列中删除第一个元素。如果队列元素为空，调用poll() 方法时只是返回 null。因此新的方法更适合容易出现异常条件的情况。

- E element()

  element()用于在队列的头部查询元素。与 remove() 方法类似，在队列为空时， element() 抛出一个异常。

- E peek()

  peek() 用于在队列的头部查询元素。与 poll() 方法类似，在队列为空时，peek() 返回 null。

## 3. 分析Priority Queue源码

PriorityQueue实现了AbstractQueue，PriorityQueue内部由最小堆实现，也就是说每次执行add或是remove之后，总是让最小的元素移动到根，但是，使用迭代器进行访问时，不会保证一个递增的顺序。为了维持最小堆，队列的元素类型必须实现Comparable接口，或者是在构造队列的时候提供一个元素类型的比较器（Comparator），所以元素不能为空。队列的访问操作poll, remove, peek, and element访问的是队头元素，在这里也就是根元素，也就是最小的元素。实现的主要函数包括以下：

- 构造函数

  PriorityQueue的构造函数大致分为两类，一种是确定数组初始化大小和Comparator，另一种是由Collection对象构造

- add/offer
  
  add通过offer实现。这个函数干了这几件事情：检查为空，增加修改次数，需要的情况下扩展，增加大小，赋值，向上调整堆，返回真。
  这里的关键是SiftUp函数：将要插入的节点与父节点进行比较，如果更小，就将父节点往下，然后继续向上比较，如果大于等于，就放在当前的位置。

- remove()/poll()

  删除并返回最小的队头元素后，将数组末位的元素放到队头，然后SiftDown，基本于上面相反。删除并返回最小的队头元素后，将数组末位的元素放到队头，然后SiftDown，基本于上面相反。

## 4. 个人第一周学习总结

- 对数据结构掌握没有形成体系，这一周下来，感觉之前自己脑袋里的知识混乱不堪；可以想象接下来几周学习复杂数据结构时，不堪一击的样子。

- 刷Leetcode题没有套路，以前做过几道Leetcode题目，稍微用时快一些就沾沾自喜，根本没有get到刷题的精髓。没有形成做题的思考套路、不知道看别人的题解、submit通过即结束，没有复盘和反思总结。

- 没有阅读源码的习惯，也不知道从哪里开始阅读如何阅读。以及Review别人代码或让高手review自己代码的习惯，正是覃超老师预习周给讲到的feedback。

- 将课程中涉及到的题目整理到excel中，按照五遍刷题法进行复习提炼。

- 来训练营的目的掌握课上内容不是目的，做完作业也不是目的，最重要的是掌握思维模式、把知识形成体系、提炼学习套路。