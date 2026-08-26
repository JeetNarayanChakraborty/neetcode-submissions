class Solution 
{
    public int[][] insert(int[][] intervals, int[] newInterval) 
    {
        int n=intervals.length, insertionIndex=0;
        boolean taken=false;
        List<int[]> mergedIntervals = new ArrayList<>();


        for(int i=0; i<n-1; i++)
        {
            if(newInterval[0] > intervals[i][0] && newInterval[0] < intervals[i+1][0])
            {
                if(newInterval[0] < intervals[i][1] && newInterval[1] < intervals[i+1][0])
                {
                    mergedIntervals.add(new int[]{intervals[i][0], newInterval[1]});
                }

                else if(newInterval[1] > intervals[i+1][0] && newInterval[0] > intervals[i][1])
                {
                    mergedIntervals.add(new int[]{intervals[i][0], intervals[i][1]});
                    mergedIntervals.add(new int[]{newInterval[0], intervals[i+1][1]});
                    taken = true;
                }

                else if(newInterval[0] < intervals[i][1] && newInterval[1] > intervals[i+1][0])
                {
                    mergedIntervals.add(new int[]{intervals[i][0], intervals[i+1][1]});
                    taken = true;
                }

                else
                {
                    mergedIntervals.add(new int[]{intervals[i][0], intervals[i][1]});
                    mergedIntervals.add(new int[]{newInterval[0], newInterval[1]});
                }
            }

            else
            {
                mergedIntervals.add(new int[]{intervals[i][0], intervals[i][1]});
            }
        }

        if(!taken)
        {
            mergedIntervals.add(new int[]{intervals[n-1][0], intervals[n-1][1]});
        }


        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}








