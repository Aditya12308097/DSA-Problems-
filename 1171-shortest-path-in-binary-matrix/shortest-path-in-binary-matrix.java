class Tup{
    int dis;
    int row;
    int col;
    public Tup(int dis,int row, int col){
        this.dis = dis;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(n == 1 && grid[0][0] == 0) return 1; 
        if(n == 1 && grid[0][0] == 1) return -1; 
        if(grid[0][0] == 1) return -1;
        Queue<Tup> q = new ArrayDeque<>();
        q.offer(new Tup(1,0,0));
        int[][] distance = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(distance[i],Integer.MAX_VALUE);

        }
        distance[0][0] = 1;
        while(!q.isEmpty()){
            Tup pt = q.poll();
            int d = pt.dis;
            int r = pt.row;
            int c = pt.col;
            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    int row = r + i;
                    int col = c + j;
                    if(row >=0 && row <n && col>=0 && col < n && grid[row][col] == 0){
                        int dis = d + 1;
                        if(row == n-1 && col == n-1) return dis;
                        if(dis < distance[row][col]){
                            distance[row][col] = dis;
                            q.offer(new Tup(dis,row,col));
                        }
                    }
                }
            }
        }
        return -1;
    }
}