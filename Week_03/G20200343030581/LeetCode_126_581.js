/*
 * @lc app=leetcode.cn id=126 lang=javascript
 *
 * [126] 单词接龙 II
 */

// @lc code=start
/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {string[][]}
 */
// 1.BFS
var findLadders = function(beginWord, endWord, wordList) {
    let L = beginWord.length;
    let wordMap = new Map();
    wordList.forEach(w => {
        for (let i = 0; i < L; i++) {
            let nw = w.slice(0, i) + '*' + w.slice(i + 1);
            if (wordMap.has(nw)) {
                wordMap.get(nw).push(w);
            } else {
                wordMap.set(nw, [w]);
            }
        }
    });

    let res = [];
    let queue = [[beginWord], ]
    let visited = new Set();
    while(queue.length) {
        let len = queue.length;
        while (len-- > 0) {
            let tmp = queue.shift();
            let word = tmp[tmp.length - 1];

            if (word == endWord) {
                res.push(tmp);
                continue;
            }

            visited.add(word);
            for (let i = 0; i < L; i++) {
                let nw = word.slice(0, i) + "*" + word.slice(i + 1);
                if (wordMap.has(nw)) {
                    wordMap.get(nw).forEach(w => {
                        if (!visited.has(w))
                            queue.push(tmp.concat(w));
                    });
                }
            }
        }
        if (res.length)
            return res;
    }

    return res;
};


// @lc code=end


