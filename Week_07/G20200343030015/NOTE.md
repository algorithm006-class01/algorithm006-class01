学习笔记

位运算公式

获取最后一位 1
	num = num & - num

去除最后一位 1
	num = num & (num - 1)

获取制定位数的1
	size = (1 << n) - 1
