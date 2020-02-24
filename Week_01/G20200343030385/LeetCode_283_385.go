func moveZeroes(nums []int)  {
    a := 0
	b := 0
	for ; b < len(nums);b ++  {
		if nums[b] != 0  {
            c := nums[b]
			nums[a] = c
            if b > a {
                nums[b] = 0
            }
			a++
		}
	
	}
}
