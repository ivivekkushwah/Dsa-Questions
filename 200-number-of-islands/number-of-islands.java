class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean vis[][] = new boolean[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int val = grid[i][j];

                if (val == '1' && !vis[i][j]) {
                    count++;
                    visited(grid, i, j, vis);
                }
            }
        }
        return count;
    }

    public void visited(char[][] grid, int i, int j, boolean[][] vis) {
        int row = grid.length;
        int col = grid[0].length;
        vis[i][j] = true;
        if (i != 0 && !vis[i - 1][j] && grid[i - 1][j] == '1') {
            visited(grid, i - 1, j, vis);
        }
        if (i != row - 1 && !vis[i + 1][j] && grid[i + 1][j] == '1') {
            visited(grid, i + 1, j, vis);
        }
        if (j != col - 1 && !vis[i][j + 1] && grid[i][j + 1] == '1') {
            visited(grid, i, j + 1, vis);
        }
        if (j != 0 && !vis[i][j - 1] && grid[i][j - 1] == '1') {
            visited(grid, i, j - 1, vis);
        }

    }
}