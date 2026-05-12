class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        int[] colors = new int[n];
        int[] answer = new int[queries.length];
        int count = 0;
        for(int q = 0; q<queries.length; q++){
            int idx = queries[q][0];
            int newColor = queries[q][1];
            int oldColor = colors[idx];

            //만약 이전 색이 있었으면
            if(oldColor != 0){
                //좌우 count 제거
                if(idx > 0 && colors[idx-1] == oldColor){
                    count--;
                }
                if(idx+1 < n && colors[idx+1] == oldColor){
                    count--;
                }
            }

            //색 업데이트
            colors[idx] = newColor;
            //좌우 체크
            if(idx>0 && colors[idx-1] == newColor){
                count++;
            }
            if(idx+1<n && colors[idx+1] == newColor){
                count++;
            }
            answer[q] = count;
        }
        return answer;
    }
}