class Solution 
{
    private boolean[][] visited;

    private boolean checkIfExists(char[][] board, int currX, int currY, int m, 
                                  int n, int indx, String word)
    {
        if(currX >= m || currX < 0 || currY >= n || currY < 0 ||
           visited[currX][currY] || word.charAt(indx) != board[currX][currY])
        {
            return false;
        }

        if(indx == word.length()-1 && 
           word.charAt(indx) == board[currX][currY])
        {
            return true;
        }

        visited[currX][currY] = true;

        boolean found = checkIfExists(board, currX - 1, currY, m, n, indx + 1, word) || // Up
                        checkIfExists(board, currX + 1, currY, m, n, indx + 1, word) || // Down
                        checkIfExists(board, currX, currY - 1, m, n, indx + 1, word) || // Left
                        checkIfExists(board, currX, currY + 1, m, n, indx + 1, word); // Right

        visited[currX][currY] = false;

        return found;
    }


    public boolean exist(char[][] board, String word) 
    {
        int m=board.length, n=board[0].length;
        visited = new boolean[m][n];
        
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(checkIfExists(board, i, j, m, n, 0, word)) return true;
            }
        }

        return false;
    }
}
