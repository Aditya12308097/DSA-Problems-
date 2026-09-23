class Tuple{
    int diff;
    int row;
    int col;
    public Tuple(int diff, int row, int col){
        this.diff = diff;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b)-> Integer.compare(a.diff,b.diff));
        int[][] eff = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(eff[i],Integer.MAX_VALUE);

        }
        pq.offer(new Tuple(0,0,0));
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        while(!pq.isEmpty()){
            Tuple pt = pq.poll();
            int d = pt.diff;
            int r = pt.row;
            int c = pt.col;
            if(r == n-1 && c == m-1) return d;
            for(int i=0;i<4;i++){
                int nrow =r + dr[i];
                int ncol = c + dc[i];
                if(nrow >=0 && nrow < n && ncol >= 0 && ncol < m){
                    int ndiff = Math.abs(heights[r][c] - heights[nrow][ncol]);
                    int mx = Math.max(ndiff,d);
                    if(mx < eff[nrow][ncol]){
                        eff[nrow][ncol] = mx;
                        pq.offer(new Tuple(mx,nrow,ncol));
                    }
                }
            }
        }
        return eff[n-1][m-1];

    }
}