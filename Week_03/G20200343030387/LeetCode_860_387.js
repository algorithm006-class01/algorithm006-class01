/**
 * @param {number[]} bills
 * @return {boolean}
 */
// 贪心算法
// 经过推断，每次找零都用最优，最后能得出全局最优
var lemonadeChange = function (bills) {
    let five = 0
    let ten = 0
    for (let i = 0; i < bills.length; i++) {
        switch (bills[i]) {
            case 5:
                five++
                break
            case 10:
                five--
                ten++
                break
            case 20:
                if (ten > 0) {
                    five--
                    ten--
                } else {
                    five -= 3
                }
                break
        }
        if (five < 0) {
            return false
        }
    }
    return true
};