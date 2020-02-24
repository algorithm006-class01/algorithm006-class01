/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
// 队列版的广度优先遍历
/**
 * @param {Node} root
 * @return {number[][]}
 */
var levelOrder1 = function (root) {
    if (!root) return []
    const res = []
    const queue = []
    queue.push(root)
    let child = null
    let size = 0
    let level = []
    while (queue.length) {
        level = []
        size = queue.length
        for (let i = 0; i < size; i++) {
            child = queue.shift()
            level.push(child.val)
            child.children.forEach(item => {
                queue.push(item)
            })
        }
        res.push(level)
    }
    return res
};

// 队列变形版的广度优先遍历
// 每个队列元素都是树的一层节点，这样能减少出队次数，因为js用数组代替队列，出队性能可能比较差
/**
 * @param {Node} root
 * @return {number[][]}
 */
var levelOrder2 = function (root) {
    if (!root) return []
    const res = []
    const queue = []
    let level = []
    let levelQueue = []
    queue.push([root])
    while (queue.length) {
        levelQueue = []
        level = queue.shift().map(item => {
            item.children.forEach(child => {
                levelQueue.push(child)
            })
            return item.val
        })
        if (levelQueue.length) {
            queue.push(levelQueue)
        }
        res.push(level)
    }
    return res
}

// 简化版的广度优先遍历
// 不使用队列，用变量的形式存储下一层树要处理的所有子节点
/**
 * @param {Node} root
 * @return {number[][]}
 */
var levelOrder3 = function (root) {
    if (!root) return []
    const res = []
    let currentLayer = [root]
    let nextLayer = []
    let level = []
    while (currentLayer.length) {
        nextLayer = []
        level = []
        currentLayer.forEach(item => {
            level.push(item.val)
            item.children.forEach(child => {
                nextLayer.push(child)
            })
        })
        res.push(level)
        currentLayer = nextLayer
    }
    return res
}

// 递归方法
// 找到最近最少重复的环节：先遍历根，再遍历children
/**
 * @param {Node} root
 * @return {number[][]}
 */
var levelOrder = function (root) {
    if (!root) return []
    const helper = function (root, levelIndex, res) {
        if (!res[levelIndex]) {
            res[levelIndex] = []
        }
        res[levelIndex].push(root.val)
        root.children.forEach(child => {
            helper(child, levelIndex + 1, res)
        })
    }
    const res = []
    helper(root, 0, res)
    return res
}