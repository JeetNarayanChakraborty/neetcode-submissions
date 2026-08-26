class Solution 
{
    private boolean check(String t, Map<Character, Integer> freqMapT, 
                                    Map<Character, Integer> freqMapS)
    {
        for(int i=0; i<t.length(); i++)
        {
            char c = t.charAt(i);
            if(freqMapT.get(c) != freqMapS.get(c)) return false;
        }

        return true;
    }

    public String minWindow(String s, String t) 
    {
        int n=s.length(), left=0, right=0;
        String minWindowString="";
        Map<Character, Integer> freqMapT = new HashMap<>();
        Map<Character, Integer> freqMapS = new HashMap<>();

        for(int i=0; i<t.length(); i++) 
        {
            freqMapT.put(t.charAt(i), freqMapT.getOrDefault(t.charAt(i), 0) + 1);
        }

        for(int i=0; i<n; i++)
        {
            freqMapS.put(s.charAt(right), freqMapS.getOrDefault(s.charAt(right), 0) + 1);

            if(check(t, freqMapT, freqMapS))
            {
                while(check(t, freqMapT, freqMapS))
                {
                    minWindowString = s.substring(left, right+1);
                    freqMapS.computeIfPresent(s.charAt(left), (k, v) -> v == 1 ? null : v - 1);
                    left++;
                }
            }

            right++;
        }

        return minWindowString;
    }
}





