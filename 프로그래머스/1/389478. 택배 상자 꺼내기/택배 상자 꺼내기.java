class Solution {
    public int solution(int n, int w, int num) {
        int targetRow = (num - 1) / w;
        int targetCol;
        
        if (targetRow % 2 == 0) {
            //정방향
            targetCol = (num - 1) % w;
        } else {
            //역방향
            targetCol = w - 1 - ((num - 1) % w);
        }
        
        int answer = 1;
        
        for (int box = num + 1; box <= n; box++) {
            int boxRow = (box - 1) / w;
            int boxCol;
            
            if (boxRow % 2 == 0) {
                boxCol = (box - 1) % w;
            } else {
                boxCol = w - 1 - ((box - 1) % w);
            }
            
            if (boxRow > targetRow && boxCol == targetCol) {
                answer++;
            }
        }
        
        return answer;
    }
}