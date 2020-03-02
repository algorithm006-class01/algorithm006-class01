// lemonade-change

var lemonadeChange = function(bills) {
    var fiveCount = 0;
    var tenCount = 0;
    for (var i=0; i < bills.length; i++) {
        if (bills[i] == 5) {
            fiveCount += 1;
        } else if (bills[i] == 10) {
            if (fiveCount > 0) {
                fiveCount -= 1;
                tenCount += 1;
            } else {
                return false;
            }
        } else {
            if (fiveCount > 0 && tenCount > 0) {
                fiveCount -= 1;
                tenCount -= 1;
            } else if (fiveCount > 2) {
                fiveCount -= 3;
            } else {
                return false;
            }
        }
    }
    return true;
};