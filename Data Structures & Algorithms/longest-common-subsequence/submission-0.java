class Solution 
{
    private int[][] dp;

    private int calLongestCommonSubsequence(String text1, int m, String text2, int n)
    {
        for(int i=1; i<=m; i++)
        {
            for(int j=1; j<=n; j++)
            {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) 
                {
                    dp[i][j] = dp[i - 1][j - 1] + 1; // chars match
                } 
                
                else 
                {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // take best of skip one
                }
            }
        }

        return dp[m][n];
    }

    public int longestCommonSubsequence(String text1, String text2) 
    {
        int m=text1.length(), n=text2.length();
        dp = new int[m+1][n+1];

        return calLongestCommonSubsequence(text1, m, text2, n);
    }
}
