// 860. 柠檬水找零
// https://leetcode-cn.com/problems/lemonade-change/
// 因为是倍数关系，因此能用贪心

/*考虑的情况
 * 5, 可用5+1 
 * 10,可用5-1，可用10+1
 * 20: 分为两种情况
 *  - 5 和 10 都有，可用5-1，可用10-1 
 *  - 只有5，且大于2张， 可用5-3
 */

class Solution {
public:
    bool lemonadeChange(vector<int>& bills) {
        if (bills.size() == 0 ) return true;
        int used_five = 0; //可用5元
        int used_ten  = 0; //可用的10元
        for ( int i = 0 ; i < bills.size(); i++ ){
            if (bills[i] == 5) {
                used_five += 1;
            } else if ( bills[i] == 10){
                if ( used_five == 0 ) return false;
                used_five -= 1;
                used_ten += 1;
            } else {
                if (used_five > 0 && used_ten > 0){
                    used_five -= 1;
                    used_ten -= 1;
                } else if ( used_five > 2){
                    used_five -= 3;
                } else{
                    return false;
                }

            }
        }
        return true;

    }
};