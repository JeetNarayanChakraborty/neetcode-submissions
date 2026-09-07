class Solution 
{
    public int numDecodings(String s) 
    {
        int n=s.length();
        if(n == 1 && s.charAt(0) == '0') return 0;
        if(n <= 1) return n;

        int[][] dp = new int[n][n];

        for(int len=1; len<=n; len++) 
        {
            for(int i=0; i+len-1<n; i++) 
            {
                int j = i + len - 1;

                // Case 1: One character
                if(len == 1) 
                {
                    if(s.charAt(i) == '0') dp[i][j] = 0;
                    else dp[i][j] = 1;
                }

                // Case 2: Two characters
                else if(len == 2) 
                {
                    dp[i][j] = 0;

                    // Last character can be decoded by itself
                    if(s.charAt(j) != '0') dp[i][j] += dp[i][j-1];

                    // Last two characters can be decoded together
                    String t = s.substring(i, j+1);
                    int num = Integer.parseInt(t); 

                    if(num >= 10 && num <= 26) dp[i][j] += 1;
                }
            
                // Case 3: Three or more characters
                else 
                {
                    dp[i][j] = 0;

                    // Last character
                    if(s.charAt(j) != '0') dp[i][j] += dp[i][j-1];

                    // Last two characters
                    String t = s.substring(j-1, j+1);
                    int num = Integer.parseInt(t);

                    if(num >= 10 && num <= 26) dp[i][j] += dp[i][j-2];
                }
            }
        }

        return dp[0][n-1];
    }
}






