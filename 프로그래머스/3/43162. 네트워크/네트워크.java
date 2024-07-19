class Solution {
    int[][] computers;
    boolean[] chk;
    int answer = 0;
    public int solution(int n, int[][] computers) {
        chk = new boolean[n];
        this.computers = computers;
        //dfs

        for(int i = 0; i < n; i++) {
            if(!chk[i]){
                chk[i] = true;
                dfs(i);
                answer++;
            }

        }

        return answer;
    }

    void dfs(int cur){
        chk[cur] = true;
        for(int i = 0; i <computers[cur].length; i++){
            if(!chk[i] && computers[cur][i] == 1) {
                dfs(i);
            }
        }
    }
}