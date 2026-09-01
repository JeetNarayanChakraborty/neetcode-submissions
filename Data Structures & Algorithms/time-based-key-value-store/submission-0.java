class entry
{
    String value;
    int timestamp;

    public entry(String value, int timestamp)
    {
        this.value = value;
        this.timestamp = timestamp;
    }
}

class TimeMap 
{
    Map<String, ArrayList<entry>> store;

    public TimeMap() 
    {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) 
    {
        store.computeIfAbsent(k -> new ArrayList<entry>()).add(new entry(value, timestamp));  
    }
    
    public String get(String key, int timestamp) 
    {
        int n=store.size(), left=0, right=n-1;





        
    }
}








