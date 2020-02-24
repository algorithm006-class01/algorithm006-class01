// https://leetcode-cn.com/problems/design-circular-deque/submissions/

var MyCircularDeque = function(k) {
    this.ArrDeque = new Array(k + 1);
    this.front = 0;
    this.rear = 0;
    this.n = k + 1;
    this.k = k;
}

MyCircularDeque.prototype.insertFront = function(value) {
    if (this.isFull('front')) {
        return false;
    } else {
        this.front = (--this.front + this.n) % (this.n);
        this.ArrDeque[this.front] = value;
        return true;
    }
}

MyCircularDeque.prototype.insertLast = function(value) {
    if (this.isFull('last')) {
        return false;
    } else {
        this.ArrDeque[this.rear] = value;
        this.rear = (this.rear + 1) % (this.n);
        return true;
    }
}

MyCircularDeque.prototype.deleteFront = function() {
    if (this.isEmpty()) {
        return false;
    } else {
        this.front = (++this.front) % (this.n);
        return true;
    }
}

MyCircularDeque.prototype.deleteLast = function() {
    if (this.isEmpty()) {
        return false;
    } else {
        this.rear = (--this.rear + this.n) % (this.n);
        return true;
    }
}

MyCircularDeque.prototype.getFront = function() {
    return this.isEmpty() ? -1 : this.ArrDeque[this.front];
}

MyCircularDeque.prototype.getRear = function() {
    return this.isEmpty() ? -1 : this.ArrDeque[(this.rear - 1 + this.n) % (this.n)];
}

MyCircularDeque.prototype.isEmpty = function() {
    if (this.front == this.rear) {
        return true;
    } else {
        return false;
    }
}

MyCircularDeque.prototype.isFull = function(x) {
    return (this.rear - this.front + this.n) % (this.n) == this.k;
}