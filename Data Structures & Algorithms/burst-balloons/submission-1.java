class Solution 
{
    public int maxCoins(int[] nums) 
    {
        int n=nums.length, maxCoins=0, t=0;
        ArrayList<Integer> elem = new ArrayList<>();

        if(n == 0) return 0;

        for(int i=0; i<n; i++) elem.add(nums[i]);

        for(int i=0; i<n; i++)
        {
            int max=0, j=0, ind=0;

            while(j < n-t)
            {
                int left=0, mid=0, right=0;

                left = (j-1 < 0) ? left = 1 : elem.get(j-1);
                right = (j+1 == n-t) ? right = 1 : elem.get(j+1);
                mid = elem.get(j);

                int coins = left * mid * right;

                if(coins > max)
                {
                    max = coins;
                    ind = j;
                }

                j++;
            }

            elem.remove(ind);
            t++;

            maxCoins += max;
        }
        
        return maxCoins;
    }
}
