
class Solution {
    int answer = 0, n;
    public int solution(int n) {
        this.n = n;
        backtracking(0, new int[n]);
        return answer;
    }
    
    void backtracking(int depth, int[] chk){
        if(depth == n){
            answer++;
            return;
        }
        for(int i = 0; i<n; i++){
            if(isPossible(chk, depth, i)){
                chk[depth] = i;
                backtracking(depth+1, chk);
            }
        }
    }
    
    boolean isPossible(int[] chk, int row, int col){
        for(int i = 0; i<row; i++){
            if(chk[i] == col) return false;
            if(Math.abs(chk[i] - col) == Math.abs(i - row)) return false;
        }
        return true;
    }
}