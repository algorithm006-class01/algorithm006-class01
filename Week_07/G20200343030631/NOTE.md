# 学习笔记
## 第十六课 位运算

### 机器内的数字表示方式和存储个是就是二进制

### 位运算符

- 左移

	- <<

- 右移

	- >>

- 或

	- |

		- 任何一个为1，则为1

- 与

	- &

		- 两者均为1，则为1

- 反

	- ～

- 异或

	- ^

		- 相同为0，不同为1

	- 常用操作

		- x^0=x
		- x^1s

			- ~x

		- x^(^x)

			- 1s

		- x^x=0
		- c=a^b ==> a^c=b, b^c=a
		- a^b^c=a^(b^c)=(a^b)^c

### 实战位运算要点

- 判断奇偶

	- x%2==1 --> (x&1)==1
	- x%2==0 --> (x&1)==0

- 除法

	- x/2 -- > x>>1

- 清零最低位的1

	- x=x&(x-1)

- 得到最低位的1

	- x&-x

- x&~x==0

## 第十七课 布隆过滤器和LRU缓存

### 布隆过滤器

- 用于检索一个元素是否在一个集合中
- 一个很长的二进制向量和一系列随机映射函数组成
- 将插入元素通过多个映射函数，计算到多个二进制位上，将对应位置为1，查询时如果某元素对应的多个二进制位不全为1，则表示不存在集合中
- 优点

	- 空间效率和查询时间远远超过一般的算法

- 缺点

	- 有一定的误识别率
	- 删除困难

- 实际应用

	- 比特币网络
	- 分布式系统（Map-Reduce）

		- Hadoop

			- 判断在哪个节点中

		- search engine

			- 判断在哪个集群中

	- Redis缓存
	- 垃圾邮件、评论等的过滤

### LRU缓存

- 缓存的要素

  - 大小
  - 替换策略

  	- FIFO

  		- 先进先出

  	- LIFO

  		- 后进先出

  	- LRU

  		- 最近最少使用

  	- LFU

  		- 最近最少频次被使用

  	- ```
  	  
  	  ```

- HashTable+DoubleLinkedList

	- 查询 O(1)
	- 修改、更新 O(1)

## 第十八课 排序算法

### 比较类排序

- 通过比较来决定元素间的相对次序
- 时间复杂度不能突破O(nlogn)
- 被称为非线性时间比较类排序
- 常见

	- 交换排序

		- 冒泡排序
		- 快速排序

	- 插入排序

		- 简单插入排序
		- 希尔排序

	- 选择排序

		- 简单选择排序
		- 堆排序

	- 归并排序

		- 二路归并排序
		- 多路归并排序

### 非比较类排序

- 不通过比较来决定元素间的相对次序
- 常见

	- 计数排序
	- 桶排序
	- 基数排序

### 初级排序 O(n^2)

- 选择排序

	- 每次找到最小值，然后放到待排序数组的起始位置
	- 每次处理有一个当前最小元素达到其最终位置

- 插入排序

	- 从前到后逐步构建有序序列
	- 对于未排序的数据，在已排序序列中从后向前扫描，找到相应为位置并插入

- 冒泡排序

	- 嵌套循环，每次查看相邻的元素是否逆序，是则交换
	- 每次循环有一个当前最大元素达到其最终位置

### 高级排序 O(nlogn)

- 基于分治的思想
- 快速排序

	- 数组中取一个标杆元素，将小于标杆的所有元素放在左边，大于的元素放在右侧
	- 然后再次对左右子数组进行快排，最终达到整个序列有序

- 归并排序

	- 将长度为n的输入序列分为长度n/2的自序列
	- 对这两个子序列分别采用归并排序
	- 将两个排序好的子序列合并成一个最终的排序序列

- 堆排序

	- 堆插入 O(logn)
	- 取最大值、最小值 O(1)
	- 数组元素依次插入建立小顶堆
	- 子主题 4

### 特殊排序 O(n)

- 计数排序

	- 要求输入的数据必须有确定范围的整数

- 桶排序

	- 利用了函数的映射关系

- 基数排序

	- 子主题 1

# 初级排序算法
## 插入排序
```java
public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 5, 4, 44, 38, 15};
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void insertionSort(int[] nums) {
        userExtraSpace(nums); // 使用额外空间
//        inPlace(nums); // 不使用额外空间
    }

    private static void inPlace(int[] nums) {
        int length = nums.length;
        int preIndex = 0;
        int current = 0;
        for (int i = 1; i < length; i++) {
            preIndex = i - 1;
            current = nums[i];
            while (preIndex >= 0 && nums[preIndex] > current) {
                nums[preIndex + 1] = nums[preIndex];
                preIndex--;
            }
            nums[preIndex + 1] = current;
        }
    }

    private static void userExtraSpace(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int currentMinIndex = i;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[currentMinIndex]){
                    currentMinIndex = j;
                }
            }
            result[i] = nums[currentMinIndex];
            nums[currentMinIndex] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }
}
```

## 选择排序
```java
public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 5, 4, 44, 38, 15};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void selectionSort(int[] nums){
        int length = nums.length;
        int minNumIndex = 0;
        for (int i = 0; i < length; i++) {
            minNumIndex = i;
            int tmp = nums[i];
            for (int j = i + 1; j < length; j++) {
                if (nums[j] < nums[minNumIndex]){
                    minNumIndex = j;
                }
            }
            nums[i] = nums[minNumIndex];
            nums[minNumIndex] = tmp;
        }
    }
}
```

## 冒泡排序
```java
public class BuddleSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 5, 4, 44, 38, 15};
        buddleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void buddleSort(int[] nums){
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1; j++) {
                if (nums[j] > nums[j + 1]){
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }
}
```

## 快速排序
```java
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 5, 4, 44, 38, 15};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void quickSort(int[] nums) {
        quickSortInternal(nums, 0, nums.length - 1);
    }

    private static void quickSortInternal(int[] nums, int start, int end) {
        if (end <= start) {
            return;
        }

        int pivotIndex = partitionArray(nums, start, end);
        quickSortInternal(nums, start, pivotIndex - 1);
        quickSortInternal(nums, pivotIndex + 1, end);
    }

    private static int partitionArray(int[] nums, int start, int end) {
        int pivot = end; // 标杆元素
        int counter = start; // 小于nums[pivot]元素数目
        for (int i = start; i < end; i++) {
            if (nums[i] < nums[pivot]) {
                swapNum(nums, counter, i);
                counter++;
            }
        }
        swapNum(nums, pivot, counter);
        return counter;
    }

    private static void swapNum(int[] nums, int nums1, int nums2) {
        int tmp = nums[nums1];
        nums[nums1] = nums[nums2];
        nums[nums2] = tmp;
    }
}
```