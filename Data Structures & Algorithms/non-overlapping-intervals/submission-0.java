class Solution 
{
    public int eraseOverlapIntervals(int[][] intervals) 
    {
        int lastIntervalBoundary=0, minDeletions=0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        for(int[] interval : intervals)
        {
            if(interval[0] < lastIntervalBoundary) minDeletions++;
            else lastIntervalBoundary = interval[1];
        }

        return minDeletions;
    }
}
