let longestCommonSubsequence = function(text1, text2) {
  const n = text1.length;
  const m = text2.length;
  const lcs = Array.from(new Array(n + 1), () => new Array(m + 1).fill(0));
  for (let i = 1; i <= n; i++) {
    for (let j = 1; j <= m; j++) {
      if (text1[i - 1] === text2[j - 1]) {
        lcs[i][j] = lcs[i - 1][j - 1] + 1;
      } else {
        lcs[i][j] = Math.max(lcs[i][j - 1], lcs[i - 1][j]);
      }
    }
  }
  return lcs[n][m];
};
