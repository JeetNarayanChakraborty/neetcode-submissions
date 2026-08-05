class Solution 
{
    public int lengthOfLongestSubstring(String s) 
    {
        int n=s.length(), left=0, right=0, maxLength=0;
        int[] freq = new int[128];

        while(right < n)
        {
            freq[s.charAt(right)]++;

            while(freq[s.charAt(right)] > 1)
            {
                freq[s.charAt(left)]--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);

            right++;
        }

        return maxLength;
    }
}
