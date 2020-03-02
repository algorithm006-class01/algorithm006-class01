class Solution {
public:
    int maxProfit(vector<int>& prices) {

        int i=0,j=1,sum=0;

        if(prices.size()<=1)
        return 0;
        

        while(j<prices.size()){
            if(prices[j]-prices[i]>0)
                sum+=(prices[j]-prices[i]);

                i++;
                j++;
        }
        return sum;
    }
};

