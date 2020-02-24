学习笔记--HasMap小结

--HashMap的工作原理
HashMap基于hashing原理，我们通过put()和get()方法储存和获取对象。
当我们将键值对传递给put()方法时，它调用键对象的hashCode()方法来计算hashcode，让后找到bucket位置来储存值对象。
当获取对象时，通过键对象的equals()方法找到正确的键值对，然后返回值对象。
HashMap使用LinkedList来解决碰撞问题，当发生碰撞了，对象将会储存在LinkedList的下一个节点中。
 HashMap在每个LinkedList节点中储存键值对对象。
当两个不同的键对象的hashcode相同时， 它们会储存在同一个bucket位置的LinkedList中。键对象的equals()方法用来找到键值对。

--HashMap的定义
HashMap实现了Map接口，继承AbstractMap。
其中Map接口定义了键映射到值的规则，而AbstractMap类提供 Map 接口的骨干实现，以最大限度地减少实现此接口所需的工作！

--HashMap的数据结构
HashMap的底层主要是基于数组和链表来实现的，它之所以有相当快的查询速度主要是因为它是通过计算散列码来决定存储的位置。
HashMap中主要是通过key的hashCode来计算hash值的，只要hashCode相同，计算出来的hash值就一样。
如果存储的对象对多了，就有可能不同的对象所算出来的hash值是相同的，这就出现了所谓的hash冲突。
学过数据结构的同学都知道，解决hash冲突的方法有很多，HashMap底层是通过链表来解决hash冲突的。

