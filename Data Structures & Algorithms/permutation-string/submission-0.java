class Solution 
{
    public boolean checkInclusion(String s1, String s2) 
    {
        int s1Length=s1.length(), s2Length = s2.length(), left=0, right=s1Length-1;

        if(s1 == null || s2 == null || s1.length() > s2.length()) return false;

        int[] charFreqS1 = new int[26];
        int[] charFreqS2 = new int[26];

        for(int i=0; i<s1Length; i++) charFreqS1[s1.charAt(i) - 'a']++;
        for(int i=0; i<s1Length; i++) charFreqS2[s2.charAt(i) - 'a']++;

        while(right < s2Length)
        {
            if(Arrays.equals(charFreqS2, charFreqS1)) return true;
            charFreqS2[s2.charAt(left) - 'a']--;
            left++;
            right++;
            if(right < s2Length) charFreqS2[s2.charAt(right) - 'a']++;
        }

        return false;
    }
}










