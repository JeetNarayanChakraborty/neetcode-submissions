class Solution 
{
    public int canCompleteCircuit(int[] gas, int[] cost) 
    {
        int n=gas.length, currGas=0, startingIndex=-1;
        boolean canComplete=false;

        for(int i=0; i<n; i++)
        {
            int j = i;

            while(!canComplete)
            {
                currGas += gas[j];
                currGas -= cost[j];

                if(currGas < 0) 
                {
                    currGas = 0;
                    break;
                }

                j = (j + 1) % n;

                if(j == i)
                {
                    canComplete = true;
                    startingIndex = i;

                }
            }

            if(canComplete) break;
        }

        return startingIndex;
    }
}
