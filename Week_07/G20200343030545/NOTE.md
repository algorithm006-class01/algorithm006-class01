## 冒泡排序
```text
    1. 时间复杂度：O(n ^ 2)
    2. 空间复杂度：O(1)
    3. 稳定排序
```
```python3
from typing import List

def bubble_sort(data:List)->None:
    
    data_length = len(data)

    for i in range(data_length):
        for j in range(1, data_length-i):
            if data[j]<data[j-1]:
                data[j], data[j-1] = data[j-1], data[j]
```

## 插入排序
```text
    1. 时间复杂度：O(n ^ 2)
    2. 空间复杂度：O(1)
    3. 稳定排序
```
```python3
from typing import List

def insert_sort(data:List)->None:
    data_length = len(data)
    
    for i in range(data_length):
        for j  in range(i, 0, 0):
            if data[j-1]>data[j]:
                data[j-1], data[j] = data[j], data[j-1]
            else:
                #如果j-1小于j，则已经没有必要往回比较了
                break
```

## 选择排序
```text
    1. 时间复杂度：O(n ^ 2)
    2. 空间复杂度：O(1)
    3. 不稳定排序
```
```python3
from typing import List

def select_sort(data:List)->None:
    data_length = len(data)

    for i in range(data_length):
        min_index = i
        for j in range(i, data_length):
            if data[min_index] > data[j]:
                min_index = j
        data[min_index], data[i] = data[i], data[min_index]
```


## 归并排序
```text
    1. 时间复杂度：O(nlogn)
    2. 空间复杂度：O(1)
    3. 稳定排序
```
```python3

def merge_sort(data:List)->List:
    if len(data)<2:
        return data

    mid_index = len(data) >> 1 
    right_data = merge_sort(data[:mid_index])
    left_data = merge_sort(data[mid_index:])
    return merge(left_data, right_data)

def merge(data1:List, data2:List)->List:
    res = []
    index1 = index2 = 0
    len1 = len(data1)
    len2 = len(data2)

    while index1 < len1 and index2 < len2:
        if data1[index1] > data2[index2]:
            res.append(data2[index2])
            index2 += 1
        else:
            res.append(data1[index1])
            index1 += 1
    
    res += data1[index1:]
    res += data2[index2:]
    return res
```

## 快速排序
```text
    1. 时间复杂度：O(nlogn)，最坏情况下是O(n^2)
    2. 空间复杂度：O(1)
    3. 不稳定排序
```
```python3
from typing import List

def quick_sort(data:List):
    return _quick(data, 0, len(data)-1)

def _quick(data:List, start:int, end:int):
   if start<=end:
        pivot =  partition(data, start, end)
        _quick(data, start, pivot-1)
        _quick(data, pivot+1,  end)

def partition(data:List, start:int, end:int)->int:
    index = start - 1
    target = data[end]

    for i in range(start, end):
        if data[i]<= target:
            index += 1
            data[i], data[index] = data[index], data[i]
    data[end], data[index+1] = data[index+1], data[end]
    return index + 1
```

## 堆排序
```text
    1. 时间复杂度：O(nlogn)
    2. 空间复杂度：O(1)
    3. 不稳定排序
```
```python3
# https://blog.csdn.net/minxihou/article/details/51850001

from typing import List

def heap_sort(data: List) -> None:
    data_length = len(data)
    _build_heap(data)  # 构建一个大顶堆

    for i in range(data_length - 1, -1, -1):
        data[i], data[0] = data[0], data[i]
        _hand_heap(data, i, 0)


def _hand_heap(data, size, root_index):
    left = 2 * root_index + 1
    right = 2 * root_index + 2
    target_index = root_index

    if left < size and data[target_index] < data[left]:
        target_index = left
    if right < size and data[target_index] < data[right]:
        target_index = right

    if target_index != root_index:
        data[target_index], data[root_index] = data[root_index], data[target_index]
        _hand_heap(data, size, target_index)


def _build_heap(data: List):
    data_length = len(data)
    for i in range(data_length // 2, -1, -1):
        _hand_heap(data, data_length, i)
```

## 计数排序 (只适合非负整数的排序)
```text
    1. 时间复杂度：O(n+k)
    2. 空间复杂度：O(n+k)
    3. 稳定排序
```
```python3
from typing import List

def counter_sort(data: List) -> List:
    max_num = max(data)
    res = []
    base_data = [-1] * (max_num + 1)

    for num in data:
        if base_data[num] == -1:
            base_data[num] = 1
        else:
            base_data[num] += 1

    for index, base_num in enumerate(base_data):
        while base_num > 0:
            res.append(index)
            base_num -= 1
    return res
```