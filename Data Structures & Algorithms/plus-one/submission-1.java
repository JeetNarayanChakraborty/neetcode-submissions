class Solution 
{
    public int[] plusOne(int[] digits) 
    {
        int n=digits.length, carry=0, currIndx=n-1, resultingDigit=0;
        ArrayList<Integer> num = new ArrayList<>();

        resultingDigit = digits[n-1] + 1;

        while(resultingDigit > 9)
        {
            num.add(0);
            carry = 1;
            if(currIndx >= 0) currIndx--;

            resultingDigit = carry + digits[currIndx];
        }

        if(currIndx == n - 1) num.add(resultingDigit);
        else num.add(carry + digits[currIndx]);
        currIndx--;

        while(currIndx >= 0)
        {
            num.add(digits[currIndx]);
            currIndx--;
        }

        Collections.reverse(num);

        return num.stream().mapToInt(Integer::intValue).toArray();
    }
}






