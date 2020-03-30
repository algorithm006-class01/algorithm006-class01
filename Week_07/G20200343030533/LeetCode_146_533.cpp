#include <string.h>
#include <vector>
#include <iostream>
#include <climits>
#include <algorithm>
#include <list>
#include <unordered_map>
using namespace std;

//仅仅使用双向链表, 348s
struct Entry1{
    int key;
    int value;
};

class LRUCache2 {
private:
    int m_capacity;
    int count ;
    list<Entry1> LRU;
public:
    LRUCache2(int capacity) {
        m_capacity = capacity;
        count = 0;
    }
    
    int get(int key) {
        for (auto p = LRU.begin(); p!= LRU.end(); p++){
            if (p->key == key){
                LRU.splice(LRU.begin(), LRU, p);
                return p->value;
            }
        }
        return -1;

    }
    
    void put(int key, int value) {
        //先检查有没有
        for (auto p = LRU.begin(); p!= LRU.end(); p++){
            if (p->key == key){
                LRU.push_front({key, value});
                LRU.erase(p);
                return ;
            }
        }
        
        //如果没有，看看容量有没有满
        if ( count  == m_capacity){
            LRU.pop_back();
            LRU.push_front({key,value});
        } else{
            LRU.push_front({key,value});
            count += 1;
        }
        return ;

    }
};


/*使用双向链表 + 哈希表, 144ms
哈希表存放key和 vlue +链表的指针/遍历器(iterator)
链表只存放key的顺序
*/

//记录值和key所在链表指针
struct Entry{
    int value; 
    list<int>::iterator iter;
    Entry(int v, list<int>::iterator it): value(v), iter(it) {};
};

class LRUCache {
private:
    int m_capacity;
    unordered_map<int, Entry> m_hash;
    list<int> m_list;
public:
    LRUCache(int capacity) {
        m_capacity = capacity;
        m_hash.reserve( capacity * 2 ) ;// 声明2倍空间，减少rehash
    }
    
    int get(int key) {
        auto iter = m_hash.find(key);
        // 查找到
        if ( iter != m_hash.end() ){
            m_list.splice(m_list.begin(), m_list, iter->second.iter); //更新缓存
            return iter->second.value; 
        }
        return -1;

    }
    
    void put(int key, int value) {
        auto iter = m_hash.find(key);
        // 已有缓冲, 更新
        if ( iter != m_hash.end() ){
            m_list.splice(m_list.begin(), m_list, iter->second.iter);
            iter->second.value = value;
            return ;
        }
        // 缓存已满
        if ( m_hash.size() == m_capacity){
            m_hash.erase( m_list.back () ); //根据list的最后元素的key删除元素
            m_list.pop_back(); //删除列表最后一个元素
        }
        m_list.push_front(key);
        m_hash.insert({key, {value, m_list.begin()}} );

        return ;

    }
};

//LeetCode 
// 使用typedef, 不用struct, 提高了 速度
class LRUCache {
public:
    LRUCache(int capacity) : _capacity(capacity) {}
    
    int get(int key) {
        auto it = cache.find(key);
        if (it == cache.end()) return -1;
        touch(it);
        return it->second.first;
    }
    
    void set(int key, int value) {
        auto it = cache.find(key);
        if (it != cache.end()) touch(it);
        else {
			if (cache.size() == _capacity) {
				cache.erase(used.back());
				used.pop_back();
			}
            used.push_front(key);
        }
        cache[key] = { value, used.begin() };
    }
    
private:
    typedef list<int> LI;
    typedef pair<int, LI::iterator> PII;
    typedef unordered_map<int, PII> HIPII;
    
    void touch(HIPII::iterator it) {
        int key = it->first;
        used.erase(it->second.second);
        used.push_front(key);
        it->second.second = used.begin();
    }
    
    HIPII cache;
    LI used;
    int _capacity;
};


/*
typeder unordered_map<int, pair<int, list<int>>>
*/