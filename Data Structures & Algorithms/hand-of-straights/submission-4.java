class Solution 
{
    public boolean isNStraightHand(int[] hand, int groupSize) 
    {
        int n=hand.length, currSize=1, currNum=0;
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for(int h : hand)
        {
            set.add(h);
            map.put(h, map.getOrDefault(h, 0) + 1);
        }

        for(int i=0; i<n; i++)
        {
            currNum=hand[i];

            if(!set.contains(hand[i] - 1))
            {
                map.put(currNum, map.get(currNum) - 1);

                while(map.containsKey(currNum + 1) && 
                      map.get(currNum + 1) > 0 && currSize < groupSize)
                {
                    currNum++;
                    map.put(currNum, map.get(currNum) - 1);
                    currSize++;
                    //map.put(currNum + 1, map.get(currNum + 1) - 1);
                } 
            }

            if(currSize < groupSize) return false;

            currSize=1;
        }

        return true;
    }
}
