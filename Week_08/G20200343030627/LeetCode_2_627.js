///reverse-string-ii
// 很慢

var reverseStr = function(s, k) {
    var s = s.split('');
    for (var i=0; i<s.length; i+= k*2) {
        if (s.length -i>=k) {
            for (var j=0;j<Math.floor(k/2);j++) {
                var temp;
                temp = s[i+j];
                s[i+j] = s[i+k-1-j];
                s[i+k-1-j] = temp;
            }
        } else {
            for (var j=0;j<Math.floor((s.length -i)/2);j++) {
                var temp;
                temp = s[i+j];
                s[i+j] = s[i+k-1-j];
                s[i+k-1-j] = temp;
            }
        }
    }
    return s.join('');
};