class Solution 
{
    public String encode(List<String> strs) 
    {
        StringBuilder encodedString = new StringBuilder();

        for(String str : strs)
        {
            encodedString.append(str);
            encodedString.append("---");
        }

        return encodedString.toString();
    }

    public List<String> decode(String str) 
    {
        int i=0, start=0;
        List<String> decodedStrings = new ArrayList<>();

        while(i < (str.length() - 2))
        {
            if(str.substring(i, i+3).equals("---"))
            {
                decodedStrings.add(str.substring(start, i));
                start = i + 3;
            }

            i++;
        }

        return decodedStrings;
    }
}











