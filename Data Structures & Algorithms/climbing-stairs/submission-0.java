class Solution 
{
    public int climbStairs(int n) 
    {
        if(n == 0 || n == 1) return 1;
        else if(n == 2) return 2;
        else return 1 + climbStairs(n - 1);
    }
}
