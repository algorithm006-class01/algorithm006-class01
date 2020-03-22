package main

import "math"

func maxSumSubmatrix(matrix [][]int, k int) int {
	if len(matrix) == 0 || len(matrix[0]) == 0 {
		return 0
	}

	ans := math.MinInt32
	for l := 0; l < len(matrix[0]); l++ {
		rowSum := make([]int, len(matrix))
		for r := l; r < len(matrix[0]); r++ {
			for i := 0; i < len(matrix); i++ {
				rowSum[i] += matrix[i][r]
			}

			sum := []int{0}
			tot := 0
			for i := 0; i < len(matrix); i++ {
				tot += rowSum[i]
				left, right := 0, len(sum)-1
				for left <= right {
					mid := (left + right) / 2
					if tot-sum[mid] == k {
						return k
					} else if tot-sum[mid] > k {
						left = mid + 1
					} else {
						right = mid - 1
						if ans < tot-sum[mid] {
							ans = tot - sum[mid]
						}
					}
				}

				left, right = 0, len(sum)-1
				for left <= right {
					mid := (left + right) / 2
					if tot <= sum[mid] {
						right = mid - 1
					} else {
						left = mid + 1
					}
				}

				if left == len(sum) {
					sum = append(sum, tot)
				} else {
					if sum[left] == tot {
						continue
					}

					cp := append([]int{}, sum[left:]...)
					sum = append(sum[:left], tot)
					sum = append(sum, cp...)
				}
			}
		}
	}
	return ans
}
