import java.util.*;
class Solution {
    int n, s, a, b, max = Integer.MAX_VALUE;
    ArrayList<ArrayList<Pair>> gr = new ArrayList<>();
    public int solution(int n, int s, int a, int b, int[][] fares) {
        this.n = n; this.s = s; this.a = a; this.b = b;
        for(int i = 0; i<= n; i++){
            gr.add(new ArrayList<>());
        }
        
        int answer = max;
        
        for(int[] fare : fares){
            gr.get(fare[0]).add(new Pair(fare[1], fare[2]));
            gr.get(fare[1]).add(new Pair(fare[0], fare[2]));
        }
        
        int[] toS = dijkstra(s);
        int[] toA = dijkstra(a);
        int[] toB = dijkstra(b);
        
        
        for(int i = 1; i<=n; i++){
            answer = Math.min(answer, toS[i]+toA[i]+toB[i]);
        }
        
        return answer;
    }
    
    int[] dijkstra(int start){
        int[] dist = new int[n+1];
        Arrays.fill(dist, max);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(start, 0));
        dist[start] = 0;
        
        while(!pq.isEmpty()){
            Pair cur = pq.remove();
            if(cur.cost > dist[cur.node]) continue;
            for(Pair nxt : gr.get(cur.node)){
                int nxtCost = cur.cost+nxt.cost;
                if(dist[nxt.node] < nxtCost) continue;
                pq.offer(new Pair(nxt.node, nxtCost));
                dist[nxt.node] = nxtCost;
            }
        }
        return dist;
    }
}

class Pair implements Comparable<Pair>{
    int node, cost;
    public Pair(int node, int cost){
        this.node = node;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Pair p){
        return Integer.compare(this.cost, p.cost);
    }
}

//시작 지점으로부터 각 지점까지의 거리만 구하는 다익스트라

