class Solution 
{
    public int minEatingSpeed(int[] piles, int h) 
    {
        int n=piles.length, low=0, high=0, totalBananas=0, hours=0;

        for(int i=0; i<n; i++)
        {
            high = Math.max(high, piles[i]);
            totalBananas++;
        }

        while(low < high)
        {
            int mid = low + (high - low) / 2;

            for(int i=0; i<n; i++) 
            {
                hours += Math.ceil((double) piles[i] / mid);
            }

            if(hours <= h) high = mid;
            else low = mid + 1;
            hours=0;
        }

        return low;
    }
}
