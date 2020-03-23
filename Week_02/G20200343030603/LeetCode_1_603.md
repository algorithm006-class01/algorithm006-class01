##HashMap小结：
###1、HashMap底层结构：
Java8以前，HashMap采用数组+链表的数据结构，Java8及以后，采用数组+链表+红黑树数据结构。
###2、HashMap的put方法
主要总结一下put方法的逻辑：
（1）如果HashMap未被初始化过，则初始化；
（2）对Key求Hash值，然后再计算下标；
（3）如果没有碰撞，直接放入桶中；
（4）如果碰撞了，以链表的方式链接到后面；
（5）如果链表长度超过阀值，就把链表转成红黑树；
（6）如果链表长度低于阀值，就把红黑树转回链表；
（7）如果节点已经存在就替换旧值；
（8）如果桶满了（容量16*加载因子0.75），就需要resize（扩容2倍后重排）；