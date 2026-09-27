class Solution  
{ 
    public int minMeetingRooms(List<Interval> intervals)  
    { 
        int n=intervals.size();
        if(n == 0) return 0;
        
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        int minRooms=0;
        List<Integer> endTimes = new ArrayList<>();
        
        for(Interval meeting : intervals)
        {
            // Remove meetings whose rooms are now free
            endTimes.removeIf(end -> end <= meeting.start);

            // Current meeting needs a room
            endTimes.add(meeting.end);

            minRooms = Math.max(minRooms, endTimes.size());
        }

        return minRooms;
    }
}







