// 暴力法
function twoSum1(arr, target) {
  const len = arr.length
  for (let i = 0; i < len - 1; i++) {
    for (let j = i + 1; j < len; j++) {
      if (arr[i] + arr[j] === target) {
        return [i, j]
      }
    }
  }
  return []
}

// 第一次遍历把所有元素存进map中，然后判断差值是否存在map中
function twoSum2(arr, target) {
  const len = arr.length
  const map = new Map()
  for (let i = 0; i < len; i++) {
    map.set(arr[i], i)
  }
  for (let i = 0; i < len - 1; i++) {
    if (map.has(target - arr[i]) && map.get(target - arr[i]) !== i) {
      return [i, map.get(target - arr[i])]
    }
  }
  return []
}

// 优化上方代码直接一遍循环，不存在就存，但是这里第二部循环需要到len
function twoSum3(arr, target) {
  const map = new Map()
  for (let i = 0; i < len; i++) {
    if (map.has(target - arr[i]) && map.get(target - arr[i]) !== i) {
      return [i, map.get(target - arr[i])]
    }
    map.set(arr[i], i)
  }
  return []
}
