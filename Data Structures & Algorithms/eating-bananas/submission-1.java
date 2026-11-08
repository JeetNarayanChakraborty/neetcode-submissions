class Solution 
{
    public int minEatingSpeed(int[] piles, int h) 
    {
        int n=piles.length, low=1, high=0, totalBananas=0, hours=0;

        for(int i=0; i<n; i++)
        {
            high = Math.max(high, piles[i]);
            totalBananas += piles[i];
        }

        while(low < high)
        {
            int midRate = low + (high - low) / 2;

            for(int i=0; i<n; i++) 
            {
                hours += Math.ceil((double) piles[i] / midRate);
            }
            
            if(hours <= h) high = midRate;
            else low = midRate + 1;
            hours=0;
        }

        return low;
    }
}
