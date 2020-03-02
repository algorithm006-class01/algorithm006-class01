/**
455. 分发饼干
*/


var findContentChildren = (g, s) => {
  g.sort((a,b)=>a-b)
  s.sort((a,b)=>a-b)
  let len = g.length
  while (s.length) {
    if (s.shift() >= g[0]) g.shift()
  }
  return len - g.length
};