class Solution {

    /**
     * 贪心法（找零钱正好是符合贪心算法的只顾眼前就行）
     * 每走一步只考虑眼前最优的就可以了，就是最优解。
     *
     * 先按照正确的 正常的能找零的方式 来一步一步判断是否能找零，排除了能找零的，就都是不能找零的
     * （1）一开始没有钱，5元个数为0,10元个数也为0,20元因为无法找零所以不记录个数。
     * （2）正好是付款5元的情况，给5元的个数+1。
     * （3）按照顺序，第二个人付款是10元的，那么 10元个数+1,5元个数-1。
     * （4）如果有人付款的是20元，那么要看看当前有几个5元和几个10元，这里要想成功找零分为两种情况：
     *      4.1）如果5元和10元的个数 >0，那么就可以找零
     *      4.2）如果5元的个数>2 也就是3个，那么就可以找零
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        if (bills == null | bills.length == 0) {
            return false;
        }
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) five++;
            else if (bill == 10 && five > 0) {
                five--; ten++;
            }
            else if (five > 0 && ten > 0) {
                five--; ten--;
            }
            else if (five > 2) five -= 3;
            else return false;
        }
        return true;
    }

}