class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 1) return 0;
        int maxProfit = 0;
        int minSoFar = Integer.MAX_VALUE;
        for(int price: prices) {
            maxProfit = Math.max(maxProfit, price - minSoFar);//
            minSoFar = Math.min(price, minSoFar);//
        }
        return maxProfit;
        // 10,1,5,6,7,1
    }
}
