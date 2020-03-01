学习笔记
# 树
   - 深度、层、前中后序遍历、层序遍历
## 二叉树
   - 每个节点最多左右两个子节点
## 二叉搜索树
   - 左节点小于根节点，右节点大于根节点；左子树全小于根节点，右子树全大于根节点
   - 中序遍历为升序数组

# 递归
## 盗梦空间
   - 模板
      ```java
      public void recur(int lever,int param) {
        // terminator
        if(leverl > max_level){
            // process result
            return;
        }
        //process current logic
        process(level,param);
        
        //drill down
        recur(level:level+1,newParam);
        
        //restore current status
      }
      ```
   - 注意
     1. 抵制人肉递归
     2. 找最近重复性
     3. 数学归纳法思维

#. HashMap 

   1. 基于Hash表的非同步实现,允许K-V 为null;
   1. 底层基于数组实现(HashMap.Entry[]),单项为一个链表
   1. HashMap.Entry 包含K,V,next Entry<K,V>,hash
   1. put(K,V) 通过hash(key.hashCode())计算出hash值决定其在数组中的存储位置，如果此位置上有对象的话，再去使用 equals方法进行比较，如果对此链上的每个对象的 equals 方法比较都为 false，则将该对象放到数组当中，然后将数组中该位置以前存在的那个对象链接到此对象的后面
   1. get(K) 首先计算key的hashCode，找到数组中对应位置的某一元素，然后通过key的equals方法在对应位置的链表中找到需要的元素。
   1. 当hash冲突很多时，HashMap退化成链表。
   1. key为null时，都放到table[0]
   1. 扩容默认负载因子0.75,重新计算位置单个Entry在新数组中的位置 (resize)
   1. fast-fail volatile modCount
   1. java 8 HashMap 改为 数组+链表/红黑树,同一hash位下链表元素>=8时,链表转换为红黑树