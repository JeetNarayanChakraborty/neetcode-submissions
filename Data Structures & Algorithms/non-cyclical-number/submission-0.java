class Solution 
{
    private int num;
    private Set<Integer> seen = new HashSet<>();

    private void calSumOfSquareOfDigits()
    {
        int sum=0;

        while (num > 0) 
        {
            int digit = num % 10;     
            sum += digit * digit;    
            num /= 10;                 
        }

        num = sum;
    }

    public boolean isHappy(int n) 
    {
        num=n;

        while(num != 1)
        {
            seen.add(num);
            calSumOfSquareOfDigits();
            if(seen.contains(num)) break;
        }

        return num == 1;
    }
}
