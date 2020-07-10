import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/rotting-oranges/
 */

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int numFresh = 0;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) q.add(new int[]{i, j});
                else if (grid[i][j] == 1) numFresh++;
            }
        }

        q.add(new int[]{-1, -1});

        int levels = -1;

        while (!q.isEmpty()) {
            int[] currPos = q.poll();
            int r = currPos[0], c = currPos[1];

            if (r == -1) {
                levels++;

                if (!q.isEmpty()) q.add(new int[]{-1, -1});
            }
            else {
                List<int[]> adjList = getAdj(r, c , grid);

                for (int[] adj : adjList) {
                    int row = adj[0], col = adj[1];
                    if (grid[row][col] == 1) {
                        grid[row][col] = 2;
                        numFresh--;

                        q.add(new int[]{row, col});
                    }
                }
            }
        }
        return numFresh == 0 ? levels : -1;
    }

    public static boolean isMove(int r, int c, int[][] grid) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1;
    }

    public static List<int[]> getAdj(int r, int c, int[][] grid) {
        List<int[]> adjList = new ArrayList<>();

        if (isMove(r - 1, c, grid)) adjList.add(new int[]{r - 1, c});
        if (isMove(r + 1, c, grid)) adjList.add(new int[]{r + 1, c});
        if (isMove(r, c - 1, grid)) adjList.add(new int[]{r, c - 1});
        if (isMove(r, c + 1, grid)) adjList.add(new int[]{r, c + 1});

        return adjList;
    }
}
