class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for(int r = 0; r<arr1.length; r++){
            for(int c = 0; c<arr2[0].length; c++){
                for(int i = 0; i<arr1[0].length; i++){
                    answer[r][c] += (arr1[r][i] * arr2[i][c]);
                }
            }
        }
        return answer;
    }
}
//행렬1의 행, 행렬2의 열끼리 곱하되 결과값은 행렬1의 행, 행렬2의 열 인덱스
//