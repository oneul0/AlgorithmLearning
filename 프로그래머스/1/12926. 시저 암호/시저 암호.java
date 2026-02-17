class Solution {
    public String solution(String s, int n) {
        //65~90
        //97~122
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            char cur = s.charAt(i);
            if(Character.isUpperCase(cur)){
                cur += n;
                if(cur > 90) cur = (char)((cur % 90) + 65-1);
            }
            else if(Character.isLowerCase(cur)) {
                cur += n;
                if(cur > 122) cur = (char)((cur % 122) + 97-1);
            }
            sb.append(cur);
        }
        
        return sb.toString();
    }
}