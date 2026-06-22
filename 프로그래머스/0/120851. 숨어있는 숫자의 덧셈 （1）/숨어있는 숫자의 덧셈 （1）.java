class Solution {
    public int solution(String my_string) {
        int answer = 0;
        for(int i = 0; i<my_string.length(); i++){
            char cur = my_string.charAt(i);
            if(cur>='1' && cur<='9') answer+=cur-'0';
        }
        return answer;
    }
}