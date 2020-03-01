// n-ary-tree-level-order-traversal/
// 队列
var levelOrder = function(root) {
    if (!root) return [];
    var queueList = [root];
    var result = [];
    var level = 0;

    while(queueList.length > 0) {  // 当前队列不为空
        var levelLimit = queueList.length;
        for (var i= 0; i< levelLimit; i++) {
            var node = queueList.shift();
            if (result[level]) {
                result[level].push(node.val);
            } else {
                result[level] = [node.val];
            }

            for (var j = 0; j< node.children.length; j++) {
                if (!node.children[j]) continue;
                queueList.push(node.children[j]);
            }
        }
        level ++;   
    }

    return result
};
/** 
/* 双队列
var levelOrder = function(root) {
    if (!root) return []
    var queueFlag = 0;
    var queueList = [[root],[]];
    var result = [];
    var level = 0;

    while(queueList[queueFlag].length > 0) {  // 当前队列不为空
        var node = queueList[queueFlag].shift();
    
        if (result[level]) {
            result[level].push(node.val);
        } else {
            result[level] = [node.val];
        }

        for (var i = 0; i< node.children.length; i++) {
            if (!node.children[i]) continue;
            queueList[1-queueFlag].push(node.children[i]);
        }
        if (queueList[queueFlag].length == 0) {
            queueFlag = 1 - queueFlag;
            level += 1;
        }
    }

    return result
};
*/