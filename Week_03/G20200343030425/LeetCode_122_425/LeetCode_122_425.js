/*
* address: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
* */
let input=[7,1,5,3,6,4];
let result=7;

/*
* Method 1: only using for loop
* */
const maxProfit=(input)=>{
    let profit=0;

        for (let i = 0; i <input.length ; i++) {
            if(input[i+1]>input[i]){
                profit+=input[i+1]-input[i];
            }
        }
        return profit;

};
/*
* Method 2:
* */
