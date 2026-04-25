class Solution {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int mid = str.length()/2;
        for(int left = 0; left<mid; left++){
            int right = str.length() - left-1;
            if(str.charAt(left) != str.charAt(right)) return false;
        }
        return true;
    }
}