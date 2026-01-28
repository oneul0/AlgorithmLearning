class Solution {
    public String solution(String s) {
        int ss = s.length();
        if(ss == 1) return s;
        String answer = "";
        int idx = ss/2;
        if(ss%2 == 0) answer = s.substring(idx-1, idx+1);
        else answer = s.charAt(idx)+"";
        
        return answer;
    }
}