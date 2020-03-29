学习笔记

    位运算
        或：
            符号： |
            定义：同位只要有一个为1，或后就为1
            例子： 0011 | 1011 =》 1011
        与：
            符号： &
            定义：同位只要有一个为0，与后就为0
            例子： 0011 & 1011 =》 0011
        按位取反
            符号： ~
            定义：就是取反
            例子： 0011 ~ 1100
        异或
            符号： ^
            定义：同位相同为0，不同则为1
            例子： 0011 ^ 1011 =》1000
    
    十大经典排序算法：
        插入排序
            let insertionSort = function (arr) {
                let len = arr.length
                let preIndex, current
                for (let i = 0; i < len; i++) {
                    preIndex = i - 1
                    current = arr[i]
                    while(preIndex >= 0 && arr[preIndex] > current) {
                        arr[preIndex + 1] = arr[preIndex]
                        preIndex--
                    }
                    arr[preIndex + 1] = current
                }
                return arr
            }
        希尔排序
            let shellSort = function (arr) {
                let len = arr.length
                for (let gap = Math.floor(len / 2); gap > 0; gap = Math.floot(gap / 2)) {
                    for (let i = gap; i < len; i++) {
                        let j = i
                        let current = arr[i]
                        while (j - gap >=0 && current < arr[j - gap]) {
                            arr[j] = arr[j - gap]
                            j = j - gap
                        }
                        arr[j] = current
                    }
                }
                return arr
            }
        选择排序
            let selectionSort = function (arr) {
                let len = arr.length
                let minIndex
                for (let i = 0; i < len - 1; i++) {
                    minIndex = i;
                    for (let j = i + 1; j < len; j++) {
                        if (arr[j] < arr[minInded]) {
                            minIndex = j
                        }
                    }
                    [arr[i], arr[minIndex]] = [arr[minIndex], arr[i]]
                }
                return arr
            }
        堆排序
            let len;
            let buildMaxHeap = function (arr) {
                len = arr.length
                for (let i = Math.floor(len / 2); i >= 0; i--) {
                    heapify(arr, i)
                }
            }
            let heapify = function (arr, i) {
                let left = 2 * i + 1,
                    right = 2 * i + 2,
                    largest = i
                if(left < len && arr[left] > arr[largest]) {
                    largest = left;
                }
            
                if(right < len && arr[right] > arr[largest]) {
                    largest = right;
                }
            
                if(largest != i) {
                    [arr[i], arr[largest]] = [arr[largest], arr[i]]
                    heapify(arr, largest);
                }
            }
            let heapSort = function (arr) {
                buildMaxHep(arr)
                for (let i = arr.length - 1; i > 0; i--) {
                    [arr[0], arr[i]] = [arr[i], arr[0]]
                    len--
                    heapify(arr, 0)
                }
                return arr
            }
        冒泡排序
            let bubbleSort = function (arr) {
                let len = arr.length
                for (let i = 0; i < len -1; i++) {
                    for (let j = 0; j < len - 1 - i; j++) {
                        if (arr[j] > arr[j+1]) {
                            [arr[j], arr[j+1]] = [arr[j+1], arr[j]]
                        }
                    }
                }
                return arr
            }
        快速排序
            let quickSort = function(arr, left, right) {
                let len = arr.length,
                    partitionIndex,
                    left = typeof left != 'number' ? 0 : left,
                    right = typeof right != 'number' ? len - 1 : right
                if (left < right) {
                    partitionIndex = partition(arr, left, right)
                    quickSort(arr, left, partitionIndex - 1)
                    quickSort(arr, partitionIndex + 1, right)
                }
            }
            left partition = function (arr, left, right) {
                let pivot = left,
                    index = pivot = 1
                for (let i = index; i <= right; i++) {
                    if (arr[i] < arr[pivot]) {
                        [arr[i], arr[index]] = [arr[index], arr[i]]
                        index++
                    }
                }
                swap(arr, pivot, index-1)
                [arr[pivot], arr[index - 1]] = [arr[index - 1], arr[pivot]]
                return index - 1
            }
        归并排序
            let mergeSort = function (arr) {
                let len = arr.length
                if (let < 2) {
                    return arr
                }
                let middle = Math.floor(len / 2),
                    left = arr.slice(0, middle),
                    right = arr.slice(middle)
                return merge(mergeSort(left), mergeSort(right))
            }
            let merge = function (left, right) {
                let result = []
                while (left.length > 0 && right.length > 0) {
                    if (left[0] <= right[0]) {
                        result.push(left.shift())
                    } else {
                        result.push(right.shift())
                    }
                }
                while (left.length) {
                    result.push(left.shift())
                }
                while (right.length) {
                    result.push(right.shift())
                }
                return result
            }

        计数排序
            function countingSort = function (arr, maxValue) {
                let bucket = newArray(maxValue + 1),
                    sortedIndex = 0;
                    arrLen = arr.length,
                    bucketLen = maxValue + 1;
            
                for(let i = 0; i < arrLen; i++) {
                    if(!bucket[arr[i]]) {
                        bucket[arr[i]] = 0;
                    }
                    bucket[arr[i]]++;
                }
            
                for(let j = 0; j < bucketLen; j++) {
                    while(bucket[j] > 0) {
                        arr[sortedIndex++] = j;
                        bucket[j]--;
                    }
                }
            
                return arr;
            }
        桶排序
            let bucketSort = function (arr, bucketSize) {
                if(arr.length === 0) {
                    return arr;
                }
            
                let i;
                let minValue = arr[0];
                let maxValue = arr[0];
                for(i = 1; i < arr.length; i++) {
                    if(arr[i] < minValue) {
                        minValue = arr[i];                
                    } else if(arr[i] > maxValue) {
                        maxValue = arr[i];               
                    }
                }
            
                
                let DEFAULT_BUCKET_SIZE = 5;           
                bucketSize = bucketSize || DEFAULT_BUCKET_SIZE;
                let bucketCount = Math.floor((maxValue - minValue) / bucketSize) + 1;  
                let buckets = newArray(bucketCount);
                for(i = 0; i < buckets.length; i++) {
                    buckets[i] = [];
                }
            
                
                for(i = 0; i < arr.length; i++) {
                    buckets[Math.floor((arr[i] - minValue) / bucketSize)].push(arr[i]);
                }
            
                arr.length = 0;
                for(i = 0; i < buckets.length; i++) {
                    insertionSort(buckets[i]);                      
                    for(let j = 0; j < buckets[i].length; j++) {
                        arr.push(buckets[i][j]);                     
                    }
                }
            
                return arr;
            }
        基数排序
            let counter = [];
            let radixSort = function (arr, maxDigit) {
                let mod = 10;
                let dev = 1;
                for(let i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
                    for(let j = 0; j < arr.length; j++) {
                        let bucket = parseInt((arr[j] % mod) / dev);
                        if(counter[bucket]==null) {
                            counter[bucket] = [];
                        }
                        counter[bucket].push(arr[j]);
                    }
                    let pos = 0;
                    for(let j = 0; j < counter.length; j++) {
                        let value = null;
                        if(counter[j]!=null) {
                            while((value = counter[j].shift()) != null) {
                                arr[pos++] = value;
                            }
                    }
                    }
                }
                return arr;
            }