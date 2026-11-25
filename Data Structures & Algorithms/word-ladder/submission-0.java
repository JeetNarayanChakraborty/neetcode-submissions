class Solution 
{
    public int ladderLength(String beginWord, String endWord, List<String> wordList) 
    {
        int steps=1;
        Queue<String> queue = new LinkedList<>();
        Set<String> wordSet = new HashSet<>(wordList);

        if(!wordSet.contains(endWord)) return 0;

        queue.offer(beginWord);
        
        while(!queue.isEmpty()) 
        {
            int levelSize = queue.size();

            for(int i=0; i<levelSize; i++) 
            {
                char[] chars = queue.poll().toCharArray();

                // replace each character with 'a' through 'z'
                for(int pos=0; pos<chars.length; pos++) 
                {
                    char originalChar = chars[pos];

                    for(char c='a'; c<='z'; c++) 
                    {
                        chars[pos] = c;
                        String nextWord = new String(chars);

                        if(nextWord.equals(endWord)) 
                        {
                            return steps + 1;
                        }

                        // If valid, add to queue and remove from set to never visit it again
                        if(wordSet.remove(nextWord)) 
                        {
                            queue.offer(nextWord);
                        }
                    }

                    chars[pos] = originalChar; // Restore character for next position
                }
            }

            steps++;
        }

        return 0;
    }
}
