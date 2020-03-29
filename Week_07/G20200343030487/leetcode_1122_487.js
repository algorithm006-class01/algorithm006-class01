/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number[]}
 */
var relativeSortArray = function(arr1, arr2) {
  const res = []
  const map = {}
  arr1.forEach((item, index) => {
      map[item] ? map[item]++ : map[item] = 1
  })
  arr2.forEach((item, index) => {
      while(map[item]) {
          res.push(item)
          map[item]--
      }
  })
  for (const o in map) {
      while(map[o]) {
          res.push(o)
          map[o]--
      }
  }
  return res
};
