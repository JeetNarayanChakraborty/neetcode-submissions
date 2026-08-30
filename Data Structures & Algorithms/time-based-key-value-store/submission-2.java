class entry
{
    String value;
    int tStamp;

    public entry(String value, int timestamp)
    {
        this.value = value;
        this.tStamp = timestamp;
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
        store.computeIfAbsent(key, k -> new ArrayList<entry>()).add(new entry(value, timestamp));  
    }
    
    public String get(String key, int timestamp) 
    {
        ArrayList<entry> data = store.get(key);
        if(data == null) return "";
        int n=data.size(), left=0, right=n-1;
        String res="";

        while(left <= right)
        {
            int mid = left + (right - left) / 2;

            if(data.get(mid).tStamp <= timestamp) 
            {
                left = mid + 1;
                res = data.get(mid).value;
            }

            else right = mid - 1;
        }

        return res;
    }
}








