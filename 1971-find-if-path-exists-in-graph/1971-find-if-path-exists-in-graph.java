class Solution {
    boolean[] visited;
    List<List<Integer>> gr = new ArrayList<>();
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(n == 1 || (source == destination)) return true;
        visited = new boolean[n];
        for(int i = 0; i<n; i++){
            gr.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            gr.get(edge[0]).add(edge[1]);
            gr.get(edge[1]).add(edge[0]);
        }
        dfs(source, destination);
        return visited[destination];
    }
    private void dfs(int cur, int dest){
        if(cur == dest) return;

        for(int next : gr.get(cur)){
            if(!visited[next]){
                visited[next] = true;
                dfs(next, dest);
            }
        }
    }
}