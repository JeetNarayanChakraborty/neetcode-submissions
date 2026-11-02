class Solution 
{
    private Map<Integer, Integer> map = 
                                  new TreeMap<>((a, b) -> b.compareTo(a));

    public int carFleet(int target, int[] position, int[] speed) 
    {
        int n=position.length, fleets=1, counter=0;
        double arrivalTime=0.0;

        for(int i=0; i<n; i++) map.put(position[i], speed[i]);

        for(Map.Entry<Integer, Integer> e : map.entrySet())
        {
            if(counter == 0)
            {
                arrivalTime = (target - e.getKey()) / e.getValue();
            }

            else
            {
                double currArrivalTime = (double) (target - e.getKey()) / e.getValue();

                if(currArrivalTime > arrivalTime) 
                {
                    fleets++;
                    arrivalTime = currArrivalTime;
                }
            }

            counter++;
        }

        return fleets;
    }
}
