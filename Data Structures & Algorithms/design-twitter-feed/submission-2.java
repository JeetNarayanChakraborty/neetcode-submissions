public class userDetails
{
    Long timeStamp;
    int userID;
    int tweetID;

    public userDetails(Long timeStamp, int userID, int tweetID)
    {
        this.timeStamp = timeStamp;
        this.userID = userID;
        this.tweetID = tweetID;
    }
}

class Twitter 
{
    Map<Integer, HashSet<Integer>> userTweets;
    Map<Integer, HashSet<Integer>> userFollowing;
    PriorityQueue<userDetails> allPosts;

    public Twitter() 
    {
        userTweets = new HashMap<>();
        userFollowing = new HashMap<>();
        allPosts = new PriorityQueue<>
                      ((a, b) -> Long.compare(b.timeStamp, a.timeStamp));
    }
    
    public void postTweet(int userId, int tweetId) 
    {
        userTweets.computeIfAbsent(userId, k -> new HashSet<>()).add(tweetId);
        allPosts.add(new userDetails(System.currentTimeMillis(), userId, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) 
    {
        int l = allPosts.size();
        ArrayList<userDetails> details = new ArrayList<>();
        ArrayList<Integer> recentTweets = new ArrayList<>();
        
        for(int i=0; i<l; i++)
        {
            userDetails ud = allPosts.poll();
            details.add(ud);

            if(userFollowing.containsKey(userId) && 
               userFollowing.get(userId).contains(ud.userID)
               && recentTweets.size() < 10)
            {
                recentTweets.add(ud.tweetID);
            }
        }

        for(userDetails d : details) allPosts.add(d);

        return recentTweets;
    }
    
    public void follow(int followerId, int followeeId) 
    {
        userFollowing.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) 
    {
        if(userFollowing.containsKey(followerId))
        {
            if(userFollowing.get(followerId).contains(followeeId)) 
            {
                userFollowing.get(followerId).remove(followeeId);
            }
        }
    }
}










