/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution 
{
    public int minMeetingRooms(List<Interval> intervals) 
    {
        int n=intervals.size(), minRooms=1, currEnd=0;
        if(n == 0) return 0;
        if(n == 1) return 1;

        Collections.sort(intervals, (a, b) -> Integer.compare(a.end, b.end));

        for(int i=1; i<n; i++)
        {
            if(intervals.get(i).start < intervals.get(i-1).end) minRooms++;
        }

        return minRooms;
    }
}









