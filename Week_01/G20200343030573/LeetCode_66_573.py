class Solution(object):
    def plusOne(self, digits):
        length = len(digits) - 1
        while digits[length] == 9:
            digits[length] = 0
            length -= 1
        if (length < 0):
            digits = [1] + digits
        else:
            digits[length] += 1
        return digits
