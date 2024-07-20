class Solution {
    int answer = 0;
    public int solution(int n) {
        dfs(new int[n], 0);
        return answer;
    }
    void dfs(int[] queens, int row){
        if(row == queens.length){
            answer++;
            return;
        }

        for(int col = 0; col < queens.length; col++){
            if(isPossible(queens, row, col)){
                queens[row] = col;
                dfs(queens, row+1);
            }
        }
    }

    boolean isPossible(int[] queens, int row, int col){
        for(int i = 0; i< row; i++){
            if(queens[i] == col || Math.abs(queens[i] - col) == Math.abs(i-row)) return false;
        }
        return true;
    }
}