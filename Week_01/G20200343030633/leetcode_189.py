# 暴力 loop K ,每次把末尾换到头位
#不知道为啥leetcode 执行的时候可以，提交后就超出限制
def baolirotate(nums, k):
    length = len(nums)
    for _ in range(k):
        previous = nums[length - 1]
        for j in range(length):
            temp = nums[j]
            nums[j] = previous
            previous = temp


# 环状替换
def rotate(nums, n):
    length = len(nums)
    k = n % length
    count = 0
    start = 0
    while count < length:
        current = start
        prev = nums[start]
        print('count:', count)
        while True:
            next = (current + k) % length
            temp = nums[next]
            nums[next] = prev
            prev = temp
            current = next
            count += 1
            if start == current:
                break
        start += 1



a = [1, 2, 3, 4, 5, 6]
k = 2
print('原始：', a)

# rotate(a, k)
baolirotate(a, k)

print('移动', k, '位后：', a)
