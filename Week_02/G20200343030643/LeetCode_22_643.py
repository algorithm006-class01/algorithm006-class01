class Solution(object):
    def generateParenthesis(self, n):
        ans = []
        def helper(left, right, n, s):
            if (left == n and right == n):
                ans.append(s)
                return
            
            if (left < n):
                helper(left + 1, right, n, s + '(')

            if (right < left):
                helper(left, right + 1, n, s + ')')

        helper(0,0,n,'')
        return ans
