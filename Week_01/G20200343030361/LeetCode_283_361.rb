def move_zeroes(nums)
  noneZeroIndex = 0

  nums.each_with_index do |n, indx|
    next unless n != 0
    nums[noneZeroIndex] = n

    nums[indx] = 0 if indx != noneZeroIndex

    noneZeroIndex += 1
  end

  nums
end
