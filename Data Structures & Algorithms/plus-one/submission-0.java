class Solution 
{
    public int[] plusOne(int[] digits) 
    {
        int n=digits.length; 
        long num = digits[0];
        ArrayList<Long> dig = new ArrayList<>();

        for(int i=1; i<n; i++)
        {
            num *= 10;
            num += digits[i];
        }

        num++;

        for(int i=n-1; i>=0; i--) 
        {
            dig.add(num % 10);
            num /= 10;
        }

        Collections.reverse(dig);

        return dig.stream().mapToInt(Long::intValue).toArray();
    }
}
