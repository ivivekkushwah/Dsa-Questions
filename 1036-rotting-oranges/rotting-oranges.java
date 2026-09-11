class Solution {
    public int orangesRotting(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        int time = 0;
        int fresh = 0;

        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1)
                    fresh++;

                if (grid[i][j] == 2)
                    q.add(new int[] { i, j });

            }
        }
        while (!q.isEmpty() && fresh > 0) {
            time++;
            int s = q.size();
            while (s-- > 0) {
                int a[] = q.poll();
                int i = a[0], j = a[1];
                grid[i][j] = 0;
                //up
                if (i > 0 && grid[i - 1][j] == 1){
                    q.add(new int[] { i - 1, j });
                    grid[i - 1][j] = 0;
                    fresh--;
                }
                //down
                if (i < row - 1 && grid[i + 1][j] == 1){
                    q.add(new int[] { i + 1, j });
                    grid[i + 1][j] = 0;
                    fresh--;
                }    
                //left
                if (j > 0 && grid[i][j - 1] == 1){
                    q.add(new int[] { i, j - 1 });
                    grid[i][j - 1] = 0;
                    fresh--;
                }    
                //right
                if (j < col - 1 && grid[i][j + 1] == 1){
                    q.add(new int[] { i, j + 1 });
                    grid[i][j + 1] = 0;
                    fresh--;
                }
            }

        }
        if (fresh > 0)
            return -1;

        return time;

    }

}