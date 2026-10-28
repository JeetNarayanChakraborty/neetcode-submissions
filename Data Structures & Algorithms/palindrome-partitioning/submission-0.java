class Solution 
{
    private List<List<String>> res = new ArrayList<>();

    private boolean isPalindrome(String s)
    {
        int left=0, right=s.length()-1;

        while(left < right)
        {
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }

    private void doPartition(String s, int n, int charsUsed, int start,
                             ArrayList<String> combination)
    {
        if(charsUsed == n)
        {
            res.add(new ArrayList<>(combination));
            return;
        }

        for(int i=start; i<n; i++)
        {
            if(isPalindrome(s.substring(0, i)))
            {
                combination.add(new String(s.substring(0, i)));
                doPartition(s, n, charsUsed+i+1, i+1, combination);
                combination.remove(combination.size()-1);
            }

            else
            {
                doPartition(s, n, charsUsed, i+1, combination);
            }
        }
    }

    public List<List<String>> partition(String s) 
    {
        int n=s.length();
        doPartition(s, n, 0, 0, new ArrayList<>());
        return res;
    }
}
