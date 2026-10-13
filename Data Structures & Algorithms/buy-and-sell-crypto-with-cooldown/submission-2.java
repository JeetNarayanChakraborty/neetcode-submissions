class Solution 
{
    public int maxProfit(int[] prices) 
    {
        if(prices.length == 0) return 0;
        int hold=-prices[0], sold=Integer.MIN_VALUE, rest=0;

        for (int i=1; i<prices.length; i++) 
        {
            int prevHold = hold;
            int prevSold = sold;
            int prevRest = rest;

            hold = Math.max(prevHold, prevRest - prices[i]); // keep holding, or buy today
            sold = prevHold + prices[i]; // sell today
            rest = Math.max(prevRest, prevSold);  // rest, or cooldown ends after a sold day
        }

        return Math.max(rest, sold);
    }
}