class Solution 
{
    private void backtrack(int row, int n, char[][] board, boolean[] cols,
                           boolean[] diag1, boolean[] diag2, List<List<String>> result) 
    {
        // All queens placed successfully
        if(row == n) 
        {
            List<String> solution = new ArrayList<>();

            for(char[] r : board) 
            {
                solution.add(new String(r));
            }

            result.add(solution);
            return;
        }

        for(int col=0; col<n; col++) 
        {
            int d1 = row - col + n - 1;
            int d2 = row + col;

            // Check whether this position is safe
            if(cols[col] || diag1[d1] || diag2[d2]) 
            {
                continue;
            }

            // Place queen
            board[row][col] = 'Q';

            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            // Move to next row
            backtrack(row + 1, n, board, cols, diag1, diag2, result);

            // Backtrack: remove queen
            board[row][col] = '.';

            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }

    public List<List<String>> solveNQueens(int n) 
    {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2*n-1];
        boolean[] diag2 = new boolean[2*n-1];

        for(char[] row : board) Arrays.fill(row, '.');

        backtrack(0, n, board, cols, diag1, diag2, result);

        return result;
    }
}







