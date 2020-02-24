class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        num = 0
        for i in range(len(digits)):
            num += digits[i] * pow(10, (len(digits) - i - 1))
        return [int(i) for i in str(num + 1)]