class Solution {
    int[] parent;
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        boolean[] result = new boolean[requests.length];
        parent = new int[n];

        for(int i = 0; i<n; i++){
            parent[i] = i;
        }

        for(int i = 0; i<requests.length; i++){
            int u = requests[i][0];
            int v = requests[i][1];

            int rootU = find(u);
            int rootV = find(v);

            if(rootU == rootV){
                result[i] = true;
                continue;
            }

            boolean blocked = false;

            for(int[] res : restrictions){
                int x = res[0];
                int y = res[1];

                int rootX = find(x);
                int rootY = find(y);

                //금지 관계의 한쪽이 u 그룹에 있고, 다른 한쪽이 v 그룹에 있다면
                if((rootX == rootU && rootY == rootV) ||
                (rootX == rootV && rootY == rootU)) {
                    blocked = true;
                    break;
                }
            }

            //친구요청이 막혔으면 false 아니라면 true
            if(blocked){
                result[i] = false;
            }
            else{
                union(u,v);
                result[i] = true;
            }
        }
        return result;
    }

    //친구가 속한 그룹의 대표를 찾는다
    private int find(int x){
        if(parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    //친구요청이 성공하면 두 그룹을 합친다
    private void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b){
            parent[b] = a;
        }
    }




}