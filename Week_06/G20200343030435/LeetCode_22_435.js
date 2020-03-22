let generateParenthesis = function(n) {
  const result = [];
  const _generate = (left, right, n, str) => {
    // terminator
    if (left === n && right === n) {
      // filter the invalid str
      //1、left 随时加，不能超n
      //2、right 必须之前有左括号 && 左括号个数 > 右括号个数
      console.log(str);
      result.push(str);
      return;
    }
    // process
    // var s1 = s +'(';
    // var s2 = s + ')';
    // drill down
    if (left < n) {
      // 加一个左括号
      _generate(left + 1, right, n, str + "(");
    }
    if (left > right) {
      // 加一个右括号
      // 此处 right 一定小于 n 因为 left 小于 n
      _generate(left, right + 1, n, str + ")");
    }
    // reverse states
    // 没有全局变量所以忽略局部变量它自动会最后清除
  };
  _generate(0, 0, n, "");
  return result;
};
