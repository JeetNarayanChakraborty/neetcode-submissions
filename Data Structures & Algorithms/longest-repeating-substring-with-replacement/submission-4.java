class Solution 
{
    public int characterReplacement(String s, int k) 
    {
        int[] freq = new int[26];

        int left = 0;
        int maxFreq = 0;
        int longest = 0;

        for(int right=0; right<s.length(); right++)
        {
            // Add current character
            freq[s.charAt(right) - 'A']++;

            // Update highest frequency in current window
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            // If replacements needed > k, shrink window
            while((right - left + 1) - maxFreq > k)
            {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            // Update answer
            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }
}