class Solution 
{
    public int carFleet(int target, int[] position, int[] speed) 
    {
        int n=speed.length, fleets=0;
        Map<Integer, Integer> map = new TreeMap<>();
        List<Integer> sortedSpeed = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<position.length; i++)
        {
            map.put(position[i], i);
        }

        for(var e : map.entrySet())
        {
            sortedSpeed.add(speed[e.getValue()]);
        }

        for(int sp : sortedSpeed)
        {
            if(!stack.isEmpty() && stack.peek() < sp) stack.push(sp);
            else stack.push(sp);
        }

        return stack.size()-1;
    }
}
