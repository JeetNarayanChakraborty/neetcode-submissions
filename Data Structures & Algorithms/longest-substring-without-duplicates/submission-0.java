class Solution 
{
    public int lengthOfLongestSubstring(String s) 
    {
        int n=s.length(), left=0, right=0, maxLength=0;
        int[] freq = new int[26];

        while(right < n)
        {
            freq[s.charAt(right) - 'a']++;

            while(freq[s.charAt(right) - 'a'] > 1)
            {
                freq[s.charAt(left) - 'a']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);

            right++;
        }

        return maxLength;
    }
}
