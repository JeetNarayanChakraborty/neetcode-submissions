class Solution 
{
    private int subGridMapper(int x, int y)
    {
        return (x / 3) * 3 + (y / 3);
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
                    if(rows.get(i).contains(board[i][j])) return false;
                    else rows.get(i).add(board[i][j]);
                }

                else if(!rows.containsKey(i))
                {
                    rows.put(i, new HashSet<>(List.of(board[i][j])));
                }

                else if(columns.containsKey(j))
                {
                    if(columns.get(j).contains(board[i][j])) return false;
                    else columns.get(j).add(board[i][j]);
                }

                else if(!columns.containsKey(j))
                {
                    columns.put(j, new HashSet<>(List.of(board[i][j])));
                }

                int subGridPos = subGridMapper(i, j);

                if(subGrid.containsKey(subGridPos))
                {
                    if(subGrid.get(subGridPos).contains(board[i][j])) return false;
                    else subGrid.get(subGridPos).add(board[i][j]);
                }

                else
                {
                    subGrid.put(subGridPos, new HashSet<>(List.of(board[i][j])));
                }
            }
        }

        return true;
    }
}








