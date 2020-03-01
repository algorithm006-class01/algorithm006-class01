/*
 * @lc app=leetcode.cn id=242 lang=swift
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    func isAnagram(_ s: String, _ t: String) -> Bool {
        guard s.count == t.count else {
            return false
        }
        var map = [Character:Int]()
        for i in s.indices {
            if let value = map[s[i]] {
                map[s[i]] = value + 1
            }else{
                map[s[i]] = 1
            }
        }
        
        for i in t.indices {
            if let value = map[t[i]] {
                if value == 1 {
                    map.removeValue(forKey: t[i])
                }else{
                   map[t[i]] = value - 1 
                }
            }else{
                return false
            }
        }
        return map.count == 0
    }
}
// @lc code=end

