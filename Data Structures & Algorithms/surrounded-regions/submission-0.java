class Solution 
{
    private Set<String> visited = new HashSet<>();
    int directions[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void BFS(char[][] board, int startX, int startY, int m, int n)
    {
        boolean touchedBoundary=false;
        Queue<int[]> queue = new LinkedList<>();
        ArrayList<int[]> region = new ArrayList<>();

        queue.add(new int[]{startX, startY});
        visited.add(startX + "," + startY);
        region.add(new int[]{startX, startY});

        while(!queue.isEmpty())
        {
            int[] currPos = queue.poll();

            for(int[] direction : directions)
            {
                int newX = currPos[0] + direction[0];
                int newY = currPos[1] + direction[1];

                if(newX >= 0 && newX < m && newY >= 0 && newY < n 
                   && !visited.contains(newX + "," + newY) 
                   && board[newX][newY] == '0')
                {
                    queue.add(new int[]{newX, newY});
                    visited.add(newX + "," + newY);
                    region.add(new int[]{newX, newY});

                    if(newX == 0 || newX == m-1 || newY == 0 || newY == n-1)
                    {
                        touchedBoundary = true;
                    }
                }
            }
        }

        if(!touchedBoundary)
        {
            for(int[] reg : region)
            {
                board[reg[0]][reg[1]] = 'X';
            }
        }
    }

    public void solve(char[][] board) 
    {
        int m=board.length, n=board[0].length;
    
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(board[i][j] == '0' && !visited.contains(i + "," + j))
                {
                    BFS(board, i, j, m, n);
                }
            }
        }
    }
}




