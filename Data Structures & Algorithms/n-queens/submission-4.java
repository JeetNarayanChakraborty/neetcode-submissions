class Solution 
{
    private char[][] board;
    private boolean[] leftDiag;
    private boolean[] rightDiag;
    private boolean[] cols;
    private List<List<String>> res = new ArrayList<>();
    
    private void placeQueens(int n, int row)
    {
        if(row == n)
        {
            ArrayList<String> temp = new ArrayList<>();
            for(char[] b : board) temp.add(new String(b));
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int col=0; col<n; col++)
        {
            int d1 = row + col;
            int d2 = row - col + n - 1;

            if(leftDiag[d1] || rightDiag[d2] || cols[col]) continue;

            board[row][col] = 'Q';
            leftDiag[d1] = true;
            rightDiag[d2] = true;
            cols[col] = true;

            placeQueens(n, row+1);

            board[row][col] = '.';
            leftDiag[d1] = false;
            rightDiag[d2] = false;
            cols[col] = false;
        }
    }

    public List<List<String>> solveNQueens(int n) 
    {
        board = new char[n][n];
        leftDiag = new boolean[2*n-1];
        rightDiag = new boolean[2*n-1];
        cols = new boolean[n];

        for(char[] b : board) Arrays.fill(b, '.');

        placeQueens(n, 0);

        return res;
    }
}
