class Solution 
{
    public boolean isNStraightHand(int[] hand, int groupSize) 
    {
        int n=hand.length, currSize=1, currNum=0, currTotal=0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int h : hand)
        {
            map.put(h, map.getOrDefault(h, 0) + 1);
        }

        for(int i=0; i<n; i++)
        {
            currNum=hand[i];

            if(!map.containsKey(hand[i] - 1) || map.get(hand[i] - 1) == 0)
            {
                map.put(currNum, map.get(currNum) - 1);

                while(map.containsKey(currNum + 1) && 
                      map.get(currNum + 1) > 0 && currSize < groupSize)
                {
                    currNum++;
                    map.put(currNum, map.get(currNum) - 1);
                    currSize++;
                }
            }

            if(currSize == groupSize) currTotal += currSize;

            currSize=1;
        }

        return (currTotal == n);
    }
}
