知识储备

## 参考链接

- [Java 源码分析（ArrayList）](http://developer.classpath.org/doc/java/util/ArrayList-source.html)
- [Linked List 的标准实现代码](http://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/)
- [Linked List 示例代码](http://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked Lists/code/LinkedList.java)
- [Java 源码分析（LinkedList）](http://developer.classpath.org/doc/java/util/LinkedList-source.html)
- LRU Cache - Linked list：[ LRU 缓存机制](http://leetcode-cn.com/problems/lru-cache)
- Redis - Skip List：[跳跃表](http://redisbook.readthedocs.io/en/latest/internal-datastruct/skiplist.html)、[为啥 Redis 使用跳表（Skip List）而不是使用 Red-Black？](http://www.zhihu.com/question/20202931)

- [Java 的 PriorityQueue 文档](http://docs.oracle.com/javase/10/docs/api/java/util/PriorityQueue.html)
- [Java 的 Stack 源码](http://developer.classpath.org/doc/java/util/Stack-source.html)
- [Java 的 Queue 源码](http://fuseyism.com/classpath/doc/java/util/Queue-source.html)
- [Python 的 heapq](http://docs.python.org/2/library/heapq.html)
- [高性能的 container 库](http://docs.python.org/2/library/collections.html)

- [Java Set 文档](http://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Set.html)
- [Java Map 文档](http://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Map.html)



## Array、Linked List 实战题目

- https://leetcode-cn.com/problems/container-with-most-water/

  ```java
  		/**
  		 * 盛最多水的容器
  		 * 采用双指针左右向中间收敛
    	 * 1. 遍历数组 并且定义2个指针  rear和head 如果head < rear 就遍历
    	 * 2. 求面积 s = x * y 
    	 *    x = (rear - head)  
    	 *    y = Math.min(nums[rear],nums[head]);
    	 * 3. 取出最大的面积
  		 */
      public int maxArea(int[] nums) {
          int maxArea = 0;
          for (int head = 0,rear = nums.length - 1; head < rear;  ) {
              int minHeight = nums[head] > nums[rear] ? nums[rear--] : nums[head++] ;
              int area = (rear - head + 1) * minHeight;
              maxArea = Math.max(maxArea,area);
          }
          return maxArea;
      }
  ```

  

- https://leetcode-cn.com/problems/move-zeroes/

  ```java
  //移动0
  //思想就是快慢指针 : 如果快不为0并且2个指针的不想等就用慢指针记录快指针的值,将快指针置为0
  public void moveZeroes(int[] nums) {
       int j = 0;
       for (int i = 0; i < nums.length; i++) {
           if (nums[i] != 0) { 
               nums[j] = nums[i];
               if (i != j ) {
                   nums[i] = 0;
               }
               j++;  
            }
       }
   }
  //双指针
  public void moveZeroes(int[] nums) {
      if (nums == null || nums.length == 0) return;        
      int insertPos = 0;
      for (int num: nums) {
          if (num != 0) nums[insertPos++] = num;
      }        
      while (insertPos < nums.length) {
          nums[insertPos++] = 0;
      }
  }
  ```

- https://leetcode.com/problems/climbing-stairs/

  ```java
      /**
       *  
       * 方式一、 爬楼梯
       * 方式二、 初始化3个值,每次修改前2个值,第三个值等于前两个值只和
       * 
       */    
      public int climbStairs(int n) {
           if (n <= 2) {
               return n;
           }
           return climbStairs(n - 1) + climbStairs(n - 2);  
      }
      public int climbStairs(int n) {
          if (n == 1) return 1;
          if (n == 2) return 2;
          
          int first = 1;
          int second = 2;
          int result = 0;
          for (int i = 3; i <= n; i++) {
              result = first + second;
              first = second;
              second = result;
          }
          return  result;
      }
  ```

  

- [https://leetcode-cn.com/problems/3sum/ ](https://leetcode-cn.com/problems/3sum/)(高频老题）

  ```java
     /**
      *  
      *  三数只和
      *  双指针向内收敛
      * 
      */  
  	 public List<List<Integer>> threeSum(int[] nums) {
          //结果保存在list集合中
          List<List<Integer>> result = new  ArrayList<>();
          //排序
          Arrays.sort(nums);
          //遍历集合
          //定义2个指针 i、j
          int i;
          int j;
          for (int k = 0; k < nums.length; k++) {
              // 因为已经排好序nums[k],nums[i],nums[j]中nums[k]最小,如果nums[k]大于0那么三数只和就不可能等于0,直接返回
              if (nums[k] > 0) break;
              //k对应元素去重
              if (k > 0 && nums[k] == nums[k-1])  continue;
              i = k + 1; //i从k的下一个元素开始
              j = nums.length - 1;//j从最后一个元素开始
              while (i < j) {
                  int sum = nums[k] + nums[i] + nums[j];
                  if ( sum == 0) {
                      result.add(Arrays.asList(nums[k],nums[i],nums[j]));
                      //i、j元素去重
                      while (i < j && nums[i] == nums[i+1]) { i++; }
                      while (i < j && nums[j] == nums[j-1]) { j--; }
                      i++;
                      j--;
                  }
                  else if (sum < 0) i ++;
                  else   j --;
              }
          }
          return result;
      }
  ```

- https://leetcode.com/problems/reverse-linked-list/

  ```java
  /**
   * 反转链表
   * Definition for singly-linked list.
   * public class ListNode {
   *     int val;
   *     ListNode next;
   *     ListNode(int x) { val = x; }
   * }
   */
  class Solution {
      public ListNode reverseList(ListNode head) {
          ListNode cur = head;
          ListNode pre = null;
          while (cur != null) {
              ListNode temp = cur.next;
              cur.next = pre;
              pre = cur;
              cur = temp;
          }
          return pre;
      }
  }
  ```

- https://leetcode.com/problems/swap-nodes-in-pairs

  ```java
  /**
   * 两两交换链表中的节点
   * Definition for singly-linked list.
   * public class ListNode {
   *     int val;
   *     ListNode next;
   *     ListNode(int x) { val = x; }
   * }
   * 知识储备
   * 链表的第一个node，因为没有前驱节点，所以该node需要特殊处理，会导致额外的代码量。
   * 如果创建一个dummy，将其作为第一个node的前驱节点，这样链表中所有的node都可以也能够同样的逻辑来处理了
   */
  class Solution {
      //非递归 time complexity O(n) space complexity O(1)
      public ListNode swapPairs(ListNode head) {
          //1. 定义一个虚拟节点(为什么? 看上述知识储备)
          ListNode dummy = new ListNode(-1);
          dummy.next = head; //将虚拟节点作为链表第一个节点的前驱节点
          ListNode pre = dummy; //取出前驱节点
          //原链表的第一个节点和第二个节点不为空,取出并且交换
          while (head != null && head.next != null) { 
              ListNode first = head;
              ListNode second = head.next;
              //相邻节点进行交换
              pre.next = second;
              first.next = second.next;
              second.next = first;
              //指针后移
              pre = first;
              head = first.next;
          }   
          return dummy.next;
      }
  
      //递归 time complexity O(n) space complexity O(n)
      public ListNode swapPairs(ListNode head) {
          if (head == null || head.next == null) {
              return head;
          }
          ListNode first = head;
          ListNode second = head.next;
  
          first.next = swapPairs(second.next);
          second.next = first;
          return second;
  
      }
  
  }
  ```

- https://leetcode.com/problems/linked-list-cycle

  ```java
  /**
   * 环形链表
   * Definition for singly-linked list.
   * class ListNode {
   *     int val;
   *     ListNode next;
   *     ListNode(int x) {
   *         val = x;
   *         next = null;
   *     }
   * }
   * 
   * 方式一、使用哈希表记录
   *        判断是否存在环,不能根据链表中的值来判断,因为值可能有重复,哈希表的范型应该是链表中的节点
   * 方式二、快慢指针
   *        
   * 
   */
  
  public class Solution {
      public boolean hasCycle(ListNode head) {
          //List<ListNode> nums = new ArrayList<ListNode>();
          Set<ListNode> set = new HashSet<ListNode>(); 
          while (head != null) {
              if (set.contains(head)) {
                  return true;
              }
              set.add(head);
              head  = head.next;
          }
          return false;
      }
      public boolean hasCycle(ListNode head) {
          if (head == null || head.next == null) {
              return false;
          }
          ListNode slow = head;
          ListNode fast = head.next;
          while (slow != fast) {
              if (fast == null || fast.next == null) {
                  return false;
              }
              slow = slow.next;
              fast = fast.next.next;
          }
          return true;
      }
  }
  ```

  

- https://leetcode.com/problems/linked-list-cycle-ii

  ```java
  /**
   * 环形链表二
   * Definition for singly-linked list.
   * class ListNode {
   *     int val;
   *     ListNode next;
   *     ListNode(int x) {
   *         val = x;
   *         next = null;
   *     }
   * }
   */
  public class Solution {
      //方式一、借助哈希表
      public ListNode detectCycle(ListNode head) {
          Set<ListNode> set = new HashSet<ListNode>(); 
          while (head != null) {
              if (set.contains(head)) {
                  return head;
              }
              set.add(head);
              head  = head.next;
          }
          return null;
      }
      // 方式二、快慢指针,查看高手解答 膜拜的感觉 请看代码块下方解释
  		public ListNode detectCycle(ListNode head) {
          if (head == null || head.next == null) {
              return null;
          }
          ListNode fast = head; //定义一个快指针
          ListNode slow = head; //定义一个慢指针
          
          while (fast.next != null && fast.next.next != null) {
              fast = fast.next.next;
              slow = slow.next;
              
              if (fast == slow) {
                	// 新定义一个指针从头节点开始一次走一步,慢指针从快慢指针相遇的地方开始一次走一步
                  ListNode meetNode = head;
                  while (slow != meetNode) {
                      slow = slow.next;
                      meetNode = meetNode.next;
                  }
                  return meetNode;
              }
          }
          return null;
       
      }
    
  }
  ```

   https://leetcode.com/problems/linked-list-cycle-ii/discuss/44774/Java-O(1)-space-solution-with-detailed-explanation.
  Is this diagram help you understand?
  When fast and slow meet at point p, the length they have run are 'a+2b+c' and 'a+b'.
  Since the fast is 2 times faster than the slow. So a+2b+c == 2(a+b), then we get 'a==c'.
  So when another slow2 pointer run from head to 'q', at the same time, previous slow pointer will run from 'p' to 'q', so they meet at the pointer 'q' together.

  <img src="/Users/wangfeng/Library/Application Support/typora-user-images/image-20200307172330680.png" alt="image-20200307172330680" style="zoom:50%;" />

- 🌟 https://leetcode.com/problems/reverse-nodes-in-k-group/ 

  ```java
  /**
   *
   *  K 个一组翻转链表
   */
  class Solution {
      //第一种方式: 递归 看不懂
      public ListNode reverseKGroup(ListNode head, int k) {
          //方式一、使用递归
          //1. 找到定义个计数器,找第k+1个节点
          ListNode curr = head;
          int count = 0;
          while (curr.next != null && count != k) {
              curr = curr.next;
              count++;
          }
          // 反转
          if (count == k) {
              curr = reverseKGroup(curr,k);
              while (count-- >0) {
                  ListNode temp = head.next;
                  head.next = curr;
                  curr = head;
                  head = temp;
              }
              head = curr;
          }
          return head;
      } 
  }
  ```

  

- https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/

  ```java
  /**
   *
   * 删除排序数组中的重复项
   * 使用双指针,i,j其中j记录的是nums中非重复元素的下标
   * 前提: 
   * 	1. 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
   *	2. 不需要考虑数组中超出新长度后面的元素
   */
  class Solution {
      public int removeDuplicates(int[] nums) {
          int j = 0;
          for (int i = 1; i < nums.length; i++) {
              if (nums[j] != nums[i]) {
                  nums[++j] = nums[i];
              }
          }
          return j + 1;
      }
  }
  ```

  

- https://leetcode-cn.com/problems/rotate-array/

  ```java
  /**
   * 旋转数组
   * 方式一、使用三次反转
   *          第一次: 反转整个数组 
   *          第二次: 反转0~k-1个数组元素
   *          第三次: 反转k-1~len-1个数组元素
   *
   * 方式二、使用旋转数组
   *
   */
  class Solution {
      public void rotate(int[] nums, int k) {
          k = k%nums.length; //注意: 防止 nums=[1,2] k=3这种情况 
          reverse(nums,0,nums.length-1);
          reverse(nums,0,k-1);
          reverse(nums,k,nums.length-1);
      }
  
      public void reverse(int[] nums,int start,int end) {
          int i = start;
          int j = end;
          //注意,这里应该使用的是小于号 while (i < j),不能使用不等于 while (i != j) 
          while (i < j) { 
              int temp = nums[j];
              nums[j] = nums[i];
              nums[i] = temp;
              i++;
              j--;
          }
      }
    
    /**
     * 待研究
     */
    public class Solution {
      public void rotate(int[] nums, int k) {
          k = k % nums.length;
          int count = 0;
          for (int start = 0; count < nums.length; start++) {
              int current = start;
              int prev = nums[start];
              do {
                  int next = (current + k) % nums.length;
                  int temp = nums[next];
                  nums[next] = prev;
                  prev = temp;
                  current = next;
                  count++;
              } while (start != current);
          }
      }
  	}
  
  }
  ```

  

- https://leetcode-cn.com/problems/merge-two-sorted-lists/

  ```java
  /**
   * 合并2个有序链表
   * Definition for singly-linked list.
   * public class ListNode {
   *     int val;
   *     ListNode next;
   *     ListNode(int x) { val = x; }
   * }
   * 思路分析: 
   * 创建一个新的列表,遍历链表1和链表2,分别比较每个节点的大小放入融合列表中
   */
  class Solution {
      public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
          ListNode headNode = new ListNode(-1);
          ListNode cur1 = l1;
          ListNode cur2 = l2;
          ListNode curMerge = headNode;
          while (cur1 != null && cur2 != null) {
              if (cur1.val > cur2.val) {
                  curMerge.next = cur2;
                  cur2 = cur2.next;
              }else {
                  curMerge.next = cur1;
                  cur1 = cur1.next;
              }
              curMerge = curMerge.next;
          }
          curMerge.next  = cur1 == null ? cur2 : cur1;
          return headNode.next;
      }
  }
  ```

  

- https://leetcode-cn.com/problems/merge-sorted-array/

  ```java
  /**
   * 合并2个有序数组
   * 	题目要点:  1. 使用取余的方式判断i+k大于len 则从头开始 arr[(i + k) % nums.length]
   *					 2. 需要重新开辟一个数组去存放旋转之后的值 用于改变原数组的顺序 
   *  一定要注意,题干明确表示需要  有序整数数组
   */
  class Solution {
     	// time complexity O((n+m)log(n+m)) space complexity O(n+m)
      public void merge(int[] nums1, int m, int[] nums2, int n) {
           int j = 0;
           for (int i = m; i < m + n; i++) {
               nums1[i] = nums2[j];
               j++; 
           }
           Arrays.sort(nums1);
      }
  		//time complexity O(n+m)  space complexity O(n)
      public void merge(int[] nums1, int m, int[] nums2, int n) {
          //复制nums1的数组,保留有效数据位
          int[] nums1_copy = new int[m];
          System.arraycopy(nums1,0,nums1_copy,0,m);
          //定义2个指针p1 0~m p2 0~n
          int p1 = 0;
          int p2 = 0;
          int p = 0;
          while (p1 < m && p2 < n) {
              if (nums1_copy[p1] < nums2[p2]) {
                  nums1[p++] = nums1_copy[p1++];
              }else {
                  nums1[p++] = nums2[p2++];
              }
          }
          if (p1 < m) {
              System.arraycopy(nums1_copy,p1,nums1,p1+p2,m+n-p1-p2);
          }
          if (p2 < n) {
              System.arraycopy(nums2,p2,nums1,p1+p2,m+n-p1-p2);
          }
      }
      //最优解 从A数组的后边开始插入 time complexity O(n) space complexity O(1)
      public void merge(int A[], int m, int B[], int n) {
          int i=m-1;
          int j=n-1;
          int k = m+n-1;
          while(i >=0 && j>=0)
          {
            if(A[i] > B[j])
              A[k--] = A[i--];
            else
              A[k--] = B[j--];
          }
          while(j>=0)
            A[k--] = B[j--];
      }
  }
  ```

  

- https://leetcode-cn.com/problems/two-sum/

  ```java
  /* 
   * 两数之和
   * 方式一、 暴力求解法
   * 双层for循环 
   * time complexity O(n^2)
   * space complexity O(1)
   * 方式二、 使用哈希表
   * time complexity O(n) 只遍历了一边nums所以时间复杂度是O(n)
   * space complexity O(n) 空间复杂度取决于hash表中元素的个数
   *
   *
   *
   * 题目明确: 每种输入只会对应一个答案
   */
  class Solution {
       public int[] twoSum(int[] nums, int target) {
          for (int i = 0; i < nums.length; i++) {
              for (int j = i + 1; j < nums.length; j++) {
                  if (nums[i] + nums[j] == target) {
                      return new int[] { i, j };
                  }
              }
          }
      		throw new IllegalArgumentException("No two sum solution");
      }
      public int[] twoSum(int[] nums, int target) {
          Map<Integer,Integer> map = new HashMap<Integer,Integer>();
          for (int i = 0; i < nums.length; i++) {
              if (map.containsKey(target - nums[i])) {
                  return new int[]{i,map.get(target - nums[i])};
              }
              map.put(nums[i],i);
          }
          throw new IllegalArgumentException("No two sum solution");
      }
  }
  ```

  

- https://leetcode-cn.com/problems/move-zeroes/

  ```java
  /**
   * 移动零
   */
  class Solution {
      public void moveZeroes(int[] nums) {
          int index = 0;
          for (int num : nums) {
              if (num != 0) {
                  num[index++]=num;
              }
          }
          while (index < nums.length) {
              nums[index++]=0;
          }
      }
    
    public void moveZeroes(int[] nums) {
  		if(nums==null) {
  			return;
  		}
  		//两个指针i和j
  		int j = 0;
  		for(int i=0;i<nums.length;i++) {
  			//当前元素!=0，就把其交换到左边，等于0的交换到右边
  			if(nums[i]!=0) {
  				int tmp = nums[i];
  				nums[i] = nums[j];
  				nums[j++] = tmp;
  			}
  		}
  	}
  }
  ```

  

- https://leetcode-cn.com/problems/plus-one/

  ```java
  /**
   * 
   * 加一
   * 
   * 题目理解: 其实就是多位数加1之后的值 特殊情况就是出现9的时候需要进位,如果999这种数字,加1之后需要进位,需要给数组扩容
   * time complexity O(n) 
   * space complexity O(1)
   * 
   * 
   */
  class Solution {
      public int[] plusOne(int[] digits) {
          for (int i = digits.length - 1; i >= 0 ; i--) {
              digits[i]++;
              digits[i] = digits[i]%10;
              if (digits[i] != 0) {
                  return digits;
              }
          }
          digits = new int[digits.length + 1];
          digits[0] = 1;
          return digits;
      }
  }
  ```

  

## 哈希、集合题目

- https://leetcode-cn.com/problems/valid-anagram/description/

  ```java
  /**
   *
   * 是否是异位词
   * 方式1. 排序(借助字符数组进行排序) 判断内容是否相同
   *       time complexity O(nlogn)
   *       space complexity O(n)
   *       如果isAnagram中两个参数是字符数组,那么space complexity O(1)
   * 方式2. 使用hash表来统计每个字符出现的次数
   *
   */
  class Solution {
      public boolean isAnagram(String s, String t) {
          char[] sarr = s.toCharArray();
          char[] tarr = t.toCharArray();
          Arrays.sort(sarr);
          Arrays.sort(tarr);
          boolean flag = Arrays.equals(sarr,tarr);
          if (flag) {
              return true;
          }
          return false;
      }
  
  		public boolean isAnagram(String s, String t) {
          if (s.length() != t.length()) {
            return false;
          }
          int[] counter = new int[26];
          for (int i = 0; i < s.length(); i++) {
            //s.char[i]的个数加1 t.char[i]的个数减1, 最后遍历counter的值是否都为0即可
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
          }
          for (int count: counter) {
            if (count != 0) {
              return false;
            }
          }
          return true;
  		}
  }
  ```

  

- https://leetcode-cn.com/problems/group-anagrams/

  ```java
  /**
   * 1. 方式一、借助hash表,将字符数组中的元素排序之后当作key入map,值为未排序的元素的集合
   *    time complexity O(nklogk)  n表示的是Strs字符串数组的所有元素,每个元素的排序klogk   
   *    space complexity O(nk)   O(NK)，排序存储在 ls 中的全部信息内容。  
   *
   */
  class Solution {
      public List<List<String>> groupAnagrams(String[] strs) {
         Map<String,List<String>> map = new HashMap<String,List<String>>();
  
          for (String str: strs) {
              char[] chars = str.toCharArray();
              Arrays.sort(chars);
              String charStr = String.valueOf(chars);
              if (map.containsKey(charStr)) {
                  map.get(charStr).add(str);
              }else {
                  List<String> ls = new ArrayList<>();
                  ls.add(str);
                  map.put(charStr,ls);
              }
          }
  
          return new ArrayList<>(map.values());
      }
  }
  ```

  



## 树和递归实战题目

二叉树动态图 https://visualgo.net/zh/bst?slide=1

- https://leetcode-cn.com/problems/binary-tree-inorder-traversal/

  ```java
  /**
   * Definition for a binary tree node.
   * public class TreeNode {
   *     int val;
   *     TreeNode left;
   *     TreeNode right;
   *     TreeNode(int x) { val = x; }
   * }
   * 二叉树的中序遍历  左 根 右
   * 方式一、使用递归
   *        
   * 方式二、非递归 (借助栈)
   */
  class Solution {
    	//方式一、递归
      public List<Integer> inorderTraversal(TreeNode root) {
          List<Integer> result = new ArrayList<Integer>();
          helper(root,result);
          return result;
      }
  
      public void helper(TreeNode root,List<Integer> result) {
          if (root != null) {
              //递归所有左节点
              if (root.left != null) {
                  helper(root.left,result);
              }
              result.add(root.val);
              //递归所有右节点
              if(root.right != null) {
                  helper(root.right,result);
              }
          }
      }
  	 //方式二、 非递归
     public List<Integer> inorderTraversal(TreeNode root) {
          //定义容器用于存放返回结果
          List<Integer> result = new ArrayList<Integer>();
          //定义一个栈
          Stack<TreeNode> stack = new Stack<>();
          //遍历二叉树, 根节点入栈
          TreeNode cur = root;
          while (cur != null || !stack.empty()) {
              while (cur != null) {
                  stack.push(cur);
                  cur = cur.left;
              }
              cur = stack.pop();
              result.add(cur.val);
              cur = cur.right;
          }
          return result;
      }
  }
  ```

  

- https://leetcode-cn.com/problems/binary-tree-preorder-traversal/

  ```java
  /**
   * Definition for a binary tree node.
   * public class TreeNode {
   *     int val;
   *     TreeNode left;
   *     TreeNode right;
   *     TreeNode(int x) { val = x; }
   * }
   *
   * 二叉树的前序遍历
   * 使用递归 从根节点开始遍历,如果是根节点直接添加到结果的集合中,如果是左节点继续递归,同理有节点一样
   * 
   * 借助栈 
   * LinkedList 是一个双向链表。
   * 它也可以被当作堆栈、队列或双端队列进行操作。LinkedList随机访问效率低，但随机插入、随机删除效率低。
   * 总结: 本题中LinkedList比stack快
   *
   */
  class Solution {
      //方式一、递归遍历
      public List<Integer> preorderTraversal(TreeNode root) {
          List<Integer> result = new ArrayList<Integer>();
          helper(root,result);
          return result;
      }
  
      public void helper(TreeNode root,List<Integer> result) {
          if (root != null ) {
              result.add(root.val);
              if (root.left != null) {
                  helper(root.left,result);
              }   
              if (root.right != null) {
                  helper(root.right,result);
              }
          }
      }
      //方式二、非递归借助栈
      public List<Integer> preorderTraversal(TreeNode root) {
          //Stack<TreeNode> stack = new Stack<TreeNode>();
          LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
          List<Integer> result = new ArrayList<Integer>();
          if (root == null) {
              return result;
          }
          //先序遍历 先把根节点入栈
          //stack.push(root);
          stack.add(root);
          while (!stack.isEmpty()) { //栈不为空的时候
              //根节点出栈
              //TreeNode treeNode = stack.pop();
              TreeNode treeNode = stack.pollLast();
         
              result.add(treeNode.val);
              //先入右节点
              //再入左节点
              if (treeNode.right != null) {
                  //stack.push(treeNode.right);
                  stack.add(treeNode.right);
              }
              if (treeNode.left != null) {
                  //stack.push(treeNode.left);
                  stack.add(treeNode.left);
              }
          }
  
          return result;
  
      }
  
  }
  
  ```

  

- https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/

  ```java
  /*
   *
   * n叉树的遍历 - 后序遍历
   * 需要注意的就是根节点和自节点顺序与前序遍历相反
   *
   *
   *class Node {
   *   public int val;
   *    public List<Node> children;
   *   public Node() {}
   *   public Node(int _val) {
   *        val = _val;
   *    }
   *    public Node(int _val, List<Node> _children) {
   *        val = _val;
   *        children = _children;
   *    }
   *};
   */
  class Solution {
    	//递归
      public List<Integer> result  = new ArrayList<Integer>();
      public List<Integer> postorder(Node root) {
          if (root == null) 
              return result;
          for (Node child: root.children) {
              postorder(child);
          }
          result.add(root.val);
          return result;
      }
    	//非递归实现
      public List<Integer> postorder(Node root) {
          //定义返回结果的容器 
        	//(个人理解如果postorder循环很多次,建议容器传递进来,但是这个限制条件就在创建的时候加
          //,如果就循环一次创建一个容器)
          List<Integer> result = new ArrayList<>();
          //限制条件
          if (root == null) {
              return result;
          }
          Stack<Node> stack = new Stack<Node>();
          stack.add(root);
  
          while (!stack.empty()) {
              root = stack.pop();
              result.add(root.val);
              for (int i = 0; i < root.children.size() ; i++) {
                  stack.add(root.children.get(i));
              }
             
          }
          Collections.reverse(result);
          return result;
      }
  }
  ```

  

- [https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/](https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description)

  ```java
  /*
   *
   * n叉树的遍历 - 前序遍历
   * 非递归实现
   * 我们使用一个栈来帮助我们得到前序遍历，需要保证栈顶的节点就是我们当前遍历到的节点。
   * 我们首先把根节点入栈，因为根节点是前序遍历中的第一个节点。
   * 随后每次我们从栈顶取出一个节点 u，它是我们当前遍历到的节点，并把 u 的所有子节点逆序推入栈中。
   * 例如 u 的子节点从左到右为 v1, v2, v3，那么推入栈的顺序应当为 v3, v2, v1，
   * 这样就保证了下一个遍历到的节点（即 u 的第一个子节点 v1）出现在栈顶的位置。
   *
   */
  class Solution {
   		
    	//递归
      public List<Integer> result = new ArrayList<Integer>();
      public List<Integer> preorder(Node root) {
          if (root == null) {
              return result;
          }
          result.add(root.val);
          for (Node child: root.children) {
              preorder(child);
          }
  
          return result;
      }
    	//非递归实现
      public List<Integer> preorder(Node root) {
          //存放返回结果的容器
          List<Integer> result = new ArrayList<>();
          //限制条件
          if (root == null) return result;
          //定义一个栈
          Stack<Node> stack = new Stack<>();
          stack.add(root);
  
          while (!stack.empty()) {
              root = stack.pop();
              result.add(root.val);
              for (int i = root.children.size() - 1; i >= 0; i--) {
                  stack.add(root.children.get(i));
              }
          }
          return result;
      }
  }
  ```

  

- https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/

  ```java
  /*
   * n叉树的层序遍历
   * class Node {
   *     public int val;
   *     public List<Node> children;
   *     public Node() {}
   *     public Node(int _val) {
   *         val = _val;
   *     }
   *     public Node(int _val, List<Node> _children) {
   *         val = _val;
   *         children = _children;
   *     }
   * };
   */
  class Solution {
    	//递归实现 ⭐️  
      public List<List<Integer>> levelOrder(Node root) {
          List<List<Integer>> result = new ArrayList<List<Integer>>();
          return helper(root,0,result);
      }
  
      public List<List<Integer>> helper(Node node, int depth, List<List<Integer>> result) {
          if (node == null) 
              return result;
          if (result.size() < depth+1) {
              result.add(new ArrayList<>());
          }
          result.get(depth).add(node.val);
         
          //对其子节点使用递归 dirll down
          for (Node child: node.children) {
              helper(child, depth+1,result);
          }
          return result;
      }
  
    	//非递归  借助队列
    	 public List<List<Integer>> levelOrder(Node root) {
          List<List<Integer>> result = new ArrayList<List<Integer>>();
          if (root == null) return result;
          Queue<Node> queue = new LinkedList<Node>();
          queue.add(root);
          while (!queue.isEmpty()) {
              //外层循环为一层
              List<Integer> list = new ArrayList<>();
              int queueSize = queue.size();
              while(queueSize-- > 0) {
                  //子节点入队列
                  Node head = queue.poll();
                  list.add(head.val);
                  for (Node child: head.children) {
                      queue.add(child);
                  }
              }
              result.add(list);
          }
          return result;
      }
    	
  }
  ```

- https://leetcode-cn.com/problems/climbing-stairs/

  ```java
  /**
   * 爬楼梯
   * 方式一、 使用递归
   * 方式二、 初始化3个值,每次修改前2个值,第三个值等于前两个值只和
   * 
   */
  class Solution {
      public int climbStairs(int n) {
              // if (n <= 2) {
              //     return n;
              // }
              // return climbStairs(n - 1) + climbStairs(n - 2);  
              if(n <= 2) {
                  return n;
              }  
              int step_one = 1;
              int step_two = 2;
              
              int step_three = 0;
              for (int i = 3 ; i <= n ;i++) {
                  step_three = step_two + step_one;
                  step_one = step_two;
                  step_two = step_three;
              } 
              return step_three;
      }
  
  }
  ```

- https://leetcode-cn.com/problems/generate-parentheses/

  ```java
  /**
   * 括号生成
   * 算法重点: 如果我们还剩一个位置，我们可以开始放一个左括号。 
   * 					如果它不超过左括号的数量，我们可以放一个右括号。
   *
   */
  class Solution {
      public List<String> generateParenthesis(int n) {
          List<String> result = new ArrayList<>();
          backtrack(result,"",0,0,n);
          return result;
      }
  
      public void backtrack(List<String> result,String cur,int open,int close,int max) {
          //termination
          if (cur.length() == max*2) {
              result.add(cur);
              return;
          }
          //process 其实就是open + 1或者close +1 cur+( 或者cur+)
          //drill down
          if (open < max) {
              backtrack(result,cur+"(",open + 1,close,max);
          }
          if (close < open) {
              backtrack(result,cur+")",open,close+1,max);
          }
          //reverse state
      }
  }
  ```

- https://leetcode-cn.com/problems/invert-binary-tree/description/

  ```java
  /**
   * 反转二叉树
   * public class TreeNode {
   *     int val;
   *     TreeNode left;
   *     TreeNode right;
   *     TreeNode(int x) { val = x; }
   * }
   */
  class Solution {
      //递归
      public TreeNode invertTree(TreeNode root) {
          if (root == null) return null;
          TreeNode left = invertTree(root.left);
          TreeNode right = invertTree(root.right);
          root.left = right;
          root.right = left;
          return root;
      }
      //非递归
      public TreeNode invertTree(TreeNode root) {
          if (root == null) return null;
          Queue<TreeNode> queue = new LinkedList<TreeNode>();
          queue.add(root);
          while (!queue.isEmpty()) {
              TreeNode temp = queue.poll();
              TreeNode left = temp.left;
              temp.left = temp.right;
              temp.right = left;
              if (temp.left != null) 
                  queue.add(temp.left);
              if (temp.right != null)
                  queue.add(temp.right);
          }
          return root;
      }
  
  }
  ```

- https://leetcode-cn.com/problems/maximum-depth-of-binary-tree

  ```java
  /**
   * 二叉树的最大深度
   * public class TreeNode {
   *     int val;
   *     TreeNode left;
   *     TreeNode right;
   *     TreeNode(int x) { val = x; }
   * }
   */
  class Solution {
      //递归: 中心思想就是: max(左子树,右子树) + 1
      public int maxDepth(TreeNode root) {
          //termnition
          if (root == null) return 0;
          //dirll down
          int left = maxDepth(root.left);
          int right = maxDepth(root.right);
          //process
          return java.lang.Math.max(left,right) + 1;
      }
    	//非递归 核型思想: 全局变量max用于存放返回结果,每次遍历改变max的值,
    	//							 定义2个栈存放一个用于存放所有节点,一个用于存放节点的深度
      public int maxDepth(TreeNode root) {
          if (root == null) return 0;
          int max = 1;
          Stack<TreeNode> nodes = new Stack<TreeNode>();
          Stack<Integer> depths = new Stack<Integer>();
          nodes.push(root);
          depths.push(1);
          while (!nodes.empty()) {
              TreeNode cur = nodes.pop();
              int depth = depths.pop();
  
              if (cur.left == null && cur.right == null) {
                  max = java.lang.Math.max(max,depth);
              }
  
              if (cur.left != null) {
                  nodes.push(cur.left);
                  depths.push(depth+1);
              }
              if (cur.right != null) {
                  nodes.push(cur.right);
                  depths.push(depth+1);
              }
          }
          return max;
      }
  }
  ```

- https://leetcode-cn.com/problems/minimum-depth-of-binary-tree

  ```java
  /**
   * 二叉树的最小深度
   * 
   * public class TreeNode {
   *     int val;
   *     TreeNode left;
   *     TreeNode right;
   *     TreeNode(int x) { val = x; }
   * }
   *
   * 边界条件eg.
   *     3 
   *    / \
   *   9   20
   *  /   /  \
   * 8   15   7
   */
  class Solution {
      //递归
      public int minDepth(TreeNode root) {
          if (root == null) return 0;
          int left  = minDepth(root.left);
          int right = minDepth(root.right);
          //说明: 叶子节点是没有在子节点的节点(既没有左子节点,又没有右子节点)
          //     所以此边界条件的意思就是返回非空子节点的最小深度
          if (left == 0 || right == 0) //注意边界条件
              return left + right + 1;
          else     
              return java.lang.Math.min(left, right) + 1;
      }
     //非递归: 借助队列 (类似BFS)
      public int minDepth(TreeNode root) {
          //限制条件
          if (root == null) 
              return 0;
          Queue<TreeNode> queue = new LinkedList<TreeNode>();
          queue.add(root);
          int level = 1;
          while (!queue.isEmpty()) {
              int size = queue.size(); //当前层的元素的个数
              while (size > 0) {
                  TreeNode node = queue.poll();
                  if (node.left == null && node.right == null) {
                      return level;
                  }
                  if (node.left != null)
                      queue.add(node.left); 
                  if (node.right != null)
                      queue.add(node.right);
                  size--;
              }
              level++;
          }
          return level;
      }
  
  }
  ```

- https://leetcode-cn.com/problems/group-anagrams/

  ```java
  /**
   * 字母异位词分组
   * 1. 方式一、借助hash表,将字符数组中的元素排序之后当作key入map,值为未排序的元素的集合
   *    time complexity O(nklogk)  n表示的是Strs字符串数组的所有元素,每个元素的排序klogk   
   *    space complexity O(nk)   O(NK)，排序存储在 ls 中的全部信息内容。  
   *
   */
  class Solution {
      public List<List<String>> groupAnagrams(String[] strs) {
         Map<String,List<String>> map = new HashMap<String,List<String>>();
  
          for (String str: strs) {
              char[] chars = str.toCharArray();
              Arrays.sort(chars);
              String charStr = String.valueOf(chars);
              if (map.containsKey(charStr)) {
                  map.get(charStr).add(str);
              }else {
                  List<String> ls = new ArrayList<>();
                  ls.add(str);
                  map.put(charStr,ls);
              }
          }
  
          return new ArrayList<>(map.values());
      }
  }
  ```

- https://leetcode-cn.com/problems/permutations/

  ```java
  /**
   *
   * 全排列 
   * 参考: https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china
   *
   *  
   *
   *
   */
  class Solution {
  
      //执行用时 :2 ms, 在所有 Java 提交中击败了60.71%的用户
      public List<List<Integer>> permute(int[] nums) { //permute : 重新排列
          List<List<Integer>> result = new ArrayList<>();//存放所有结果
          LinkedList<Integer> path = new LinkedList<Integer>(); //存放一次排列[1,2,3]
          boolean[] visited = new boolean[nums.length];
          backtrack(nums,result,path,visited);
          return result; 
      }
  
      public void backtrack(int[] nums,List<List<Integer>> result,LinkedList<Integer> path,boolean[] visited){
          //1. 选择结束的条件
          if (nums.length == path.size()) {
              result.add(new ArrayList<>(path));
              return;
          } 
          //2. 做选择
          for (int i = 0; i < nums.length; i++) {
              if (visited[i] == true) continue;
              path.add(nums[i]);
              visited[i] = true;
              backtrack(nums,result,path,visited);
              //特别注意需要重置result
              visited[i] = false;
              path.removeLast();
          }
      }
  
   }
  ```

- https://leetcode-cn.com/problems/permutations-ii/

  ```java
  /**
   *
   * 全排列 ||
   *
   */
  class Solution {
      public List<List<Integer>> permuteUnique(int[] nums) {
          //特别需要注意: nums一定要排序否则下变执行nums[i] == nums[i-1]做判断的时候会出错
          Arrays.sort(nums);
  
          //定义一个存放结果的集合
          List<List<Integer>> result = new ArrayList<List<Integer>>();
          //定义一个一趟结果的存放的集合,为方便状态重置,建议使用Deque或者LinkedList , 
          //不推荐使用Stack,java自己的人员都不再使用Stack
          Deque<Integer> stack = new ArrayDeque<>();
          //定义一个数组,确定nums中的数字是否被使用过 0 未使用过,1 使用过
          int[] used = new int[nums.length];
          dfs(nums,result,stack,used);
          return result;
      }
  
      public void dfs(int[] nums,List<List<Integer>> result,Deque<Integer> stack,int[] used){
          //termination
          if (stack.size() == nums.length) {
              result.add(new ArrayList<>(stack));
              return;
          }
  
          //process
          for (int i = 0; i < nums.length; i++) {
              if (used[i] == 1)  continue;
              //减枝
              if (i > 0 && nums[i] == nums[i-1] && used[i-1] == 1) continue;
  
              stack.add(nums[i]);
              used[i] = 1;
              //drill down
              dfs(nums,result,stack,used);
              //reverse state
              used[i] = 0;
              stack.removeLast();
          }
  
      }
  
  }
  ```

- https://leetcode-cn.com/problems/combinations/

  ```java
  
  ```

- https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/

  ```java
  
  ```

- https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal

  ```
  
  ```

- ⭐️  https://leetcode-cn.com/problems/validate-binary-search-tree

  ```java
  
  ```

- ⭐️https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/

  ```
  
  ```

  

## 分治和回溯相关

- https://leetcode-cn.com/problems/powx-n/
- https://leetcode-cn.com/problems/subsets/

- [https://leetcode-cn.com/problems/majority-element/description/ ](https://leetcode-cn.com/problems/majority-element/description/)（简单、但是高频）
- https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
- https://leetcode-cn.com/problems/n-queens/

## DFS、BFS

- https://leetcode-cn.com/problems/binary-tree-level-order-traversal/#/description
- https://leetcode-cn.com/problems/minimum-genetic-mutation/#/description
- https://leetcode-cn.com/problems/generate-parentheses/#/description
- https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/#/description

- https://leetcode-cn.com/problems/word-ladder/description/
- https://leetcode-cn.com/problems/word-ladder-ii/description/
- https://leetcode-cn.com/problems/number-of-islands/
- https://leetcode-cn.com/problems/minesweeper/description/

## 贪心算法

- [coin change 题目](https://leetcode-cn.com/problems/coin-change/)

- https://leetcode-cn.com/problems/lemonade-change/description/
- https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
- https://leetcode-cn.com/problems/assign-cookies/description/
- https://leetcode-cn.com/problems/walking-robot-simulation/description/
- [https://leetcode-cn.com/problems/jump-game/ ](https://leetcode-cn.com/problems/jump-game/)
- [ https://leetcode-cn.com/problems/jump-game-ii/](https://leetcode-cn.com/problems/jump-game-ii/)

## 二分查找

- https://leetcode-cn.com/problems/sqrtx/
- https://leetcode-cn.com/problems/valid-perfect-square/

- https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
- https://leetcode-cn.com/problems/search-a-2d-matrix/
- https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/

## 动态规划

- https://leetcode-cn.com/problems/longest-common-subsequence/
- https://leetcode-cn.com/problems/unique-paths/
- https://leetcode-cn.com/problems/unique-paths-ii/
- https://leetcode-cn.com/problems/climbing-stairs/description/
- https://leetcode-cn.com/problems/triangle/description/
- https://leetcode.com/problems/triangle/discuss/38735/Python-easy-to-understand-solutions-(top-down-bottom-up)
- https://leetcode-cn.com/problems/maximum-subarray/
- https://leetcode-cn.com/problems/maximum-product-subarray/description/
- [https://leetcode-cn.com/problems/coin-change/description/](https://leetcode.com/problems/coin-change/description/)
- https://leetcode-cn.com/problems/climbing-stairs/description/
- https://leetcode-cn.com/problems/triangle/description/
- https://leetcode.com/problems/triangle/discuss/38735/Python-easy-to-understand-solutions-(top-down-bottom-up)
- https://leetcode-cn.com/problems/maximum-subarray/
- https://leetcode-cn.com/problems/maximum-product-subarray/description/
- [https://leetcode-cn.com/problems/coin-change/description/](https://leetcode.com/problems/coin-change/description/)
- https://leetcode-cn.com/problems/house-robber/
- https://leetcode-cn.com/problems/house-robber-ii/description/
- https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/#/description
- https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
- https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
- https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
- https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
- https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
- https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/

- https://leetcode-cn.com/problems/minimum-path-sum/
- https://leetcode-cn.com/problems/decode-ways
- https://leetcode-cn.com/problems/maximal-square/
- https://leetcode-cn.com/problems/task-scheduler/
- https://leetcode-cn.com/problems/palindromic-substrings/

- https://leetcode-cn.com/problems/longest-valid-parentheses/

- https://leetcode-cn.com/problems/edit-distance/

- https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/

- https://leetcode-cn.com/problems/frog-jump/

- https://leetcode-cn.com/problems/split-array-largest-sum

- https://leetcode-cn.com/problems/student-attendance-record-ii/

- https://leetcode-cn.com/problems/minimum-window-substring/

- https://leetcode-cn.com/problems/burst-balloons/

- ## 高级 DP 实战题目

- https://leetcode-cn.com/problems/perfect-squares/

- [https://leetcode-cn.com/problems/edit-distance/ ](https://leetcode-cn.com/problems/edit-distance/)（重点）

- https://leetcode-cn.com/problems/jump-game/

- https://leetcode-cn.com/problems/jump-game-ii/

- https://leetcode-cn.com/problems/unique-paths/

- https://leetcode-cn.com/problems/unique-paths-ii/

- https://leetcode-cn.com/problems/unique-paths-iii/

- https://leetcode-cn.com/problems/coin-change/

- https://leetcode-cn.com/problems/coin-change-2/















## 代码模板总结:

1. 递归代码模版

   ```java
   public void recur(int level, int param) { 
     // terminator 
     if (level > MAX_LEVEL) { 
       // process result 
       return; 
     } 
     
     // process current logic 
     process(level, param); 
   
     // drill down 
     recur( level: level + 1, newParam); 
   
     // restore current status 
   }
   ```

2. 分治代码模板

   ```python
   def divide_conquer(problem, param1, param2, ...): 
     # recursion terminator 
     if problem is None: 
   	print_result 
   	return 
   
     # prepare data 
     data = prepare_data(problem) 
     subproblems = split_problem(problem, data) 
   
     # conquer subproblems 
     subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
     subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
     subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
     …
   
     # process and generate the final result 
     result = process_result(subresult1, subresult2, subresult3, …)
   	
     # revert the current level states
   ```

3. 深度优先代码模板DFS

   a. 递归方式

   ```python
   def divide_conquer(problem, param1, param2, ...): 
     # recursion terminator 
     if problem is None: 
   	print_result 
   	return 
   
     # prepare data 
     data = prepare_data(problem) 
     subproblems = split_problem(problem, data) 
   
     # conquer subproblems 
     subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
     subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
     subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
     …
     # process and generate the final result 
     result = process_result(subresult1, subresult2, subresult3, …)
   	
     # revert the current level states
   ```

   b. 非递归方式

   ```python
   def DFS(self, tree): 
   
   	if tree.root is None: 
   		return [] 
   
   	visited, stack = [], [tree.root]
   
   	while stack: 
   		node = stack.pop() 
   		visited.add(node)
   
   		process (node) 
   		nodes = generate_related_nodes(node) 
   		stack.push(nodes) 
   
   	# other processing work 
   	...
   ```

   

4. 广度优先代码模板BFS

   ```python
   def BFS(graph, start, end):
       visited = set()
   	queue = [] 
   	queue.append([start]) 
   
   	while queue: 
   		node = queue.pop() 
   		visited.add(node)
   
   		process(node) 
   		nodes = generate_related_nodes(node) 
   		queue.push(nodes)
   
   	# other processing work 
   	...
   ```

5. 二分查找代码模板

   ```java
   left, right = 0, len(array) - 1 
   while left <= right: 
   	  mid = (left + right) / 2 
   	  if array[mid] == target: 
   		    # find the target!! 
   		    break or return result 
   	  elif array[mid] < target: 
   		    left = mid + 1 
   	  else: 
   		    right = mid - 1
   ```

6. 动态规划步骤

   ```
   a. 子问题(分治)
   b. 状态数组定义
   c. DP方程
   ```

   