import java.util.ArrayList;
import java.util.List;

class Solution { 
    public void recursive(int[][] grid, List<String> li, StringBuilder sb, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid.length || grid[i][j] == 0) {
            return;
        }

        if (i == grid.length - 1 && j == grid.length - 1) {
            li.add(sb.toString());
            return;
        }

        grid[i][j] = 0;

        int[] drow = {1, 0, 0, -1};
        int[] dcol = {0, -1, 1, 0};
        char[] dir = {'D', 'L', 'R', 'U'};

        for (int k = 0; k < 4; k++) {
            int nrow = i + drow[k];
            int ncol = j + dcol[k];

            sb.append(dir[k]);
            recursive(grid, li, sb, nrow, ncol);
            sb.deleteCharAt(sb.length() - 1);
        }

        grid[i][j] = 1;
    }

    public List<String> findPath(int[][] grid) {
        List<String> li = new ArrayList<>();
        
        if (grid == null || grid.length == 0 || grid[0][0] == 0 || grid[grid.length - 1][grid.length - 1] == 0) {
            return li;
        }
        
        StringBuilder sb = new StringBuilder();
        recursive(grid, li, sb, 0, 0);
        return li;
    }
}
