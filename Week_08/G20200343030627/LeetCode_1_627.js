//first-unique-character-in-a-string

var firstUniqChar = function(s) {
    if (s.length == 0) return -1;

    var hashTable = {};
    for (var i=0; i< s.length; i++) {
        if (hashTable[s[i]]) {
            hashTable[s[i]].count += 1;
        } else {
            hashTable[s[i]] = {count:1, idx: i};
        }
    }

    var resultIdx = s.length;
    for (x in hashTable) {
        if (hashTable[x].count == 1 && hashTable[x].idx < resultIdx) {
            resultIdx = hashTable[x].idx;
        }
    }
    return resultIdx == s.length ? -1 : resultIdx;
};