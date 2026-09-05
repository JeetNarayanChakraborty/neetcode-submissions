class Solution 
{
    public String longestPalindrome(String s) 
    {
        int n=s.length();
        if(n <= 1) return s;

        boolean[][] dp = new boolean[n][n];
        int start=0, maxLength=1;

        // len = length of the substring
        for(int len=1; len<=n; len++) 
        {
            for(int i=0; i+len-1<n; i++) 
            {
                int j = i + len - 1;

                // Case 1: One character
                if(len == 1) dp[i][j] = true;

                // Case 2: Two characters
                else if(len == 2) dp[i][j] = (s.charAt(i) == s.charAt(j));
            
                // Case 3: Three or more characters
                else 
                {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
                }

                // Found a longer palindrome
                if(dp[i][j] && len > maxLength) 
                {
                    start = i;
                    maxLength = len;
                }
            }
        }

        return s.substring(start, start + maxLength);
    }
}









