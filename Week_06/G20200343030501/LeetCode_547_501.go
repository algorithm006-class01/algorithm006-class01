package G20200343030501

import "fmt"

func findCircleNum(M [][]int) int {
	rowLength := len(M)
	if rowLength == 0 {
		return 0
	}
	relationHead := make([]int, rowLength)
	for k := 0; k < rowLength; k++ {
		relationHead[k] = -1
	}
	for i := 0; i < rowLength; i++ {
		for j := 0; j < rowLength; j++ {
			if M[i][j] == 0 {
				continue
			}
			if relationHead[i] != -1 {
				fix(relationHead[i], j, relationHead)
			}
			fix(i, j, relationHead)
		}
	}

	for _, value := range relationHead {
		fmt.Printf("%d \n", value)
	}

	count := 0
	memo := make([]int, rowLength)
	for index := 0; index < rowLength; index++ {
		if relationHead[index] == -1 {
			continue
		}
		temp := index
		for {
			if relationHead[temp] == temp {
				if memo[temp] == 0 {
					count += 1
					memo[temp] = 1
				}
				break
			}
			temp = relationHead[temp]
		}
	}

	return count
}

func fix(i int, j int, container []int) {
	last := j
	for {
		if container[last] == last || container[last] == -1 {
			break
		}
		last = container[last]
	}
	container[i] = last
}
