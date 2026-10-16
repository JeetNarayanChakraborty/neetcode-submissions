class Solution 
{
    private List<String> allParenthesisCombination = new ArrayList<>();

    private void generate(int n, int openBrackets, 
                          int closedBrackets, String currCombination)
    {
        if(currCombination.length() == (2 * n))
        {
            allParenthesisCombination.add(new String(currCombination));
        }

        if(openBrackets < n)
        {
            generate(n, openBrackets + 1, closedBrackets, currCombination + "(");
        }

        if(closedBrackets < openBrackets)
        {
            generate(n, openBrackets, closedBrackets + 1, currCombination + ")");
        }
    }

    public List<String> generateParenthesis(int n) 
    {
        generate(n, 0, 0, "");
        return allParenthesisCombination;
    }
}
