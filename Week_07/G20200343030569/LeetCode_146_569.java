import java.util.LinkedHashMap;
import java.util.Map;

/*
 * 146. LRU Cache
 * LRU缓存机制
 */
public class LeetCode_146_569 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	class LRUCache  extends LinkedHashMap<Integer, Integer>{
		int capacity;
		
	    public LRUCache(int capacity) {
	    	super(capacity, 0.75F, true);
	    	this.capacity = capacity;
	    }
	    
	    public int get(int key) {
	    	return super.getOrDefault(key, -1);
	    }
	    
	    public void put(int key, int value) {
	    	super.put(key, value);
	    }
	    
	    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
	    	return size() > capacity;
	    }
	}

	/**
	 * Your LRUCache object will be instantiated and called as such:
	 * LRUCache obj = new LRUCache(capacity);
	 * int param_1 = obj.get(key);
	 * obj.put(key,value);
	 */
}
