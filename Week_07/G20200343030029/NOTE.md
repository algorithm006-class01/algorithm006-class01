#排序方法整理
***
* 冒泡排序

    * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
    * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
    * 针对所有的元素重复以上的步骤，除了最后一个；
    * 重复 1 2 3步骤
    
    ```
    public static int[] bubbleSort(int [] array) {
        for(int i = 1; i < array.length; i++) {
            for(int j = 0; j < array.length - i; j++) {
                if(array[j] > array [j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
    ```
  
***

* 选择排序
    * 初始状态：无序区为R[1..n]，有序区为空；
    * 第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
    * n-1趟结束，数组有序化了。
    
    ```
  public static int[] selectionSort(int[] array) {
  		for(int i = 0; i < array.length; i++) {
  			int minIndex = i;
  			for(int j = i; j < array.length - 1; j++) {
  				if(array[j] > array[j + 1]) {
  					minIndex = j + 1;
  				}
  			}
  			int temp = array[i];
  			array[i] = array[minIndex];
  			array[minIndex] = temp;
  		}
  		return array;
  	}
    ```
  
 ***
  
  * 插入排序
    * 从第一个元素开始，该元素可以认为已经被排序；
    * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
    * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
    * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
    * 将新元素插入到该位置后；
    * 重复步骤2~5。
    
    ```
    public static int[] insertSort(int[] array) {
        int preIndex, current;
        for(int i = 1; i < array.length; i++) {
            preIndex = i - 1;
            current = array[i];
            while (preIndex >= 0 && array[preIndex] > current) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }
```