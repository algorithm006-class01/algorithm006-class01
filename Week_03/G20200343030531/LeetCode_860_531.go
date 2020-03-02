package main

import "fmt"

func main() {
	bills := []int{5, 5, 5, 10, 5, 20}

	fmt.Println(lemonadeChange(bills))
}

/*
	贪心算法：局部最优
*/

// 本题反思
// 拿到题目思考的时间有点长，虽然看过老师讲课，但是真正到自己动手了还是有点摸不着头脑.
// 写题目不要拘泥，该用的中间变量要舍得用上。
// 要注意场景，先付钱这个动作，所以有29行和31行的先行加法
// 找零的原则是先把大额（10块）能找的都找了（循环），不能找的（back > 0）留给小额（5块）
// 最后判定的时候back > 0，就是找不开，失败了

// 结束判定条件，可以通过five < 0来判断是否符合条件
/*
func lemonadeChange(bills []int) bool {
	// 中间变量，five存五块钱，ten存十块钱，back放找零的钱
	five, ten, back  := 0, 0, 0

	for i := 0; i < len(bills); i++ {
		if bills[i] == 5 {
			five++
		}else if bills[i] == 10 {
			ten++
		}
		// 柠檬水五块一杯，返回找零
		back = bills[i] - 5
		// 优先找零十块钱
		// 条件是back >= 10，ten > 0
		for back >= 10 && ten > 0 {
			back -= 10
			ten--
		}
		// 再次找零5元
		// 条件是back >= 5, five > 0
		for back >= 5 && five > 0 {
			back -= 5
			five--
		}
		// 余额back大于0，无法完成找零
		if back >0 {
			return false
		}
	}
	return true
}
*/

// 另一种解法，贪心算法，局部最优
func lemonadeChange(bills []int) bool {
	five, ten := 0, 0
	for i := 0; i < len(bills); i++ {
		switch bills[i] {
		case 5:
			five++
			break
		case 10:
			{
				ten++
				five--
			}
			break
		case 20:
			{
				if ten > 0 {
					ten--
					five--
				} else {
					five = five - 3
				}
				break
			}
		default:
			break
		}
		if five < 0 {
			return false
		}
	}
	return true
}
