// class Twitter {

//     PriorityQueue<int[]> queue;
//     Map<Integer,Set<Integer>> followers;
//     private int timestamp;

//     public Twitter() {
//         queue = new PriorityQueue<>((a,b)->b[2]-a[2]);
//         followers = new HashMap<>();
//         timestamp =0;
//     }
    
//     public void postTweet(int userId, int tweetId) {
//         queue.add(new int[]{userId, tweetId,timestamp++});
//     }
    
//     public List<Integer> getNewsFeed(int userId) {
//         Set<Integer> collectedUsers = new HashSet<>();
//         collectedUsers.add(userId);

//         // iske followers ki bhi chahiye 
//         if(followers.containsKey(userId)){
//             collectedUsers.addAll(followers.get(userId));
//         }
//         List<Integer> result = new ArrayList<>();

//         PriorityQueue<int[]> tempQueue = new PriorityQueue<>(queue);

//         while(!tempQueue.isEmpty() && result.size()<10){
//                 int[] queueObj = tempQueue.poll();
//                  int uId = queueObj[0];
//             // int tweetId = queueObj[1];
//             if(collectedUsers.contains(uId)){
//                 result.add(queueObj[1]);
//             }
//         }
           
//         return result;

//     }
    
//     public void follow(int followerId, int followeeId) {
//         if(followers.containsKey(followerId)){
//             followers.get(followerId).add(followeeId);
//         }else{
//             Set<Integer> followerSet = new HashSet<>();
//             followerSet.add(followeeId);
//             followers.put(followerId,followerSet);
//         }
//     }
    
//     public void unfollow(int followerId, int followeeId) {
//          if(followers.containsKey(followerId)){
//             followers.get(followerId).remove(followeeId);
//          }
//     }
// }

// /**
//  * Your Twitter object will be instantiated and called as such:
//  * Twitter obj = new Twitter();
//  * obj.postTweet(userId,tweetId);
//  * List<Integer> param_2 = obj.getNewsFeed(userId);
//  * obj.follow(followerId,followeeId);
//  * obj.unfollow(followerId,followeeId);
//  */


class Twitter {

    Map<Integer, List<int[]>> userTweets; // userId -> List of [tweetId, timestamp]
    Map<Integer,Set<Integer>> followers;
    private int timestamp;

    public Twitter() {
        userTweets = new HashMap<>();
        followers = new HashMap<>();
        timestamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        userTweets.computeIfAbsent(userId, k -> new ArrayList<>())
                  .add(new int[]{tweetId, timestamp++});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> collectedUsers = new HashSet<>();
        collectedUsers.add(userId);

        // Add followers
        if(followers.containsKey(userId)){
            collectedUsers.addAll(followers.get(userId));
        }
        
        // Create priority queue only for relevant tweets
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]); // Sort by timestamp desc
        
        // Add tweets from all relevant users
        for(int user : collectedUsers) {
            if(userTweets.containsKey(user)) {
                pq.addAll(userTweets.get(user));
            }
        }
        
        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty() && result.size() < 10){
            result.add(pq.poll()[0]); // Add tweetId
        }
           
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followers.containsKey(followerId)){
            followers.get(followerId).add(followeeId);
        }else{
            Set<Integer> followerSet = new HashSet<>();
            followerSet.add(followeeId);
            followers.put(followerId,followerSet);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
         if(followers.containsKey(followerId)){
            followers.get(followerId).remove(followeeId);
         }
    }
}