class Solution {
    public boolean solution(String s) {
        int len = s.length();
        s = s.toLowerCase();
        if(len!=4 && len !=6) return false;
        for(int i = 0; i<len; i++){
            if(s.charAt(i) >='a' && s.charAt(i) <= 'z') return false;
        }
        return true;
    }
}