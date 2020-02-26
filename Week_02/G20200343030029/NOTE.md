#HashMap 理解
***
* 存储方式（存储结构为key value形式）

    存储结构包括（数组+链表+红黑树 [^jdk 1.8以及之后版本包括红黑树]）
    
    数组主要存储 针对Key hash()之后的值
    
    链表主要存储相同key hash()之后的key value 以及下一个节点指针（在jdk 1.8之后，相同hash()值所产生的链表长度
    超过8时转换链表为红黑树存储）
    
* put()
    * ①判断键值对数组table[i]是否为空或为null，否则执行resize()进行扩容；
    * ②根据键值key计算hash值得到插入的数组索引i，如果table[i]==null，直接新建节点添加，转向⑥，如果table[i]不为空，转向③；
    * ③判断table[i]的首个元素是否和key一样，如果相同直接覆盖value，否则转向④，这里的相同指的是hashCode以及equals；
    * ④判断table[i] 是否为treeNode，即table[i] 是否是红黑树，如果是红黑树，则直接在树中插入键值对，否则转向⑤；
    * ⑤遍历table[i]，判断链表长度是否大于8，大于8的话把链表转换为红黑树，在红黑树中执行插入操作，否则进行链表的插入操作；遍历过程中若发现key已经存在直接覆盖value即可；
    * ⑥插入成功后，判断实际存在的键值对数量size是否超多了最大容量threshold，如果超过，进行扩容。
* get()

    根据(hash() & n-1)找到数据在数组中存储位置，然后根据key在数组指向的链表中查找。
 
 具体参考连接 [hashMap理解](https://www.jianshu.com/p/30bffabb2e5c)