class Solution 
{
    public List<Integer> partitionLabels(String s) 
    {
        int left=0, limit=0;
        Map<Character, Integer> last = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // Store the last occurrence of every character
        for(int i=0; i<s.length(); i++) last.put(s.charAt(i), i);
        
        for(int i=0; i<s.length(); i++) 
        {
            // The partition must extend at least this far
            limit = Math.max(limit, last.get(s.charAt(i)));

            // All characters in this partition end here or before here
            if(i == limit) 
            {
                result.add(i - left + 1);
                left = i + 1;
            }
        }

        return result;
    }
}




