class Twitter 
{
    private static int timestamp = 0;

    // Linked list node for tweets
    private static class Tweet 
    {
        int id;
        int time;
        Tweet next;

        public Tweet(int id) 
        {
            this.id = id;
            this.time = timestamp++;
            this.next = null;
        }
    }

    private final Map<Integer, Set<Integer>> following;
    private final Map<Integer, Tweet> tweetHeads;

    public Twitter() 
    {
        following = new HashMap<>();  // Maps user -> followed users
        tweetHeads = new HashMap<>(); // Maps user -> newest tweet
    }

    public void postTweet(int userId, int tweetId) 
    {
        // Insert new tweet at head
        Tweet newTweet = new Tweet(tweetId);
        newTweet.next = tweetHeads.get(userId);
        tweetHeads.put(userId, newTweet);
    }

    public List<Integer> getNewsFeed(int userId) 
    {
        List<Integer> feed = new ArrayList<>();
        
        // Get all followed users
        Set<Integer> users = new HashSet<>(following.getOrDefault(userId, Collections.emptySet()));
        users.add(userId); // Include self

        // Max-heap: newest tweets first
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.time, a.time)
        );

        // Add each user's newest tweet
        for(int uid : users) 
        {
            Tweet head = tweetHeads.get(uid);

            if(head != null) 
            {
                maxHeap.offer(head);
            }
        }

        // Grab 10 most recent tweets
        while(!maxHeap.isEmpty() && feed.size() < 10) 
        {
            Tweet latest = maxHeap.poll(); // Pop newest tweet
            feed.add(latest.id);           // Add to feed
            
            // Push next older tweet
            if(latest.next != null) 
            {
                maxHeap.offer(latest.next);
            }
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) 
    {
        // Follow user (ignore self-follow)
        if(followerId != followeeId) 
        {
            following.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) 
    {
        // Remove user from follow list
        Set<Integer> followees = following.get(followerId);

        if(followees != null) 
        {
            followees.remove(followeeId);
        }
    }
}



