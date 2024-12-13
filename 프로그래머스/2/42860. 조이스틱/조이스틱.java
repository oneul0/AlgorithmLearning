class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();

        int idx; 
        int move = length - 1;

        for(int i = 0; i < name.length(); i++){
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            idx = i + 1;
            
            while(idx < length && name.charAt(idx) == 'A'){
                idx++;
            }

            // 순서대로 가는 것과, 뒤로 돌아가는 것 중 이동수가 적은 것을 선택
            move = Math.min(move, i * 2 + length - idx);
            move = Math.min(move, (length - idx) * 2 + i);
        }
        return answer + move;
    }
}