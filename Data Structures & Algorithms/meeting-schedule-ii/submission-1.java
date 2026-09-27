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
        int n=intervals.size(), minRooms=0, currEnd=0, currRooms=1;
        if(n == 0) return 0;
        if(n == 1) return 1;

        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        currEnd = intervals.get(0).end;

        for(int i=1; i<n; i++)
        {
            if(intervals.get(i).start < currEnd)
            {
                currRooms++;
                minRooms = Math.max(minRooms, currRooms);
                //System.out.println("intervals.get(i).start: " + intervals.get(i).start);
               // System.out.println("currEnd: " + currEnd);
            }

            else
            {
                currEnd = intervals.get(i).end;
                currRooms=1;
            }
        }

        return minRooms;
    }
}









