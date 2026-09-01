class Solution {

    class State {
        int r, c, energy, mask;

        State(int r, int c, int energy, int mask) {
            this.r = r;
            this.c = c;
            this.energy = energy;
            this.mask = mask;
        }
    }

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int startR = 0;
        int startC = 0;
        int totalLitter = 0;

        // Find start and count litter
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    startR = i;
                    startC = j;
                }

                if (ch == 'L') {
                    totalLitter++;
                }
            }
        }

        // No litter
        if (totalLitter == 0) {
            return 0;
        }

        // Assign an ID to every litter
        int[][] litterId = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(litterId[i], -1);
        }

        int id = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (classroom[i].charAt(j) == 'L') {
                    litterId[i][j] = id++;
                }
            }
        }

        // All litter collected
        int target = (1 << totalLitter) - 1;

        Queue<State> q = new ArrayDeque<>();

        q.offer(new State(startR, startC, energy, 0));

        boolean[][][][] visited =
            new boolean[m][n][energy + 1][1 << totalLitter];

        visited[startR][startC][energy][0] = true;

        int moves = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                State curr = q.poll();

                // All litter collected
                if (curr.mask == target) {
                    return moves;
                }

                // No energy left
                if (curr.energy == 0) {
                    continue;
                }

                // Try 4 directions
                for (int d = 0; d < 4; d++) {

                    int nr = curr.r + dr[d];
                    int nc = curr.c + dc[d];

                    // Outside grid
                    if (nr < 0 || nr >= m ||
                        nc < 0 || nc >= n) {
                        continue;
                    }

                    char cell = classroom[nr].charAt(nc);

                    // Obstacle
                    if (cell == 'X') {
                        continue;
                    }

                    int newEnergy = curr.energy - 1;
                    int newMask = curr.mask;

                    // Collect litter
                    if (cell == 'L') {
                        int litterIndex = litterId[nr][nc];

                        newMask |= (1 << litterIndex);
                    }

                    // Reset energy
                    if (cell == 'R') {
                        newEnergy = energy;
                    }

                    if (!visited[nr][nc][newEnergy][newMask]) {

                        visited[nr][nc][newEnergy][newMask] = true;

                        q.offer(
                            new State(
                                nr,
                                nc,
                                newEnergy,
                                newMask
                            )
                        );
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}