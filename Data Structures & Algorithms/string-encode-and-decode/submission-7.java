class Solution 
{
    public String encode(List<String> strs) 
    {
        if(strs == null) return "";
        String encodedString="";

        for(String str : strs)
        {
            int length = str.length();
            encodedString += length;         
            encodedString += '#';
            encodedString += str;            
        }

        return encodedString;
    }

    public List<String> decode(String str) 
    {
        if(str == null) return null;

        int n=str.length(), start=0;
        List<String> decodedStrings = new ArrayList<>();

        for(int i=0; i<n; i++)
        {
            int delimiterIndex = str.indexOf('#', start);                         
            int l = Integer.parseInt(str.substring(start, delimiterIndex));       
            String s = str.substring(delimiterIndex + 1, delimiterIndex + 1 + l); 
            decodedStrings.add(s);
            start = delimiterIndex + 1 + l;                                      

            if(start >= n) break;
        }

        return decodedStrings;
    }
}