//方法1: 基于排序
// 36ms
class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.size() != t.size()) return false;
        sort(s.begin(), s.end()); //排序s
        sort(t.begin(), t.end()); //排序t

        return s.compare(t) == 0; //如果完全相同，返回0
        
    }
};

//方法2: 使用内置的unordered_map
// 16ms
class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.size() != t.size()) return false;
        unordered_map<char, int> hash_table;
        for (int i = 0; i < s.size(); i++){
            hash_table[s[i]] += 1;
        }
        for (int i = 0; i < t.size(); i++){
            hash_table[t[i]] -= 1;
        }
        //遍历哈希表
        for(auto it = hash_table.begin(); it != hash_table.end(); ++it){
            if (it->second != 0 ) return false;
        }
        return true;
    
        
    }
};


//方法3: 根据map原理，利用数组实现
// < 12ms, 最快是8ms
class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.size() != t.size()) return false;
        char mytable[26] = {0};
        for ( int i = 0; i < s.size(); i++){
            mytable[ s[i] - 'a' ] += 1;
        }
        for ( int i = 0;i < t.size(); i++){
            mytable[ t[i] - 'a' ] -= 1;
        }
        for ( int i = 0; i< 26; i++){
            if (mytable[i] != 0) return false;
        }
        return true;
        
    }
};
