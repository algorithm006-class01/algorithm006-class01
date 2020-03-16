// decode-ways
// 边界条件要死

var numDecodings = function(s) {
    if (s[0]==0) return 0
    if (s.length == 1) return 1;
    if (s[0]>2 && s[1]==0) return 0;

    if (s.length == 2) {
        if (s > 26 || s==10 || s==20) {
            return 1;
        } else {
            return 2
        }
    }

    var first = 1;
    var second;
    if (s.slice(0,2) > 26 || s[1]==0) {
        second = 1;
    } else {
        second = 2;
    }
    var result;
    for(var i=2; i<s.length; i++) {
        if ((s[i-1]>2 || s[i-1]==0) && s[i]==0) return 0;
        if (s[i] == 0) {
            result = first;
            first = 0;
            second = result;
        } else if (s.slice(i-1,i+1) >26 || s[i-1]==0){
            result = second;
            first = second;
            second = result;
        } else{
            result = first + second;
            first = second;
            second = result;
        }
    }

    return result;
};