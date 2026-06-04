class Solution {
    public boolean detectCapitalUse(String word) {
        if(Character.isLowerCase(word.charAt(0))){
            if(isLowerString(word.substring(1, word.length()))) return true;
            return false;
        }
        else{
            String sub = word.substring(1, word.length());
            if(isLowerString(sub) || isUpperString(sub)) return true;
            return false;
        }
    }
    public boolean isLowerString(String str){
        for(int i = 0; i<str.length(); i++){
            if(Character.isUpperCase(str.charAt(i))) return false;
        }
        return true;
    }
    public boolean isUpperString(String str){
        for(int i = 0; i<str.length(); i++){
            if(Character.isLowerCase(str.charAt(i))) return false;
        }
        return true;
    }
}
//첫번째는 대문자 또는 소문자 가능
//첫번째가 대문자이면 모두 대문자 나머지 소문자 가능
//첫번째가 소문자이면 모두 소문자만 가능