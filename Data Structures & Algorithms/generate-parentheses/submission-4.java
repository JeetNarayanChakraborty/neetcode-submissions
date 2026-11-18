class Solution 
{
    private List<String> res = new ArrayList<>();

    private void generate(int n, String parenthesis, int openBrackets, int closeBrackets)
    {
        if(openBrackets + closeBrackets == (2 * n))
        {
            res.add(new String(parenthesis));
            return;
        }

        if(openBrackets < n) generate(n, parenthesis+'(', openBrackets+1, closeBrackets);
        if(closeBrackets < openBrackets) generate(n, parenthesis+')', openBrackets, closeBrackets+1);
    }

    public List<String> generateParenthesis(int n) 
    {
        generate(n, "", 0, 0);
        return res;
    }
}
