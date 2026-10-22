class Solution 
{
    public boolean wordBreak(String s, List<String> wordDict) 
    {
        int n=s.length();
        Set<String> set = new HashSet<>(wordDict); 
        boolean[] dp = new boolean[n + 1]; // dp[i] is true if s[0 to i-1] can be segmented into valid words

        dp[0] = true; // empty string is valid

        for(int i=1; i<=n; i++) 
        {
            for(int j=0; j<i; j++) 
            {
                // If prefix (0 to j-1) is valid AND remaining j to i-1 is in dict
                if(dp[j] && set.contains(s.substring(j, i))) 
                {
                    dp[i] = true;
                    break; // Found a valid split for length i, move to next i
                }
            }
        }

        return dp[n];
    }
}
