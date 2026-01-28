import java.util.*;
class Solution {
    String[][] park;
    public int solution(int[] mats, String[][] park) {
        this.park = park;
        int answer = -1;
        Arrays.sort(mats);
        for(int i = mats.length-1; i>=0; i--){
            if(canPlace(mats[i])){
                answer = mats[i];
                break;
            }
        }
        return answer;
    }
    
    public boolean canPlace(int size){
        int row = park.length;
        int col = park[0].length;
        for(int i = 0; i<=row-size; i++){
            for(int j = 0; j<=col-size; j++){
                if(!park[i][j].equals("-1")) continue;
                if(isPlaceEmpty(i, j, size)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isPlaceEmpty(int r, int c, int size){
        for(int i = r; i<r+size; i++){
            for(int j = c; j<c+size; j++){
                if(!park[i][j].equals("-1")){
                    return false;
                }
            }
        }
        return true;
    }
}