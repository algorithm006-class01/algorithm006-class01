# 学习笔记
## Bloom Filters
* 空间效率、查询性能远远超过一般算法，如hash；
* 可以判断对象是否不存在，但不能完全确定是否存在；
* 应用在数据库、分布式系统的缓存层场景；
### 代码示例
```python
from bitarray import bitarray 
import mmh3 

class BloomFilter: 
	def __init__(self, size, hash_num): 
		self.size = size 
		self.hash_num = hash_num 
		self.bit_array = bitarray(size) 
		self.bit_array.setall(0) 

	def add(self, s): 
		for seed in range(self.hash_num): 
			result = mmh3.hash(s, seed) % self.size 
			self.bit_array[result] = 1 

	def lookup(self, s): 
		for seed in range(self.hash_num): 
			result = mmh3.hash(s, seed) % self.size 
			if self.bit_array[result] == 0: 
				return "Nope" 
		return "Probably" 

bf = BloomFilter(500000, 7) 
bf.add("dantezhao") 
print (bf.lookup("dantezhao")) 
print (bf.lookup("yyj")) 
```

## LRU cache
* 最近最少使用（读或写）的就放到最后，超出缓存大小限制时，淘汰掉最后的；
* Hash Table(hash表) + Double Linkedlist(双向链表) 实现；
* 查询O(1)，修改O(1)

## 排序
###  归并排序
* 每次将数组分为左右两部分，分别排序后再merge；
* merge需要额外的存储空间

### 快速排序
* 每次取priot，通过partition将数组分为左边小于priot的部分，右边大于priot的部分，最终整个数组有序；
* partition的空间复杂度为O(1)
