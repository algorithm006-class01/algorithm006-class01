#include <vector>

//49. 字母异位词分组
// https://leetcode-cn.com/problems/group-anagrams/

//方法1: 排序字符表
// key为排序的字符串，值为字符串数组,对字符串进行排序，然后查找
// 时间复杂度 K(nlog n)
class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> res; //输出结果
        unordered_map<string, int> word_tbl; //记录word对应位置
        int word_pos = 0 ; //word在结果中的位置
        string tmp_str; //临时存放字符
        for( auto str : strs){
            tmp_str = str;
            sort(tmp_str.begin(), tmp_str.end());
            if (  word_tbl.count(tmp_str) ){ //如果匹配到已有词
                int temp_pos = word_tbl[tmp_str];
                res[temp_pos].push_back(str) ; //加入结果
            } else{
                vector<string> vec(1, str);
                res.push_back(vec);
                word_tbl[tmp_str] = word_pos++;
            }
        }
        return res;    
    }
};

//方法2: 字母频数表
//统计每个字符串中，26个字母出现的次数，
//比如说a=3，b=4,c=5, 那么就是#3#4#4#0#0... 这就是哈希表的key
class Solution {
public:
    string encodeStr(string str){
        string res;
        int freq_arr[26] = {0};
        for ( auto ch : str){
            freq_arr[ch - 'a']++;
        }
        for( int i = 0; i < 26; i++){
            res += "#";
            res += to_string(freq_arr[i]);
        }
        return res;
    }
    vector<vector<string>> groupAnagrams(vector<string>& strs) {

        vector<vector<string>> res;
        unordered_map<string, int> word_tbl; //key为字符频数, value为位置
        int index = 0; //数组下标

        string freq_key;

        for (auto str : strs){
            freq_key = encodeStr(str);
            
            if ( word_tbl.count(freq_key) ){
                res[ word_tbl[freq_key] ].push_back(str);
            } else{
                vector<string> vec(1, str);
                res.push_back(vec);
                word_tbl[freq_key] = index++;
            }

        }
        return res;
        
    }
};

//方法3: 方法2优化哈希函数
//按理说这道题中，方法2应该快一点，但实际上速度却慢了
//估计是字符串的哈希函数不好使。可以借助 算术基本定理，又称为正整数的唯一分解定理，
//即：每个大于1的自然数，要么本身就是质数，要么可以写为2个以上的质数的积，
//而且这些质因子按大小排列之后，写法仅有一种方式。
class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        //26个字母的质数对应表
        int char_hash[26] = {
            2,  3,  5,  7,  11, 
            13, 17, 19, 23, 29,
            31, 37, 41, 43, 47, 
            53, 59, 61, 67, 71,
            73, 79, 83, 89, 97, 
            101 
        } ;
        vector<vector<string>> res;
        unordered_map<unsigned long, int> word_table;
        int index = 0; //对应res的二维下标

        for (auto str : strs){
            unsigned long hash_key = 1;
            for (auto ch : str){
                hash_key *= char_hash[ch-'a'];
            }
            if ( word_table.count(hash_key) > 0 ) {
                res[word_table[hash_key]].push_back(str);
            } else{
                vector<string> temp(1, str);
                res.push_back(temp);
                word_table[hash_key] = index++;
            }
        }
        return res;
        
    }
};