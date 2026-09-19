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

        for(int i=0; i<m.length; i++) m[i] = Integer.MIN_VALUE;
    }
    
    public void push(int val) 
    {
        if(top < m.length)
        {
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
        if(top >= 0) minElement = aux[top];
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




