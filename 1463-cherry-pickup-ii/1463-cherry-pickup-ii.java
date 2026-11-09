
class Solution {
    public int cherryPickup(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int[][][] dp = new int[rows][cols][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(dp, 0, 0, cols - 1, grid);
    }

    public static int solve(int[][][] dp, int i,
                            int j1, int j2, int[][] grid) {

        if (j1 < 0 || j2 < 0 ||
            j1 >= grid[0].length ||
            j2 >= grid[0].length) {
            return Integer.MIN_VALUE;
        }

        int chocolates;

        if (j1 == j2) {
            chocolates = grid[i][j1];
        } else {
            chocolates = grid[i][j1] + grid[i][j2];
        }

        if (i == grid.length - 1) {
            return chocolates;
        }

        if (dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }

        int ans = Integer.MIN_VALUE;

        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {

                int nextJ1 = j1 + d1;
                int nextJ2 = j2 + d2;

                int future = solve(
                    dp, i + 1, nextJ1, nextJ2, grid
                );

                ans = Math.max(ans, future);
            }
        }

        return dp[i][j1][j2] = chocolates + ans;
    }
}
