class Solution {
    public void islandsAndTreasure(int[][] grid) {
        // clarifying questions?
        // input int32 2D array
        // Integer.MAX_VALUE will be used to compare land cell
        // as grid needs to be modified in place, so no need to return output
        // sol1: dfs
        // O(N^2*N)
        // sol2: bfs
        // linkedlist-store all the treasure chests with distance as 0-traverse all land cells 
        // adjasent to the treasure chets and update with distance+1 and do this for all reacheable 
        // landcells
        // TC-O(N^2+N), sc-O(N^2)
        // edge cases: null do nothing, 
        bfs(grid);
    }

    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

    private void bfs(int[][] grid) {
        if(grid == null) return;
        LinkedList<int[]> queue = new LinkedList<>();
        for(int r=0; r<grid.length; ++r) {
            for(int c=0; c<grid[0].length; ++c) {
                if(grid[r][c] == 0) {//adding treasue to queue
                    queue.offer(new int[]{r, c, 0});
                }
            }
        }
        while(!queue.isEmpty()) {
            int[] loc = queue.poll();
            int r = loc[0];
            int c = loc[1];
            int dist = loc[2];
            for(int[] dir: dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr>=0 && nr < grid.length && nc>=0 && nc < grid[0].length && grid[nr][nc] == Integer.MAX_VALUE) {
                    grid[nr][nc] = dist + 1;
                    queue.offer(new int[]{nr, nc, grid[nr][nc]});
                }
            }
        }
    }
}
