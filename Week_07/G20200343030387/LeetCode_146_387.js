/**
 * @param {number} capacity
 */
// 利用Map对插入的key有顺序的特性；
// 能够通过map.keys().next().value拿到最后的元素；
// 能够模拟缓存key被重复使用后放到最前面，最少被使用的逐渐往后排，在超大小限制时，取最后的元素删除掉；
var LRUCache = function (capacity) {
    this.capacity = capacity
    this.map = new Map()
};

/** 
 * @param {number} key
 * @return {number}
 */
LRUCache.prototype.get = function (key) {
    const val = this.map.get(key)
    if (typeof val === 'undefined') return -1
    this.map.delete(key)
    this.map.set(key, val)
    return val
};

/** 
 * @param {number} key 
 * @param {number} value
 * @return {void}
 */
LRUCache.prototype.put = function (key, value) {
    if (this.map.has(key)) {
        this.map.delete(key)
    }
    this.map.set(key, value)
    if (this.map.size > this.capacity) {
        this.map.delete(this.map.keys().next().value)
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */