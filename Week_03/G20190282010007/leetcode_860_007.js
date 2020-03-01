// 题目: 买卖股票的最佳时机II
/**
 * 题目描述：
 *在柠檬水摊上，每一杯柠檬水的售价为 5 美元。

顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。

每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。

注意，一开始你手头没有任何零钱。

如果你能给每位顾客正确找零，返回 true ，否则返回 false 。

 */

 // 解题语言: javaScript

 // 解题
/**
 * @param {number[]} bills
 * @return {boolean}
 */
var lemonadeChange = function(bills) {
    // 没人来买汽水，或者第一个就给大钱的，直接做不了生意了
    if (bills.length == 0 || bills[0] > 5) {
        return false
    }
    // 统计 收到的5块钱和10块钱的数量
    let [five, ten] = [0, 0];
    // 循环判断
    for (let i = 0; i< bills.length; i++) {
        // 收到5块钱的直接入账
        if (bills[i] == 5) {
            five++
        } else if (bills[i] == 10) { // 收到十块钱时，需要找5块
            if (five <= 0) {
                return false // 没钱找，gg
            } else {
                // 收10块找5块
                five--
                ten++
            }
            
        } else if (bills[i] == 20) {
            if (ten > 0 && five > 0) { // 优先使用10块钱的找零
                ten--
                five--
            } else if (five >=3) { // 10块钱不够就看5块钱够不够
                five-=3
            } else {
                return false  // 都不够，gg
            }
        }
    }
    return true  
};