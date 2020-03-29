package main

func main() {
	isPowerOfTwo(5)
}

// 利用n & (n-1) 清除最低位的1
func isPowerOfTwo(n int) bool {
	return n != 0 && n&(n-1) == 0
}
