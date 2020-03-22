class Solution:
    # def myPow(self, x: float, n: int) -> float:
    #     if n > 0:
    #         return self.__help(x, n)
    #     elif n == 0:
    #         return 1
    #     else:
    #         return self.__help(1/x, -n)
    #
    # def __help(self, x: float, n: int) -> float:
    #     if n == 1:
    #         return x
    #     elif n & 1:
    #         return x * self.__help(x, n - 1)
    #     elif not n & 1:
    #         return self.__help(x * x, n //2)

    def myPow(self, x: float, n: int) -> float:
        return x ** n
        # if not n:
        #     return 1
        # if n < 0:
        #     return 1 / self.myPow(x, -n)
        # if n % 2:
        #     return x * self.myPow(x, n - 1)
        # return self.myPow(x * x, n // 2)


x = 2.1
n = 3
aa = Solution()
print(aa.myPow(x, n))