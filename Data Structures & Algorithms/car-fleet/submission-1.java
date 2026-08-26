class Solution 
{
    public int carFleet(int target, int[] position, int[] speed) 
    {
        int p=0, n=speed.length, fleets=0;
        Map<Integer, Integer> map = new TreeMap<>();
        List<Integer> sortedSpeed = new ArrayList<>();

        for(int i=0; i<position.length; i++)
        {
            map.put(position[i], i);
        }

        for(var e : map.entrySet())
        {
            sortedSpeed.add(speed[e.getValue()]);
        }

        while(p < n - 1)
        {
            if(speed[p] >= speed[p+1])
            {
                while(p < n - 1 && speed[p] >= speed[p+1]) p++;
                fleets++;
            }

            p++;
        }

        return fleets;
    }
}
