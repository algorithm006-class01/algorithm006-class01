// 22. 括号生成  https://leetcode-cn.com/problems/generate-parentheses/

var generateParenthesis = function(n) {
  let res = [];
  //  cur :当前字符  left：当前字符左括号 right:当前字符右括号
  const help = (cur, left, right) => {
    if (cur.length === 2 * n) {
      res.push(cur);
      return;
    }
    if (left < n) {
      help(cur + "(", left + 1, right);
    }
    if (right < left) {
      help(cur + ")", left, right + 1);
    }
  };
  help("", 0, 0);
  return res;
};

// n = 3
var n = 3;

console.log(generateParenthesis(n));
