/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
// 求最短距离，一般用广度优先比较合适，深度优先需要将所有可能情况都遍历到，然后比较最优；
// 从bgeinWord开始，每一层尝试转换成wordList里的单词，走到转换成enwWord，当前层就是最短距离；
// 中间需要存储访问过的单词，防止出来环路；
// 如果最终wordList里的都访问过了，还是没能转成endWord，则说明无法转换，返回0；
// 为加快找到能转换的单词，这里将wordList的单词用hash表存储对应的转换规则中，如'd*g' => ['dog', 'dug']
var ladderLength = function (beginWord, endWord, wordList) {
    const wordHash = new Map()
    const wordLength = beginWord.length
    const replaceCharByIndex = function (str, index) {
        return str.substring(0, index) + "*" + str.substring(index + 1)
    }
    const buildWordHash = function () {
        let key = ''
        let val = []
        wordList.forEach(word => {
            for (let i = 0; i < wordLength; i++) {
                key = replaceCharByIndex(word, i)
                val = wordHash.get(key) || []
                val.push(word)
                wordHash.set(key, val)
            }
        })
    }
    const bfs = function () {
        const queues = [{node: beginWord, level: 1}]
        const visited = new Set()
        let current = ''
        let level = 0
        let childNodes = []
        visited.add(beginWord)
        while (queues.length) {
            current = queues.shift()
            level = current.level
            for (let wi = 0; wi < wordLength; wi++) {
                childNodes = wordHash.get(replaceCharByIndex(current.node, wi))
                if (childNodes) {
                    for (let i = 0; i < childNodes.length; i++) {
                        if (childNodes[i] === endWord) {
                            return current.level + 1
                        }
                        if (!visited.has(childNodes[i])) {
                            visited.add(childNodes[i])
                            queues.push({node: childNodes[i], level: level + 1})
                        }
                    }
                }
            }
        }
        return 0
    }
    buildWordHash()
    return bfs()
};