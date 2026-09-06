class Solution 
{
    public int countSubstrings(String s) 
    {
        int n=s.length();
        if(n <= 1) return n;

        int totalSubStrings=0;
        boolean[][] dp = new boolean[n][n];

        for(int len=1; len<=n; len++) 
        {
            for(int i=0; i+len-1<n; i++) 
            {
                int j = i + len - 1;

                // Case 1: One character
                if(len == 1) 
                {
                    dp[i][j] = true;
                    totalSubStrings++;
                }

                // Case 2: Two characters
                else if(len == 2) 
                {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                    if(dp[i][j]) totalSubStrings++;
                }
            
                // Case 3: Three or more characters
                else 
                {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
                    if(dp[i][j]) totalSubStrings++;
                }
            }
        }

        return totalSubStrings;
    }
}





