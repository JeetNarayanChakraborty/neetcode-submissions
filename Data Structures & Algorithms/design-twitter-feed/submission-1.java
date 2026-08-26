public class userDetails
{
    Long timeStamp;
    Map<Integer, HashSet<Integer>> tweets = new HashMap<>();

    public userDetails(Long timeStamp, Map<Integer, HashSet<Integer>> tweets)
    {
        this.timeStamp = timeStamp;
        this.tweets = tweets;
    }
}

class Twitter 
{
    Map<Integer, HashSet<Integer>> userTweets;
    Map<Integer, HashSet<Integer>> userFollowing;
    PriorityQueue<userDetails> maxHeap;

    public Twitter() 
    {
        userTweets = new HashMap<>();
        userFollowing = new HashMap<>();
        maxHeap = new PriorityQueue<>
                      ((a, b) -> Long.compare(b.timeStamp, a.timeStamp));
    }
    
    public void postTweet(int userId, int tweetId) 
    {
        userTweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(tweetId);
        new 
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
        if(userFollowing.containsKey(followerId))
        {
            if(userFollowing.get(followerId).contains(followeeId)) 
            {
                userFollowing.get(followerId).remove(followeeId);
            }
        }
    }
}










