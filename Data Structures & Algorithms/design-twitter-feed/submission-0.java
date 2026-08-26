class Twitter 
{
    Map<Integer, ArrayList<Integer>> userTweets;
    Map<Integer, ArrayList<Integer>> userFollowing;

    public Twitter() 
    {
        userTweets = new HashMap<>();
        userFollowing = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) 
    {
        userTweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) 
    {

        
    }
    
    public void follow(int followerId, int followeeId) 
    {
        userFollowing.computeIfAbsent(followerId, k -> new ArrayList<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) 
    {
        

    }
}










