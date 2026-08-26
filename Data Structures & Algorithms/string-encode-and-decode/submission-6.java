class Solution 
{
    public String encode(List<String> strs) 
    {
        if(strs == null) return "";
        String encodedString="";

        for(String str : strs)
        {
            int length = str.length();
            encodedString += Character.forDigit(length, 10);
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
            int l = Character.getNumericValue(str.charAt(start));
            String s = str.substring(start + 2, start + 2 + l);
            decodedStrings.add(s);
            start = start + 2 + l;

            if(start >= n) break;
        }

        return decodedStrings;
    }
}








