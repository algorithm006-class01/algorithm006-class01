import java.util.Hashtable;
class LRUCache {
private DLinkedNode head;
	private DLinkedNode tail;
	private Hashtable<Integer, DLinkedNode> cache = new Hashtable<Integer, DLinkedNode>();
	private int size;
	private int capacity;

	class DLinkedNode {
		DLinkedNode next;
		DLinkedNode pre;
		int key;
		int value;

	}

	private void addNode(DLinkedNode node) {
		node.next = head.next;
		node.pre = head;

		head.next = node;
		node.next.pre = node;
	}

	private void remove(DLinkedNode node) {
		DLinkedNode nodePre = node.pre;
		DLinkedNode nodeNext = node.next;

		nodePre.next = nodeNext;
		nodeNext.pre = nodePre;
	}

	private void moveToHead(DLinkedNode node) {
		remove(node);
		addNode(node);
	}

	private DLinkedNode popTail() {
		DLinkedNode node = tail.pre;
		remove(node);
		return node;
	}

	public LRUCache(int capacity) {
		head = new DLinkedNode();
		tail = new DLinkedNode();
		head.next = tail;
		tail.pre = head;
		this.capacity = capacity;
		this.size = 0;
	}

	public int get(int key) {
		DLinkedNode node = cache.get(key);
		if (node == null)
			return -1;
		else {
			moveToHead(node);
			return node.value;
		}
	}

	public void put(int key, int value) {
		DLinkedNode node = cache.get(key);
		if (node == null) {
			node = new DLinkedNode();
			node.key = key;
			node.value = value;
			addNode(node);
			cache.put(key, node);
			size++;
			if (size > capacity) {
				size--;
				DLinkedNode tail = popTail();
				cache.remove(tail.key);
			}
		} else {
			moveToHead(node);
			node.value = value;
		}

	}
}
