// https://leetcode-cn.com/problems/task-scheduler/

var leastInterval = function(tasks, n) {
    if (n === 0) return tasks.length

    let map = {}
    for (let key of tasks) {
      map[key] = map[key] ? map[key] + 1 : 1
    }

    let max = 0, count = 0
    Object.keys(map).forEach(key => {
      if (map[key] > max) {
        max = map[key]
        count = 1
      } else if (map[key] === max) {
        count++
      }
    })
    return Math.max((max - 1) * (n + 1) + count, tasks.length)
  };