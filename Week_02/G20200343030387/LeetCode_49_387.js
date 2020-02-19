/**
 * @param {string[]} strs
 * @return {string[][]}
 */
// 利用js自带的sort排序为每个字符串排序，再放入hash分组
var groupAnagrams1 = function(strs) {
    if (!strs.length) return []
    const groupObj = {}
    let key = ""
    strs.forEach(str => {
        key = str
            .split("")
            .sort()
            .join("")
        if (!groupObj[key]) {
            groupObj[key] = []
        }
        groupObj[key].push(str)
    })
    return Object.values(groupObj)
}

// 利用字符数组，将异位字母字符串归类后hash分组
var groupAnagrams = function(strs) {
    if (!strs.length) return []
    const base = "a".charCodeAt()
    const buildIndex = function(char) {
        return char.charCodeAt() - base
    }
    const groupObj = {}
    const baseCharArr = new Array(26).fill(0)
    strs.forEach(str => {
        const charArr = baseCharArr.slice()
        // 也可以用split将str转换为字符数组再遍历
        for (let i = 0; i < str.length; i++) {
            charArr[buildIndex(str.charAt(i))]++
        }
        const key = charArr.join("#")
        if (!groupObj[key]) {
            groupObj[key] = []
        }
        groupObj[key].push(str)
    })
    return Object.values(groupObj)
}
