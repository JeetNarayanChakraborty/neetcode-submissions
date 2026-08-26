class Solution 
{
    private String shortestWindow="";
    private String currWindow="";
    private HashSet<Character> set;


    private boolean check(int[] charFreqS1, int[] charFreqS2)
    {
        for(int i=0; i<26; i++)
        {
            if(charFreqs1[i] != charFreqs2[i]) return false;
        }
    
        return true;
    }

    private void calShortestWindow(String s1, String s2, int s1Length, int s2Length)
    {
        int left=0, right=0;
        set = new HashSet<Character>();
        int[] charFreqS1 = new int[26];
        int[] charFreqS2 = new int[26];

        for(int i=0; i<s1Length; i++)
        {
            charFreqS1[s1.charAt(i) - 'a']++;
            set.add(s1.charAt(i));
        }

        while(right < s2Length)
        {
            while(!set.contains(s2.charAt(left))) left++;

            if(check(charFreqS1, charFreqS2))
            {
                if(currWindow.length() < shortestWindow.length())
                {
                    shortestWindow = currWindow;
                }
            }

            currWindow += s2.charAt(right);
            right++;
        }
    }

    public String minWindow(String s, String t) 
    {
        int s1Length=s1.length(), s2Length=s2.length(), left=0, right=s1Length-1;
        if(s1 == null || s2 == null || s1.length() > s2.length()) return "";
        
        calShortestWindow(s, t, s1Length, s2Length);
        return shortestWindow;
    }
}












