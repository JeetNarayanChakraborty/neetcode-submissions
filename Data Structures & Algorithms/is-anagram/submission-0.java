class Solution 
{
    public boolean isAnagram(String s, String t) 
    {
        char[] chars1 = s.toCharArray();
        Arrays.sort(chars1);
        s = new String(chars1);
        
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars2);
        t = new String(chars2);

        return s.equals(t);
    }
}
