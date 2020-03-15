# f(n) = max(f(n-2)+V(n),f(n-1))

def rob(nums):
    def f(n, ns):
        if n == 0:
            return ns[0]
        if n == 1:
            return max(ns[0], ns[1])
        return max(f(n - 2, ns) + ns[n], f(n - 1, ns))

    return f(len(nums) - 1, nums)


print(rob([1, 2, 3, 1]))
print(rob([2, 7, 9, 3, 1]))
