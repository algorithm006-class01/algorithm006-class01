# week 08
## 高级动态规划

### DP递推模版
```python=
function DP():
    dp = [][] #状态定义
    for i in range(M):
        for j in range(N):
            dp[i][j] = _function (dp[i'][j']...) #状态转移方程
            
    return dp[M][N]
```

### 股票买卖 （可结局此问题的6种变型）
![](https://i.imgur.com/YrkHLe2.png)

```python
dp[i][k][0 or 1] (0 <= i <= n-1, 1 <= k <= K)
```
* i 为天数
* k 为最多交易次数
* [0,1]为是否持有股票

总状态数：n*K*2种状态

```python=
for 0 <= i < n:
    for 1 <= k <= K:
        for s in [0,1]:
            dp[i][k][s] = max(buy,sell,rest)

# description:
# not hold stock = I didn't hold yesterday or I held yesterday but I sell today
dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1] + prices[i])
            = max(rest,sell)
            
# hold stock = I held yesterday or I didn't hold yesterday but I buy today
dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
            = max(rest, buy)
            
# Therefore
# initial status:
dp[-1][k][0] = dp[i][0][0] = 0
dp[-1][k][1] = dp[i][0][1] = -infinity

# transition:
dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1] + prices[i])
dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
```
### Edit distance
两个字符串匹配的题目，增加到二维
w1: ... x(i)
w2: ... x(j)
最后一个字符相等的情况下：
```python
edit_dist(i,j) = edit_dist(i-1,j-1)
```

w1: ... x(i)
w2: ... y(j)
最后一个字符不相等的情况下：
```python
edit_dist(i,j) = min(edit_dist(i-1,j-1) + 1, #substitute x to y
                 edit_dist(i-1,j) + 1, #delete x e.g. abcd -> abc
                 edit_dist(i,j-1)+1) #delete y
```

注意两个字符都为空和一个字符串为空一个字符串不为空的特殊情况

## 字符串
python, java, c# 的string 都是immutable的
c/c++都是mutable的

### 最长公共子序列 (注意跟公共子串不同一个概念)
```python
dp[i][j] = dp[i-1][j-1] + 1(if s1[i-1]==s2[j-1])
else dp[i][j] = max(dp[i-1][j],dp[i][j-1])
```

### 最长公共子串
```python
dp[i][j] = dp[i-1][j-1] + 1(if s1[i-1]==s2[j-1])
else dp[i][j] = 0
```
### 最长回文串
1. 嵌套循环、枚举i,j（起点和终点），判断该子串是否回文
2. 中间向两边扩张法 注意有2n+1个中心位置，因为回文长度可以为奇数也可以为偶数
3. dp[i][j] 起于i终于j，如果s[i]==s[j],且dp[i+1][j-1]是回文串，则dp[i][j]也为回文串

### 正则表达式匹配字符串
看题解

### 字符串匹配算法
#### Rabin-Karp
首先判断字符串子串与要匹配的字符串的哈希值是否相同，<br>
-> hash(txt.substring(i,N)) == hash(pat)?<br>
相同则逐个字符比较，不相同则直接跳过，进行下一个字符开始的字符串子串的比较<br>
使用滑动窗口的方法，可以O(1)更新哈希值<br>
每一位的权重->相应位的256的i次方 （第0位是256 0次方，第1位是256 1次方，etc.)再模一个素数（9997之类的）<Br>
匹配前：计算pattern的hash，计算最高位的权重（M-1个循环）<Br>
```python=
D,Q = 256,9997
for i in range(M-1):
    patHash = (D * patHash + pat[i]) % Q
highestPow = 1
for i in range(M-1):
    highestPow = (highestPow * D) % Q
```
匹配时：不相等，最高位挪去，最低位移进
```python=
if patHash != txtHash:
    txtHash = (D * (txtHash - txt[i]*highestPow) + txt[i+M]) % Q
    if txtHahs < 0:
        txtHash += Q #因为减去了数，所以有可能为负数
```
#### KMP
