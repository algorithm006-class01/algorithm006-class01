// 快慢指针
function moveZeros2(arr) {
  let slow = 0
  for (let fast = 0; fast < arr.length; fast++) {
    if (arr[fast] !== 0) {
      swap(arr, slow, fast)
      slow++
    }
  }
}

function swap(arr, i, j) {
  let temp = arr[i]
  arr[i] = arr[j]
  arr[j] = temp
}

// 用一个下标先把所有非0元素往前放，最后在将下标以及之后的位置元素置为0
function moveZeros3(arr) {
  let count = 0
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] !== 0) {
      arr[index] === arr[i]
      index++
    }
  }
  for (let i = index; i < arr.length; i++) {
    arr[i] = 0
  }
  return arr
}