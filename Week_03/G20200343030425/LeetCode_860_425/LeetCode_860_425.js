/*
* address: https://leetcode-cn.com/problems/lemonade-change/
* */

let input = [5, 5, 5, 10, 20];
let result = true;

/*
* 贪心：目前情况下最好的就是能用10元用10元，尽量少用5元；
* */
let lemonadeChange = function (bills) {
    let num5 = 0;
    let num10 = 0;
    for (let i = 0; i < bills.length; i++) {
        switch (bills[i]) {
            case 5:
                num5++;
                break;
            case 10:
                if (num5 === 0) return false;
                num10++;
                num5--;
                break;
            case 20:
                if (num10 >= 1 && num5 >= 1) {
                    num10--
                    num5--
                } else if (num10 === 0 && num5 >= 3) {
                    num5 -= 3
                } else return false;
                break;
        }
    }
    return true
};
