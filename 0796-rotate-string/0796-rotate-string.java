class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        if(s.equals(goal)) return true;
        
        String str = goal+goal;
        return str.substring(1, str.length()-1).contains(s);
    }
}