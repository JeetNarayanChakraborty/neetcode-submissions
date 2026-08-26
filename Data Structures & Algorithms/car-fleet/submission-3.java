class Solution 
{
    public int carFleet(int target, int[] position, int[] speed) 
    {
        int n=speed.length, fleets=0, maxNum=0;
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
            if(!stack.isEmpty() && maxNum < sp) 
            {
                stack.push(sp);
                maxNum = Math.max(maxNum, sp);
            }

            else 
            {
                stack.push(sp);
                maxNum = Math.max(maxNum, sp);
            }
        }

        return stack.size();
    }
}
