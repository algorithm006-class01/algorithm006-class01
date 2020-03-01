# 学习笔记

## 寻找一个半有序数组中间无序的地方

### 1. 分析思路

- 已知条件：
  1. 数组有序，旋转后两半分别有序
  2. 旋转点具备以下特征，即旋转点是当前数组最大的元素
     1. 旋转点前存在两种可能
        1. 数据有序，小于旋转点；
        2. 无数据，为数组第一个元素；
     2. 旋转点后存在数据，与旋转点之间无序，小于旋转点；
- 样例数据：4, 5, 6, 7, 0, 1, 2

### 2. 解题思路

#### 2.1 暴力解题法

- 根据分析思路，只需遍历一次数组，找到第一个大于后一个值的元素即可；

  ```java
  		// 边界条件
          if (null == testCase || testCase.length == 0) {
              return -1;
          }
          // 循环判断数据大小
          for (int i = 0; i < testCase.length - 1; i++) {
              if (i == testCase.length - 1){
                  return -1;
              }
              if (testCase[i] > testCase[i + 1]) {
                  return i;
              }
          }
          return -1;
  ```
#### 2.2 二分查找法

- 使用二分查找法，根据旋转点位置，存在两种可能性：

  1. 旋转点位于mid或者左侧，此时：
     1. mid小于low
     2. high移动至左侧区间，`high = mid - 1`;
  2. 旋转点位于mid右侧：
     1. mid大于low
     2. left移动至右侧区间，`left= mid + 1`;

- 结合旋转点的特点：旋转点所在区间中，第一个大于后一个值的元素，每次二分比较mid值；

  ```java
  		// 边界条件
          if (null == testCase || testCase.length == 0) {
              return -1;
          }
          int low = 0;
          int high = testCase.length - 1;
          while (low <= high) {
              int mid = low + (high - low) / 2;
              if (testCase[mid] > testCase[mid + 1]) {
                  return mid;
              }
              if (testCase[mid] < testCase[mid - 1]) {
                  return mid - 1;
              }
              // 右侧有序，移动右边界至左侧区间
              if (testCase[mid] < testCase[low]) {
                  high = mid - 1;
              } else { // 左侧有序，移动右边界至右侧区间
                  low = mid + 1;
              }
          }
          return -1;
  ```

  