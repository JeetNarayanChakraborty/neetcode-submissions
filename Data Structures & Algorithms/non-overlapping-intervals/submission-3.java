class Solution 
{
    public int eraseOverlapIntervals(int[][] intervals) 
    {
        int n=intervals.length, endTime=0, minDeletions=0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        endTime = intervals[0][1];

        for(int i=1; i<n; i++)
        {
            if(intervals[i][0] < endTime) minDeletions++;
            else endTime = intervals[i][1];
        }

        return minDeletions;
    }
}
