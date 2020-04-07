// https://leetcode-cn.com/problems/decode-ways/

const numDecodings = function (s) {
    if (!s) {
        return 0;
    }
    let dp = Array(s.length + 1).fill(0);
    dp[0] = 1;
    dp[1] = s[0] === '0' ? 0 : 1;
    for (let i = 2; i <= s.length; i++) {
        let oneDigit = Number(s[i - 1]);
        let twoDigits = Number(s.substring(i - 2, i));
        if (oneDigit >= 1 && oneDigit <= 9) {
            dp[i] += dp[i - 1];
        }
        if (twoDigits >= 10 && twoDigits <= 26) {
            dp[i] += dp[i - 2];
        }
    }
    return dp[s.length];
};