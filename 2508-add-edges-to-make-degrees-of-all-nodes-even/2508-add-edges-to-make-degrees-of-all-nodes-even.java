class Solution {
    Set<String> set;
    public boolean isPossible(int n, List<List<Integer>> edges) {
        int[] degree = new int[n+1];
        set = new HashSet<>();

        List<List<Integer>> gr = new ArrayList<>();

        for(int i = 0; i<=n; i++){
            gr.add(new ArrayList<>());
        }
        for(List<Integer> edge : edges){
            gr.get(edge.get(0)).add(edge.get(1));
            gr.get(edge.get(1)).add(edge.get(0));
            degree[edge.get(0)]++;
            degree[edge.get(1)]++;
            int a = Math.min(edge.get(0), edge.get(1));
            int b = Math.max(edge.get(0), edge.get(1));
            set.add(a + ":" + b);
        }

        //홀수 개수인 노드 찾기
        List<Integer> nodes = new ArrayList<>();
        for(int i =1; i<=n; i++){
            if(degree[i] % 2 == 1){
                nodes.add(i);
            }
        }

        if(nodes.size() == 0) {
            return true;
        }
        else if(nodes.size() == 2) {
            int a = Math.min(nodes.get(0), nodes.get(1));
            int b = Math.max(nodes.get(0), nodes.get(1));
            if (!hasEdge(a, b)) return true;

            for (int i = 1; i <= n; i++) {
                if (i == a || i == b) continue;

                if (!hasEdge(a, i) && !hasEdge(b, i)) {
                    return true;
                }
            }

            return false;
        }
        else if(nodes.size() == 4){
            int a = Math.min(nodes.get(0), nodes.get(1));
            int b = Math.max(nodes.get(0), nodes.get(1));
            int c = Math.min(nodes.get(2), nodes.get(3));
            int d = Math.max(nodes.get(2), nodes.get(3));

            if (!hasEdge(a,b) && !hasEdge(c,d)) return true;
            if (!hasEdge(a,c) && !hasEdge(b,d)) return true;
            if (!hasEdge(a,d) && !hasEdge(b,c)) return true;
        }
        
        return false;
    }

    private boolean hasEdge(int a, int b){
        int minVal = Math.min(a, b);
        int maxVal = Math.max(a,b);
        return set.contains(minVal+":"+maxVal);
    }
}