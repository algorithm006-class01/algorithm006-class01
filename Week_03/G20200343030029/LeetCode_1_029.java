class LeetCode_1_029{

	// 题目描述：在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
	//
	//顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
	//
	//每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
	//
	//注意，一开始你手头没有任何零钱。
	//
	//如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
	//
	//来源：力扣（LeetCode）
	//链接：https://leetcode-cn.com/problems/lemonade-change
	//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

	public static void main(String[] args) {
		int[] array1 = {5,5,5,10,20};
		int[] array2 = {5,5,10};
		int[] array3 = {5,5,10,10,20};
		System.out.println(lemonadeChange(array1));
		System.out.println(lemonadeChange(array2));
		System.out.println(lemonadeChange(array3));
	}

	public static boolean lemonadeChange(int[] bills) {
		int five = 0;
		int ten = 0;
		for(int bill : bills) {
			if(5 == bill) {
				five++;
			}else if(10 == bill){
				if(five < 0) {
					return false;
				}
				five--;
				ten++;
			}else{
				// 20
				if(five > 0 && ten > 0) {
					five--;
					ten--;
				}else if(five >= 3){
					five = five - 3;
				}else{
					return false;
				}
			}
		}
		return true;
	}
}