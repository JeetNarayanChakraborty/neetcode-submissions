class Solution 
{
    private int subGridMapper(int x, int y)
    {
        return (x / 3) * 3 + (y / 3);
    }

    private boolean isValidValue(char[][] board, int x, int y)
    {
        return Character.isDigit(board[x][y]);
    }

    public boolean isValidSudoku(char[][] board) 
    {
        int m=board.length, n=board[0].length;
        Map<Integer, HashSet<Character>> rows = new HashMap<>();
        Map<Integer, HashSet<Character>> columns = new HashMap<>();
        Map<Integer, HashSet<Character>> subGrid = new HashMap<>();

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(rows.containsKey(i))
                {
                    if(isValidValue(board, i, j) && rows.get(i).contains(board[i][j])) return false;
                    else if(isValidValue(board, i, j)) rows.get(i).add(board[i][j]);
                }

                else if(!rows.containsKey(i))
                {
                    rows.put(i, new HashSet<>());
                    if(isValidValue(board, i, j)) rows.get(i).add(board[i][j]);
                }

                if(columns.containsKey(j))
                {
                    if(isValidValue(board, i, j) && columns.get(j).contains(board[i][j])) return false;
                    else if(isValidValue(board, i, j)) columns.get(j).add(board[i][j]);
                }

                else if(!columns.containsKey(j))
                {
                    columns.put(j, new HashSet<>());
                    if(isValidValue(board, i, j)) columns.get(j).add(board[i][j]);
                }

                int subGridPos = subGridMapper(i, j);

                if(subGrid.containsKey(subGridPos))
                {
                    if(isValidValue(board, i, j) && subGrid.get(subGridPos).contains(board[i][j])) return false;
                    else if(isValidValue(board, i, j)) subGrid.get(subGridPos).add(board[i][j]);
                }

                else if(!subGrid.containsKey(subGridPos))
                {
                    subGrid.put(subGridPos, new HashSet<>());
                    if(isValidValue(board, i, j)) subGrid.get(subGridPos).add(board[i][j]);
                }
            }
        }

        return true;
    }
}








