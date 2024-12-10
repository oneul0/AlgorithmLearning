import java.util.*;
class Solution {
    int[][] sizes;
    public int solution(int[][] sizes) {
        this.sizes = sizes;
        int answer = 0;
        
        int l1 = 0, l2 = 0;
        
        for(int[] size : sizes){
            if(size[1] > size[0]){
                int tmp = size[0];
                size[0] = size[1];
                size[1] = tmp;
            }
        }
        Arrays.sort(sizes, (o1, o2)->(o2[0]-o1[0]));
        for(int[] size : sizes){
            l1 = Math.max(l1, size[0]);
            l2 = Math.max(l2, size[1]);
        }
        answer = l1*l2;
        return answer;
    }
}


//정렬하고 가장 긴 변을 돌릴 수 있을지 확인