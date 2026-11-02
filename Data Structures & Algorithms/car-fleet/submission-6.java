class Solution 
{
    private Map<Integer, Integer> map = 
                                  new TreeMap<>((a, b) -> b.compareTo(a));

    public int carFleet(int target, int[] position, int[] speed) 
    {
        int n=position.length, currentSpeed=0, fleets=0, counter=0;

        for(int i=0; i<n; i++) map.put(position[i], speed[i]);

        for(int s : map.values())
        {
            currentSpeed = s;
            fleets = 1;

            if(counter > 0)
            {
                if(s <= currentSpeed)
                {
                    fleets++;
                    currentSpeed = s;
                }
            }

            counter++;
        }

        return fleets;
    }
}
