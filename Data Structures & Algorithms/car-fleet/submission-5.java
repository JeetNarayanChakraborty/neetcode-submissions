class Solution 
{
    public int carFleet(int target, int[] position, int[] speed) 
    {
        // position -> time to reach target
        TreeMap<Integer, Double> map = new TreeMap<>();

        for(int i=0; i<position.length; i++) 
        {
            double time = (double)(target - position[i]) / speed[i];
            map.put(position[i], time);
        }

        int fleets = 0;
        double maxTime = 0;

        // Traverse from closest car to farthest
        for(double time : map.descendingMap().values()) 
        {

            // New fleet
            if(time > maxTime) 
            {
                fleets++;
                maxTime = time;
            }
        }

        return fleets;
    }
}


