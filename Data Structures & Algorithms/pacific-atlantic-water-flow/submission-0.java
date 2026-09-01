class Solution 
{
    private List<List<Integer>> cells = new ArrayList<>();
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void DFS(int[][] heights, int startX, int startY, int m, int n)
    {
        Stack<int[]> stack = new Stack<>();
        boolean[][] visited = new boolean[m][n];
        boolean reachedPacific=false, reachedAtlantic=false;

        stack.push(new int[]{startX, startY});

        while(!stack.isEmpty()) 
        {
            int[] currPos = stack.pop();

            if(currPos[0] == 0 || currPos[1] == 0) reachedPacific = true;
            if(currPos[0] == m-1 || currPos[1] == n-1) reachedAtlantic = true;

            if(visited[currPos[0]][currPos[1]] == true) continue;
            visited[currPos[0]][currPos[1]] = true;

            for(int[] direction : directions)
            {
                int newX = currPos[0] + direction[0];
                int newY = currPos[1] + direction[1];

                if(newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY] && 
                   heights[currPos[0]][currPos[1]] >= heights[newX][newY])
                {
                    stack.push(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }

            if(reachedPacific && reachedAtlantic) break;
        }

        if(reachedPacific && reachedAtlantic) cells.add(new ArrayList<>(List.of(startX, startY)));
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) 
    {
        int m=heights.length, n=heights[0].length;

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                DFS(heights, i, j, m, n);
            }
        }

        return cells;
    }
}
