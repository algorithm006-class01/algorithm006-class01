int maxProfit(int* prices, int pricesSize){
    int total = 0;
    int i;
    for ( i = 0; i < pricesSize - 1; i++ ) {
        if ( prices[i] < prices[i+1]) {
            total += prices[i+1] - prices[i];
        }
    }
    return total;
}
