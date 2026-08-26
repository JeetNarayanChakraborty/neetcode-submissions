class Solution 
{
    public int characterReplacement(String s, int k) 
    {
        int n=s.length(), left=0, right=0, longestSubstring=0, usedReplacements=0, currSize=1;

        while(right < n-1)
        {
            if(s.charAt(right) == s.charAt(right+1)) currSize++;
            
            else if(s.charAt(right) != s.charAt(right+1) && usedReplacements < k)
            {
                currSize++;
                usedReplacements++;

                if(right < n - 2 && s.charAt(right) == s.charAt(right+2)) right++;
            }

            else currSize = 1;

            longestSubstring = Math.max(longestSubstring, currSize);
            right++;
        }

        return longestSubstring;
    }
}
