let isAnagram = function(s, t) {
  if (s.length !== t.length) {
    return false;
  }
  for (const item of t) {
    if (s.indexOf(item) !== -1) {
      s = s.replace(item, "");
    }
  }
  return s === "";
};
