class Solution 
{
    public int characterReplacement(String s, int k) 
    {
        int n=s.length(), left=0, right=1, longestSubstring=0, usedReplacements=0;
        char currentChar=s.charAt(left);

        while(right < n-1)
        {
            if(s.charAt(right) == currentChar)
            {
                longestSubstring = Math.max(longestSubstring, right - left + 1);
            }

            else if(s.charAt(right) != currentChar && usedReplacements < k)
            {
                longestSubstring = Math.max(longestSubstring, right - left + 1);
                usedReplacements++;
            }

            else
            {
                left = right;
                currentChar=s.charAt(left);
            }

            right++;
        }

        return longestSubstring;
    }
}
