class Solution
{
    public int solution(int[][] board)
    {
        int n = board.length;
        int m = board[0].length;
        int answer = 0;
        int[][] dp = new int[n+1][m+1];
        for(int row = 1; row<=n; row++){
            for(int col = 1; col<=m; col++){
                if(board[row-1][col-1] == 1){
                    dp[row][col] = Math.min(dp[row-1][col], Math.min(dp[row][col-1], dp[row-1][col-1]))+1;
                    
                    answer = Math.max(answer, dp[row][col]);
                }
            }
        }
        return answer*answer;
    }
}