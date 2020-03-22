package main

import "sort"

func leastInterval(tasks []byte, n int) int {
	data := make([]int, 26)
	for _, v := range tasks {
		data[v-'A']++
	}
	sort.Ints(data)
	duration := 0
	for data[25] > 0{
		i := 0
		for i<=n {
			if data[25] == 0 {
				break
			}
			if i<26 && data[25-i] > 0 {
				data[25-i]--
			}
			duration++
			i++
		}
		sort.Ints(data)
	}
	return duration
}
