学习笔记

class Node{
public:
    Node* pre;
    Node* next;
    int key, val;
    Node(int key, int val):key(key),val(val){
        pre = NULL;
        next = NULL;
    }
};
class LRUCache {
public:
    unordered_map<int,Node*> mp;
    Node* head;
    Node* tail;
    int cap;
    
    LRUCache(int capacity) {
        this->cap = capacity;
        head=new Node(0,0);
        tail = new Node(0,0);
        head->next=tail;
        tail->pre = head;
    }
    void addtoTail(Node* n){
        tail->pre->next=n;
        n->pre=tail->pre;
        n->next=tail;
        tail->pre=n;
    }
    
    int get(int key) {
        if(mp.find(key)!=mp.end()){
            Node* cur = mp[key];
            if(cur){
                cur->pre->next=cur->next;
                cur->next->pre=cur->pre;
                addtoTail(cur);
                return cur->val;
            }
        }
        return -1;
    }
    
    void put(int key, int value) {
        if(mp.find(key)!=mp.end()){
            Node* cur = mp[key];
            if(cur){
                cur->val=value;
                mp[key]=cur;
                cur->pre->next=cur->next;
                cur->next->pre=cur->pre;
                addtoTail(cur);
                return;
            }
        }
        
        if(mp.size()==cap){
            Node* tmp = head->next;
            //head->next->next->pre=head;
            head->next=head->next->next;
            head->next->pre=head;
            mp.erase(tmp->key);
        }
        Node* cur= new Node(key,value);
        addtoTail(cur);
        mp[key]=cur;
        
    }
};

