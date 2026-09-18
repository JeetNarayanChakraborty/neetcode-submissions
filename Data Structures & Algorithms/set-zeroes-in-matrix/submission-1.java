class Solution 
{
    private void makeZeroes(ArrayList<int[]> pos, int m, int n, int[][] matrix)
    {
        for(int i=0; i<pos.size(); i++)
        {
            int x = pos.get(i)[0];
            int y = pos.get(i)[1];

            // Zero the entire row
            for(int j=0; j<n; j++) matrix[x][j] = 0;

            // Zero the entire column
            for(int j = 0; j < m; j++) matrix[j][y] = 0;
        }
    }

    public void setZeroes(int[][] matrix) 
    {
        int m=matrix.length, n=matrix[0].length;
        ArrayList<int[]> pos = new ArrayList<>();

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(matrix[i][j] == 0) pos.add(new int[]{i, j});
            }
        }

        makeZeroes(pos, m, n, matrix);
    }
}








