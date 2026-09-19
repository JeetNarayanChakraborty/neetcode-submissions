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

        for(int i=0; i<m.length; i++) m[i] = Integer.MAX_VALUE;
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
        if(top >= 0) minElement = Integer.MAX_VALUE;
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




