let groupAnagrams = function(strs) {
  let hash = new Map();
  for (let i = 0; i < strs.length; i++) {
    const str = strs[i]
      .split("")
      .sort()
      .join();
    if (hash.has(str)) {
      const tmp = hash.get(str);
      tmp.push(strs[i]);
      hash.set(str, tmp);
    } else {
      hash.set(str, [strs[i]]);
    }
  }
  return [...hash.values()];
};
