/*
 * @lc app=leetcode.cn id=49 lang=swift
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Item{
    var array = [String]()
}
class Solution {
    func groupAnagrams(_ strs: [String]) -> [[String]] {
        var map = [String: Item]()
        for string in strs {
            let key = String.init(string.sorted())
            if let value = map[key] {
                value.array.append(string)
            }else{
                let item = Item()
                item.array.append(string)
                map[key] = item
            }
        }
        
        var result = [[String]]()
        for (_, value) in map {
            result.append(value.array)
        }
        return result
    }
}
// @lc code=end

