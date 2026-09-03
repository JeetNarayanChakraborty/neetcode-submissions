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
               // System.out.println("i value :" + i);
                //System.out.println("j value :" + j);

                currGas += gas[j];
                currGas -= cost[j];

               // System.out.println("curr gas value :" + currGas);

                if(currGas < 0) 
                {
                    currGas = 0;
                    break;
                }

                j = (j + 1) % n;

               // System.out.println("i value :" + i);
                //System.out.println("j value :" + j);

                if(j == i)
                {
                    canComplete = true;
                    startingIndex = i;

                }
            }
        }

        return startingIndex;
    }
}
