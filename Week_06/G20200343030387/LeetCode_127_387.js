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
var ladderLength1 = function (beginWord, endWord, wordList) {
    const wordHash = new Map()
    const wordLength = beginWord.length
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
                if (!childNodes) continue
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
        return 0
    }
    buildWordHash()
    return bfs()
};

// 双向bfs
// 从beginWord和endWord逐渐向中间遍历；
// 每次遍历取节点最小的层，减少遍历次数；
// 用hashMap来获取当前字词可能变换的单词列表，比遍历26个字母逐个替换要快很多；
// 遍历的次数+1则为所求长度；
var ladderLength = function (beginWord, endWord, wordList) {
    if (!wordList.includes(endWord)) return 0

    const wordHash = new Map()
    let key = ''
    let val = []
    wordList.forEach(word => {
        for (let i = 0; i < word.length; i++) {
            key = replaceCharByIndex(word, i)
            val = wordHash.get(key) || []
            val.push(word)
            wordHash.set(key, val)
        }
    })

    let front = new Set()
    front.add(beginWord)
    let back = new Set()
    back.add(endWord)
    const visited = new Set()
    let len = 1
    let newWords = []
    while (front.size) {
        const tmpSet = new Set()
        for (let word of front) {
            for (let wi = 0; wi < word.length; wi++) {
                newWords = wordHash.get(replaceCharByIndex(word, wi))
                if (!newWords) continue
                for (let newWord of newWords) {
                    if (back.has(newWord)) {
                        return len + 1
                    }
                    if (wordList.includes(newWord) && !visited.has(newWord)) {
                        tmpSet.add(newWord)
                        visited.add(newWord)
                    }
                }
            }
        }
        len++
        front = tmpSet
        if (front.size > back.size) {
            const tmp = front
            front = back
            back = tmp
        }
    }
    return 0
}

function replaceCharByIndex(str, index) {
    return `${str.substring(0, index)}*${str.substring(index + 1)}`
}