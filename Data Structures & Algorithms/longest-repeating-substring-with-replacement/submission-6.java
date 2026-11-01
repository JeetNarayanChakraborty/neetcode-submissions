class Solution 
{
    private int[] charFreq = new int[26];

    public int characterReplacement(String s, int k) 
    {
        int n=s.length(), left=0, right=0, currWindowMaxFreq=0, longestSubstring=0;

        while(right < n)
        {
            charFreq[s.charAt(right) - 'A']++;
            currWindowMaxFreq = Math.max(currWindowMaxFreq, charFreq[s.charAt(right) - 'A']);

            while((right - left + 1) - currWindowMaxFreq > k)
            {
                charFreq[s.charAt(left) - 'A']--;
                left++;
            }

            longestSubstring = Math.max(longestSubstring, right - left + 1);

            right++;
        }

        return longestSubstring;
    }
}
