// https://leetcode-cn.com/problems/friend-circles/

const findCircleNum = (M) => {
    if (!M.length) return 0
    let n = M.length, count = n
    let parent = new Array(n)
    for (let i = 0; i < n; i++) parent[i] = i
    
    const findParent = (p) => {
      while (parent[p] != p) {
        parent[p] = parent[parent[p]]
        p = parent[p]
      }
      return p
    }
    
    const union = (p, q) => {
      let rootP = findParent(p), rootQ = findParent(q)
      if (rootP === rootQ) return 
      parent[rootP] = rootQ
      count--
    }
  
    for (let i = 0; i < n; i++) {
      for (let j = 0; j < n; j++) {
        if (M[i][j] === 1) union(i, j)
      }
    }
    return count
  }