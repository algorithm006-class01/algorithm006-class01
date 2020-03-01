// assign-cookies

var findContentChildren = function(g, s) {
    var feedCount = 0;
    var gSort = g.sort((a,b) => a> b? 1: -1);
    var sSort = s.sort((a,b) => a> b? 1: -1);
    
    for (var i=0; i< g.length; i++) {
        while (sSort[0]< gSort[i] && sSort.length > 0) {
            sSort.shift();
        }
        if (sSort.length == 0) {
            return feedCount;
        }
        sSort.shift();
        feedCount += 1;
    }

    return feedCount;
};