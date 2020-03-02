题目:柠檬水找零
解法如下

解法一:
int five =0,ten =0;
for(auto bill : bills){
    if(bill ==5){ //5元放一起
        five ++;
    }else if (bill ==10){
        if(five == 0) return false;  //如果第一个就超过5那就不满足
        five --; //5元少一张
        ten ++; //10元多一张
    }else{ //20找零
        if(five > 0 && ten >0){ //有5元 和 10元纸币 各少一张
            five --;
            ten --;
        }else if ( five ==0 && ten >0){ //只有10块纸币 那就不满足
            return false;
        }else if (five >=3){ //如果有超过三张5元 那么5元少三张
            five -= 3;
        }else {
            return false; //其余不满足
        }
    }
}

return true;

解法二:国际站投票最高的
https://leetcode.com/problems/lemonade-change/discuss/143719/C%2B%2BJavaPython-Straight-Forward
class Solution {
public:
    bool lemonadeChange(vector<int>& bills) {
        int five = 0, ten = 0;
        for (int i : bills) {
            if (i == 5) five++;
            else if (i == 10) five--, ten++;
            else if (ten > 0) ten--, five--; //这里可以知道钱盒子里至少有一张5元 那就10元 5元各少一张
            else five -= 3;
            if (five < 0) return false; //如果都不够找零那就不成功
        }
        return true;
    }
};
