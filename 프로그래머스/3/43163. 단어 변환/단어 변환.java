import java.util.*;

class Solution {
    String[] words;
    
    public int solution(String begin, String target, String[] words) {
        this.words = words;
        if (!containsTarget(target)) return 0;

        return bfs(begin, target);
    }
    
    int bfs(String begin, String target) {
        Queue<Pair> q = new ArrayDeque<>();
        boolean[] chk = new boolean[words.length];
        q.offer(new Pair(begin, 0));
        
        while (!q.isEmpty()) {
            Pair c = q.remove();
            if (c.cur.equals(target)) return c.cnt;
            
            for (int i = 0; i < words.length; i++) {
                if (!chk[i] && canMove(c.cur, words[i])) {
                    q.offer(new Pair(words[i], c.cnt + 1));
                    chk[i] = true;
                }
            }
        }
        
        return 0; // 변환할 수 없는 경우
    }
    
    boolean canMove(String s1, String s2) {
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt++;
            }
        }
        return cnt == 1;
    }
    
    boolean containsTarget(String target) {
        for (String word : words) {
            if (word.equals(target)) {
                return true;
            }
        }
        return false;
    }
}

class Pair {
    String cur;
    int cnt;
    
    Pair(String cur, int cnt) {
        this.cur = cur;
        this.cnt = cnt;
    }
}
