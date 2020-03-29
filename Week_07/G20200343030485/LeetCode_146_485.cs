public class LRUCache {
    Dictionary<int, int> dict = new Dictionary<int, int>();
    LinkedList<int> list = new LinkedList<int>();
    readonly int max;

    public LRUCache(int capacity) {
        max = capacity;
    }
    
    public int Get(int key) {
        int result;
        if (dict.TryGetValue(key, out result)) {
            list.Remove(key);
            list.AddFirst(key);

            return result;
        }

        return -1;
    }
    
    public void Put(int key, int value) {        
        int result;
        if (dict.TryGetValue(key, out result)) {
            list.Remove(key);
            list.AddFirst(key);
            dict[key] = value;
            
            return;
        }

        if (list.Count >= max) {
            dict.Remove(list.Last.Value);
            list.RemoveLast();
        }

        list.AddFirst(key);
        dict[key] = value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.Get(key);
 * obj.Put(key,value);
 */