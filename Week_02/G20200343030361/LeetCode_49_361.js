var groupAnagrams = function(strs) {
  let records = {};

  for (let i = 0; i < strs.length; i++) {
    let apperanceCalculator = {};
    let splitted = strs[i].split("");

    for (char of splitted) {
      let charCode = char.charCodeAt();
      isNaN(apperanceCalculator[charCode])
        ? (apperanceCalculator[charCode] = 1)
        : (apperanceCalculator[charCode] += 1);
    }

    let startCharCode = "a".charCodeAt();
    let hashKey = "";
    for (let i = "a".charCodeAt(); i < startCharCode + 26; i++) {
      hashKey += "#";
      hashKey += apperanceCalculator[i] ? apperanceCalculator[i] : 0;
    }

    records[hashKey]
      ? records[hashKey].push(strs[i])
      : (records[hashKey] = [strs[i]]);
  }
  let result = [];
  for (key in records) {
    result.push(records[key]);
  }

  return result;
};
