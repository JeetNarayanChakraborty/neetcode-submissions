class Solution 
{
    private List<List<String>> queens = new ArrayList<>();
    private boolean[] usedLeftDiag;
    private boolean[] usedRightDiag;
    private char[][] board;
    private boolean[] cols;

    private void placeQueens(int currRow, int n)
    {
        if(currRow == n)
        {
            List<String> rows = new ArrayList<>();

            for(char[] r : board) rows.add(new String(r));
            queens.add(rows);
            return;
        }

        for(int col=0; col<n; col++)
        {
            int d1 = currRow + col;
            int d2 = currRow - col + n - 1;

            if(cols[col] || usedLeftDiag[d1] || usedRightDiag[d2])
            {
                continue;
            }

            board[currRow][col] = 'Q';
            cols[col] = true;
            usedLeftDiag[d1] = true;
            usedRightDiag[d2] = true;

            placeQueens(currRow+1, n);

            cols[col] = false;
            usedLeftDiag[d1] = false;
            usedRightDiag[d2] = false;
            board[currRow][col] = '.';
        }
    }

    public List<List<String>> solveNQueens(int n) 
    {
        usedLeftDiag = new boolean[2*n-1];
        usedRightDiag = new boolean[2*n-1];
        board = new char[n][n];
        cols = new boolean[n];

        for(char[] row : board) Arrays.fill(row, '.');

        placeQueens(0, n);

        return queens;
    }
}
