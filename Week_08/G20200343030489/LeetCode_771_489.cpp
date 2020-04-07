/*
 * @lc app=leetcode.cn id=771 lang=cpp
 *
 * [771] 宝石与石头
 */

// @lc code=start
// class Solution {
// public:
//     int numJewelsInStones(string J, string S) {
//         int count=0;
//         for(auto& a:J){
//             for(int i=0;i<S.size();i++){
//                 if(S[i]==a)
//                     count++;
//             }
//         }
//         return count;
//     }
// };
// class Solution {
// public:
//     int numJewelsInStones(string J, string S) {
//         int count=0;
//         unordered_map<char,int> hash;
//         for(auto a:S)
//             hash[a]++;
//         for(auto a:J)
//             if(hash[a]>0)
//                 count+=hash[a];
//         return count;
//     }
// };
class Solution {
public:
    int numJewelsInStones(string J, string S) {
        int count=0;
        unordered_set<char> st;
        for(auto a:J)
            st.insert(a);
        for(auto a:S)
            if(st.count(a))
                count++;
        return count;
    }
};
// @lc code=end

