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
        int n=data.size(), left=0, right=n-1, currDiff=Integer.MAX_VALUE;
        String res="";

        while(left < right)
        {
            int mid = left + (right - left) / 2;
            int diff = data.get(mid).tStamp - timestamp;

            if(diff < currDiff) 
            {
                currDiff = diff;
                res = data.get(mid).value;
            }

            else if(diff > 0) left = mid + 1;
            else right = mid - 1;
        }

        return res;
    }
}








