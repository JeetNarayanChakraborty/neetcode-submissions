class Solution 
{
    public int characterReplacement(String s, int k) 
    {
        int n=s.length(), left=0, right=0;
        int currWindowMaxFreq=0, res=0;
        int[] charFreq = new int[26];

        while(right < n)
        {
            charFreq[s.charAt(right) - 'A']++;
            currWindowMaxFreq = Math.max(currWindowMaxFreq, charFreq[s.charAt(right) - 'A']);

            while(((right - left + 1) - currWindowMaxFreq) > k)
            {
                charFreq[s.charAt(left) - 'A']--;
                left++;
            }

            res = Math.max(res, right - left + 1);

            right++;
        }

        return res;
    }
}
