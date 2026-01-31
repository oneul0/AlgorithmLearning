import java.util.*;
class Solution {
    final int MUL = 65536;
    
    public int solution(String str1, String str2) {
        Map<String, Integer> A = makeSet(str1.toUpperCase());
        Map<String, Integer> B = makeSet(str2.toUpperCase());

        if (A.isEmpty() && B.isEmpty()) return MUL;

        long intersectionCnt = getItstnCount(A, B);
        long unionCnt = getUnionCount(A, B);

        return (int) ((double) intersectionCnt / unionCnt * MUL);
    }

    public int getItstnCount(Map<String, Integer> A, Map<String, Integer> B) {
        int count = 0;
        for (String key : A.keySet()) {
            if (B.containsKey(key)) {
                count += Math.min(A.get(key), B.get(key));
            }
        }
        return count;
    }

    public int getUnionCount(Map<String, Integer> A, Map<String, Integer> B) {
        int sumA = A.values().stream().mapToInt(Integer::intValue).sum();
        int sumB = B.values().stream().mapToInt(Integer::intValue).sum();
        int itstn = getItstnCount(A, B);

        return sumA + sumB - itstn;
    }
    
    public Map<String, Integer> makeSet(String str){
        Map<String, Integer> result = new HashMap<>();
        for(int i = 0; i<str.length()-1; i++){
            char a = str.charAt(i);
            char b = str.charAt(i+1);
            if(!isAlphabet(a) || !isAlphabet(b)) continue;
            String tmp = (a+"")+b;
            result.putIfAbsent(tmp, 0);
            result.put(tmp, result.get(tmp)+1);
        }
        return result;
    }
    
    public boolean isAlphabet(char c) {
        return (c>='A' && c<='Z');
    }
}