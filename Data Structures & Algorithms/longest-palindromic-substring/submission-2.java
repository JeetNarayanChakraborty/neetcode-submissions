class Solution 
{
    public String longestPalindrome(String s) 
    {
        int start=0, n=s.length(), len=0, currSize=1;
        if(n <= 1) return s;
        String res="";
        boolean[][] dp = new boolean[n][n];

        for(len=1; len<=n; len++)
        {
            for(int i=0; i+len-1<n; i++)
            {
                int j = i + len - 1;

                if(len == 1)
                {
                    dp[i][j] = true;
                }

                else if(len == 2)
                {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }

                else
                {
                    dp[i][j] = dp[i+1][j-1] && (s.charAt(i) == s.charAt(j));
                }

                if(dp[i][j] && (len > currSize))
                {
                    currSize = len;
                    start = i;
                }
            }
        }

        return s.substring(start, start + currSize);
    }
}
