class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] inbound = new int[n];
        List<Integer> result = new ArrayList<>();
        
        for(List<Integer> edge : edges){
            inbound[edge.get(1)]++;
        }

        //DAG 상의 어떤 노드가 indegree가 있으면 반드시 다른 노드로부터 도달 가능
        for(int i = 0; i<n; i++){
            if(inbound[i] == 0){
                result.add(i);
            }
        }
        return result;
    }
}