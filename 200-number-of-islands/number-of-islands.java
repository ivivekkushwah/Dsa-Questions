class Solution {
    public int numIslands(char[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (grid[i][j] == '1') {
                    count++;
                    visited(grid, i, j);
                }
            }
        }

        return count;
    }

    public void visited(char[][] grid, int i, int j) {

        int row = grid.length;
        int col = grid[0].length;

        grid[i][j] = '0';

        if (i > 0 && grid[i - 1][j] == '1')
            visited(grid, i - 1, j);

        if (i < row - 1 && grid[i + 1][j] == '1')
            visited(grid, i + 1, j);

        if (j > 0 && grid[i][j - 1] == '1')
            visited(grid, i, j - 1);

        if (j < col - 1 && grid[i][j + 1] == '1')
            visited(grid, i, j + 1);
    }
}