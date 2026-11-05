class Solution 
{
    public int[][] merge(int[][] intervals) 
    {
        int n=intervals.length, startTime, endTime=0;
        List<int[]> res = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        startTime = intervals[0][0];
        endTime = intervals[0][1];

        for(int i=1; i<n; i++)
        {
            if(intervals[i][0] <= endTime)
            {
               // System.out.println("intervals[i][0] :" + intervals[i][0]);
               // System.out.println("endTime :" + endTime);


                startTime = Math.min(startTime, intervals[i][0]);
                endTime = Math.max(endTime, intervals[i][1]);

              //  System.out.println("startTime :" + startTime);
               // System.out.println("endTime :" + endTime);

            }

            else
            {
                res.add(new int[]{startTime, endTime});

                startTime = intervals[i][0];
                endTime = intervals[i][1];
            }
        }

        res.add(new int[]{startTime, endTime});

        return res.toArray(int[][]::new);
    }
}
