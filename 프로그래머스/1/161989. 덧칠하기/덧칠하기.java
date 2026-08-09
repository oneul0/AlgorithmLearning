class Solution {
    //전체 길이 n 롤러 길이 m, 칠해야하는 위치 section
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] isPainted = new boolean[n+1];
        for(int sec : section){
            if(!isPainted[sec]){
                answer++;
                int maxLen = Math.min(n+1, sec+m);
                for(int i = sec; i<maxLen; i++){
                    if(!isPainted[i]){
                        isPainted[i] = true;
                    }
                }
            }
        }
        return answer;
    }
}