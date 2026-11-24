class Solution 
{
    // Map digits 0-9 to their corresponding letters
    private static final String[] KEYPAD = {"", "", "abc", 
                                            "def", "ghi", "jkl", 
                                            "mno", "pqrs", "tuv", "wxyz"};

    private void backtrack(String digits, int index, StringBuilder current, List<String> result) 
    {
        // one letter for every digit picked
        if(index == digits.length()) 
        {
            result.add(current.toString());
            return;
        }

        // Get letters for the current digit (e.g., '2' -> "abc")
        String letters = KEYPAD[digits.charAt(index) - '0'];

        // Try each letter, move to the next digit, then backtrack
        for(char letter : letters.toCharArray()) 
        {
            current.append(letter);                      
            backtrack(digits, index+1, current, result); 
            current.deleteCharAt(current.length() - 1);  
        }
    }

    public List<String> letterCombinations(String digits) 
    {
        List<String> result = new ArrayList<>();

        if(digits == null || digits.isEmpty()) return result;
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }
}






