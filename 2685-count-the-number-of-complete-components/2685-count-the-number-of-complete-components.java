class Solution {
    boolean[] visited;
    int vertexCount;
    int edgeCount; //여기서 말하는 edge는 더 정확하게는 degree임 각 노드에 진입점이 몇 개인지
    List<List<Integer>> gr = new ArrayList<>();
    public int countCompleteComponents(int n, int[][] edges) {
        for(int i = 0; i<n; i++){
            gr.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            gr.get(edge[0]).add(edge[1]);
            gr.get(edge[1]).add(edge[0]);
        }

        visited = new boolean[n];
        int answer = 0;
        for(int i  =0; i<n; i++){
            if(!visited[i]){
                vertexCount = 0;
                edgeCount = 0;


                dfs(i);

                if(edgeCount == vertexCount * ( vertexCount-1)){
                    answer++;
                }
            }
        }
        return answer;
    }

    public void dfs(int cur){
        visited[cur] = true;
        vertexCount++;
        edgeCount += gr.get(cur).size();

        for(int next : gr.get(cur)){
            if(!visited[next]){
                visited[next] = true;
                dfs(next);
            }
        }
    }
}