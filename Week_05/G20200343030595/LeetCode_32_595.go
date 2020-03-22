package main

func longestValidParentheses(s string) int {
	dp, res := make([]int,len(s)), 0
	for i,_ := range s{
		if i > 0 &&  s[i] == ')'{
			if s[i - 1] == '('{
				if i == 1{
					dp[i] = 2
				}else{
					dp [i] = dp[i - 2] + 2
				}
			}else if s[i - 1] == ')' &&  i - dp[i - 1] - 1 >= 0   &&  s[i-dp[i-1]-1] == '('  {
				if  i - dp[i - 1] - 1 == 0{
					dp[i] = dp[i-1] + 2
				}else{
					dp[i] = dp[i-1] + 2 + dp[i-dp[i-1]-2]
				}
			}
			if dp[i] > res{
				res = dp[i]
			}
		}
	}
	return res
}
