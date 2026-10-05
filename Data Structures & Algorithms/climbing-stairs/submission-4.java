class Solution
{
    HashMap<Integer, Integer> memo = new HashMap<>();

    public int climbStairs(int n)
    {
        if(n == 0 || n == 1) return 1; // if there is 0 or 1 step, there is only one way to climb it
        if(memo.containsKey(n)) return memo.get(n); //check for n steps, the answer is present in store

        int ans = climbStairs(n - 1) + climbStairs(n - 2); // compute the answer and store 
        memo.put(n, ans); 

        return ans; // return the answer
    }
}