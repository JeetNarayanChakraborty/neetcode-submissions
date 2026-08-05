class Solution 
{
    public int[] dailyTemperatures(int[] temperatures) 
    {
        int n=temperatures.length;
        int[] result = new int[n];

        if(n == 0) return result;

        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0; i<n; i++)
        {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()])
            {
                int temp = stack.pop();
                result[temp] = i - temp;
            }

            stack.push(i);
        }

        while(!stack.isEmpty())
        {
            result[stack.pop()] = 0;
        }

        return result;
    }
}
