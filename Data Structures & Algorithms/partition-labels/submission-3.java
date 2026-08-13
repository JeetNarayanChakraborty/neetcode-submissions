class Solution  
{ 
    public List<Integer> partitionLabels(String s)  
    { 
        int n=s.length(), left=0, currPos=0, limit=0; 
        char startChar=s.charAt(0); 
        Map<Character, Integer> charLastPos = new HashMap<>(); 
        List<Integer> result = new ArrayList<>(); 
 
        for(int i=0; i<n; i++) charLastPos.put(s.charAt(i), i); 
 
        while(currPos < n) 
        { 
            limit = charLastPos.get(startChar); 
 
            while(currPos <= limit) 
            {    
                limit = Math.max(limit, charLastPos.get(s.charAt(currPos)));
                currPos++; 
            } 
 
            currPos--; 
            result.add(currPos - left + 1); 
            currPos++; 
            left = currPos; 
            if(currPos < n) startChar = s.charAt(currPos); 
        } 
 
        return result; 
    } 
}