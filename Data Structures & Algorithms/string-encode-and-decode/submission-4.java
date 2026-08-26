class Solution 
{
    public String encode(List<String> strs) 
    {
        if(strs == null) return "";

        String encodedString="";

        for(int i=0; i<strs.size(); i++)
        {
            encodedString += strs.get(i);
            if(i < strs.size() - 1) encodedString += "____";
        }

        return encodedString;
    }

    public List<String> decode(String str) 
    {
        if(str == null) return new ArrayList<String>();

        int n=str.length(), p1=0, p2=4, start=0;
        List<String> decodedStrings = new ArrayList<>();

        for(int i=0; i<n; i++)
        {
            if(p2 <= n && str.substring(p1, p2).equals("____"))
            {
                String temp = str.substring(start, p1);
                decodedStrings.add(temp);
                start = p2;

                p1 = p2;
                p2 = p1 + 4;
            }

            p1++;
            p2++;
        }

        decodedStrings.add(str.substring(start, n));

        return decodedStrings;
    }
}








