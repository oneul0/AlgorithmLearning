class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int rxLen = arr1.length;
        int ryLen = arr2[0].length;
        int[][] answer = new int[rxLen][ryLen];
        for(int i = 0; i<rxLen; i++){
            for(int j = 0; j<ryLen; j++){
                answer[i][j] = (arr1[i][j] + arr2[i][j]);
            }
        }
        return answer;
    }
}