class Pair{
    int node;
    int cost;
    public Pair(int node, int cost){
        this.node = node;
        this.cost = cost;
    }
}
class Tuple{
    int stops;
    int city;
    int price;
    public Tuple(int stops,int city, int price){
        this.stops = stops;
        this.city = city;
        this.price = price;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if(src == dst) return 0;
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int c = flights[i][2];
            graph.get(u).add(new Pair(v,c));
        }
        //cost price to reach a paticular node
        int[] arr = new int[n];
        Arrays.fill(arr,Integer.MAX_VALUE);
        arr[src] = 0;
        Queue<Tuple> q = new ArrayDeque<>();//{stops,node,cost}
        q.offer(new Tuple(0,src,0));
        while(!q.isEmpty()){
            Tuple pt = q.poll();
            int stops = pt.stops;
            int node = pt.city;
            int price = pt.price;
            if(stops > k) continue;
            for(Pair it : graph.get(node)){
                int v = it.node;
                int w = it.cost;
                if(price + w < arr[v] && stops <= k){
                    arr[v] = price + w;
                    q.offer(new Tuple(stops+1,v,price+w));
                }
            }
        }
        if(arr[dst] == Integer.MAX_VALUE) return -1;
        return arr[dst];
    }
}