class Solution 
{
    public boolean wordBreak(String s, List<String> wordDict) 
    {
        int n=s.length(), left=0, right=0, totalLength=0, currLength=0;
        Set<String> set = new HashSet<>();
        
        set.addAll(wordDict);

        while(right < n)
        {
            String str = s.substring(left, right+1);
            currLength = right - left + 1;

            if(set.contains(str))
            {
                totalLength += currLength;
                currLength = 0;
                left = right + 1;
            }
            
            right++;
        }

        return totalLength == n;
    }
}
