package dp;

public class Bonus_I_121 {
    public int maxProfit(int[] prices) {

        //暴力遍历 超时
        /*
        int n=prices.length;
        int max=0;
        for (int i=0;i<n-1;i++){
            for (int j=i;j<n;j++){
                if (prices[j]-prices[i]>max)
                    max=prices[j]-prices[i];
            }
        }

        return max;*/
        int minPrice=Integer.MAX_VALUE;
        int maxProfit=0;
        for (int i = 0; i < prices.length; i++) {
            if (minPrice>prices[i])
                minPrice=prices[i];
            else if (prices[i]-minPrice>maxProfit)
                maxProfit=prices[i]-minPrice;
        }
        return maxProfit;
    }
}
