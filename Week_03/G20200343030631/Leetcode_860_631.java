class Solution {
    public boolean lemonadeChange(int[] bills) {
        // 边界条件
        if (null == bills || bills.length == 0){
            return false;
        }
        // 记录当前零钱总数
        int pocketMoney = 0;
        int fiveDollarsCount = 0;
        int tenDollarsCount = 0;
        for (int i = 0; i < bills.length; i++) {
            // 每次交易计算支付额减去单价后，是否有足够零钱找零，不够则返回false，足够则将零钱+5
            // v2 提交失败，零钱有5 10 20之分，加入统计数字，统计5 10的个数
            if ((bills[i] - 5) > pocketMoney){
                return false;
            }
            if ((bills[i] - 5) > 0 && fiveDollarsCount <= 0){
                return false;
            }
            if (bills[i] == 5){
                fiveDollarsCount ++;
            }else if (bills[i] == 10){
                fiveDollarsCount--;
                tenDollarsCount++;
            }else {
                if (fiveDollarsCount > 0 && tenDollarsCount > 0){
                    fiveDollarsCount--;
                    tenDollarsCount--;
                }else if (fiveDollarsCount >= 3){
                    fiveDollarsCount -= 3;
                }else {
                    return false;
                }
            }
            pocketMoney += 5;
        }
        return true;
    }
}