class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];
        String str = "";
        for(String s : strs){
            if(str.isEmpty()) str = s;
            else if(str.length()>s.length()) str = s;
        }

        String result = "";
        for(int i = 0; i<str.length(); i++){
            String sub = str.substring(0, i+1);
            int count = 0;
            for(String s : strs){
                if(s.startsWith(sub)) count++;
            }
            if(count==strs.length){
                result = sub;
            }
        }
        return result;
    }
}