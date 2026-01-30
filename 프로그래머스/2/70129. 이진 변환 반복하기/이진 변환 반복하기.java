class Solution {
    public int[] solution(String s) {
        int count = 0;
        int delCount = 0;
        int[] answer = new int[2];
        
        while(true){
            int len = 0;
            for(int i = 0; i<s.length(); i++){
                if(s.charAt(i) == '1') len++;
                else delCount++;
            }
            s = Integer.toBinaryString(len);
            count++;
            if(s.equals("1")){
                answer[0] = count;
                answer[1] = delCount;
                break;
            }
            
        }
        
        
        return answer;
    }
}
//변환 횟수, 지운 0 개수