/*
 * @lc app=leetcode.cn id=127 lang=javascript
 *
 * [127] 单词接龙
 */

// @lc code=start
/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
// 1. BFS
var ladderLength = function(beginWord, endWord, wordList) {
    let L = beginWord.length;
    let wordMap = new Map();
    wordList.forEach(word => {
        for (let i = 0; i < L; i++) {
            let nw = word.slice(0, i) + "*" + word.slice(i + 1);
            if (wordMap.has(nw)) {
                wordMap.get(nw).push(word);
            } else {
                wordMap.set(nw, [word]);
            }
        }
    });

    let res = 1;
    let queue = [beginWord];
    let visited = new Set();
    visited.add(beginWord);
    while (queue.length) {
        let len = queue.length;
        while (len--) {
            let word = queue.pop();
            if (word == endWord)
                return res;
            
            for (let i = 0; i < L; i++) {
                let nw = word.slice(0, i) + "*" + word.slice(i + 1);
                if (wordMap.has(nw)) {
                    wordMap.get(nw).forEach(word => {
                        if (!visited.has(word)) {
                            visited.add(word);
                            queue.unshift(word);
                        }
                    })
                }
            }
        }
        res++;
    }

    return 0;
};

// 2. 双向BFS
var ladderLength = function(beginWord, endWord, wordList) {
    if (wordList.indexOf(endWord) < 0)
        return false;
    
    let L = beginWord.length;
    let wordMap = new Map();
    wordList.forEach(word => {
        for(let i = 0; i < L; i++) {
            let nw = word.slice(0, i) + "*" + word.slice(i + 1)
            if (wordMap.has(nw)) {
                wordMap.get(nw).push(word);
            } else {
                wordMap.set(nw, [word]);
            }
        }
    });

    let Q_begin = [beginWord],
        visitedBegin = new Map();
    visitedBegin.set(beginWord, 1);
    let Q_end = [endWord],
        visitedEnd = new Map;
    visitedEnd.set(endWord, 1);

    function visitWordNode(queue, visited, otherVisited) {
        let word = queue.pop();
        let level = visited.get(word);

        for (let i = 0; i < L; i++) {
            let nw = word.slice(0, i) + '*' + word.slice(i + 1);
            if (wordMap.has(nw)) {
                let words = wordMap.get(nw);
                for (let j = 0; j < words.length; j++) {
                    let w = words[j];
                    if (otherVisited.has(w)) {
                        return level + otherVisited.get(w);
                    }

                    if (!visited.has(w)) {
                        visited.set(w, level + 1);
                        queue.unshift(w);
                    }
                }
            }
        }
    }

    while (Q_begin.length && Q_end.length) {
        let ans = visitWordNode(Q_begin, visitedBegin, visitedEnd);
        if (ans > -1)
            return ans;
        ans = visitWordNode(Q_end, visitedEnd, visitedBegin);
        if (ans > -1)
            return ans;
    }

    return 0;
}
// @lc code=end


