class Pair {
    int node;
    int time;

    public Pair(int node, int time) {
        this.node = node;
        this.time = time;
    }
}

class Tuple {
    long dis;
    int node;

    public Tuple(long dis, int node) {
        this.dis = dis;
        this.node = node;
    }
}

class Solution {
    public int countPaths(int V, int[][] edges) {

        int MOD = (int)(1e9+7);

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int t = edge[2];

            graph.get(u).add(new Pair(v, t));
            graph.get(v).add(new Pair(u, t));
        }

        PriorityQueue<Tuple> pq =
            new PriorityQueue<>((a, b) -> Long.compare(a.dis, b.dis));

        long[] ways = new long[V];
        long[] minTime = new long[V];

        Arrays.fill(minTime, Long.MAX_VALUE);

        minTime[0] = 0;
        ways[0] = 1;

        pq.offer(new Tuple(0, 0));

        while (!pq.isEmpty()) {

            Tuple pt = pq.poll();

            long dis = pt.dis;
            int curr = pt.node;

            // Important: ignore outdated PQ entries
            if (dis > minTime[curr]) {
                continue;
            }

            for (Pair it : graph.get(curr)) {

                int v = it.node;
                long newTime = dis + it.time;

                if (newTime < minTime[v]) {

                    minTime[v] = newTime;
                    ways[v] = ways[curr];

                    pq.offer(new Tuple(newTime, v));

                } else if (newTime == minTime[v]) {

                    ways[v] = (ways[v] + ways[curr]) % MOD;
                }
            }
        }

        return (int)ways[V - 1];
    }
}