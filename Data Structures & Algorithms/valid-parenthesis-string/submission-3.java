class Solution 
{
    public boolean checkValidString(String s) 
    {
        Stack<Character> stack = new Stack<Character>();
        int n=s.length();

        if(s == null || s.length() == 0) return false;

        for(int i=0; i<s.length(); i++)
        {
            if(!stack.isEmpty() && stack.peek() == '(' && s.charAt(i) == '*')
            {
                stack.pop();
            }

            else if(!stack.isEmpty() && stack.peek() == '*' && s.charAt(i) == ')')
            {
                stack.pop();
            }

            else if(!stack.isEmpty() && stack.peek() == '(' && s.charAt(i) == ')')
            {
                stack.pop();
            }

            else
            {
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty();
    }
}
