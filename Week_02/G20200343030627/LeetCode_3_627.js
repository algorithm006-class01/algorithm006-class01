// group-anagrams


/*
/* 字符排序比较
var groupAnagrams = function(strs) {
    var dict = {}
    for (var i=0; i< strs.length; i++) {
        var sortedStr = strs[i].split('').sort((a,b)=>a>b?1:-1).join('');
        if (dict[sortedStr]) {
            dict[sortedStr].push(strs[i]);  
        } else {
            dict[sortedStr] = [strs[i]];
        }
    }
    var result = []
    for (x in dict) {
        result.push(dict[x]);
    }
    return result
};
*/

// 字幕映射表，速度稍快 160ms
var groupAnagrams = function(strs) {
    var dict = {};

    for (var i=0; i< strs.length; i++) {
        var strKey = toKey(strs[i]);
        if (dict[strKey]) {
            dict[strKey].push(strs[i]);  
        } else {
            dict[strKey] = [strs[i]];
        }
    }
    var result = []
    for (x in dict) {
        result.push(dict[x]);
    }
    return result
}

function toKey(str) {
    var map= {a:0,b:1,c:2,d:3,e:4,f:5,g:6,h:7,i:8,j:9,k:10,l:11,m:12,n:13,o:14,p:15,q:16,r:17,s:18,t:19,u:20,v:21,w:22,x:23,y:24,z:25};
    var arr = [];
    for (var i=0; i<str.length; i++) {
        if (arr[map[str[i]]]) {
            arr[map[str[i]]] += 1;
        } else {
            arr[map[str[i]]] = 1
        }
    }
    return arr.join('#');
}