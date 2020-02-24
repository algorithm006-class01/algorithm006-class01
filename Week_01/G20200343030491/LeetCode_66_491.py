import math

def plusOneRec(digits):
    if not digits:
        digits = [0]
    if digits[-1] != 9:
        digits[-1] += 1
        return digits
    return plusOneRec(digits[:len(digits)-1]) + [0]
    
def plusOne(digits):
    n = len(digits)
    for i in range(n):
        if digits[n-i-1]<9:
            digits[n-i-1] += 1
            return digits
        digits[n-i-1] = 0

    digits[0] = 1
    digits.append(0)
    return digits