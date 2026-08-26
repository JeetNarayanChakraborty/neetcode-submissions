class Solution 
{
    public int[][] merge(int[][] intervals) 
    {
        int n=intervals.length, start=0, end=0;
        List<int[]> mergedIntervals = new ArrayList<>();


        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        start = intervals[0][0];
        end = intervals[0][1];

        for(int i=1; i<n; i++)
        {
            if(intervals[i][0] <= end)
            {
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            }

            else
            {
                mergedIntervals.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        
        mergedIntervals.add(new int[]{start, end});

        return mergedIntervals.toArray(int[][]::new); 
    }
}









