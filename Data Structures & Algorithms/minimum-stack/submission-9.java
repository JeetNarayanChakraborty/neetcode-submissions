class MinStack 
{
    private int[] m;
    private int[] aux;
    private int minElement=Integer.MAX_VALUE;
    private int top=-1;

    public MinStack() 
    {
        m = new int[20];
        aux = new int[20];
    }
    
    public void push(int val) 
    {
        if(top < m.length - 1)
        {
            top++;
            m[top] = val;
            minElement = Math.min(minElement, val);
            aux[top] = minElement;
        }

        else
        {
            m = Arrays.copyOf(m, m.length * 2);
            aux = Arrays.copyOf(aux, aux.length * 2);

            top++;
            m[top] = val;
            minElement = Math.min(minElement, val);
            aux[top] = minElement;
        }
    }
    
    public void pop() 
    {
        m[top] = 0;
        aux[top] = 0;
        top--;

        if(top >= 0) minElement = aux[top]; // Restore the previous minimum
        else minElement = Integer.MAX_VALUE; // Reset completely if stack is empty
    }
    
    public int top() 
    {
        return m[top];
    }
    
    public int getMin() 
    {
        return aux[top];
    }
}




