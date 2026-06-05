class Solution {
    public int repeatedStringMatch(String a, String b) {
        int count = (b.length()+a.length()-1)/a.length();
        String str = a.repeat(count);
        if(str.contains(b)) return count;
        str+=a;
        if(str.contains(b)) return count+1;
        return -1;
    }
}