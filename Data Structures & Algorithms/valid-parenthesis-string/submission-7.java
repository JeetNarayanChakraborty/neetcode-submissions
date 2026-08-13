class Solution 
{
    public boolean checkValidString(String s) 
    {
        int minOpen = 0; // minimum possible unmatched '('
        int maxOpen = 0; // maximum possible unmatched '('

        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i) == '(') // '(' definitely increases the number of open brackets
            {
                minOpen++;
                maxOpen++;
            }

            else if(s.charAt(i) == ')') // ')' definitely closes one open bracket
            {
                minOpen--;
                maxOpen--;
            }

            else // s.charAt(i) == '*'
            {
                minOpen--; // if '*' close bracket, number decrease
                maxOpen++; // if '*' open bracket, number increase
            }

            // if more ')' than '(' return false.
            if(maxOpen < 0) return false;

            // minOpen can become negative because '*' might be acting as ')'.
            // We cannot have fewer than 0 unmatched '(',
            // so reset it to 0.
            if(minOpen < 0) minOpen = 0;
        }

        // If the minimum possible unmatched '(' is 0,
        // there is at least one way to make the string valid.
        return minOpen == 0;
    }
}