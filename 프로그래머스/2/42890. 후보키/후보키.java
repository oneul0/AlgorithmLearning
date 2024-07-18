import java.util.*;
class Solution {
    List<String> keys = new ArrayList<>();
    String[][] relation;
    public int solution(String[][] relation) {
        this.relation = relation;

        //dfs 초기값 넣어서 호출
        //조합하는 column 개수 1~relation[0].length
        for (int i = 1; i <= relation[0].length; i++) {
            dfs(new boolean[relation[0].length], 0, i);
        }
        return keys.size();
    }

    void dfs(boolean[] chk, int len, int maxDepth) {

        //재귀호출
        if (maxDepth > len) {
            for (int i = len; i < relation[0].length; i++) {
                if(chk[i]) continue;
                chk[i] = true;
                dfs(chk, len + 1, maxDepth);
                chk[i] = false;
            }
        } else {
            //기저사례
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < relation[0].length; i++) {
                if (chk[i]) {
                    sb.append(i);
                }
            }
            String combinedKey = sb.toString();
            if (isUnique(combinedKey) && isMinimal(combinedKey)) {
                keys.add(combinedKey);
            }
        }
    }

    boolean isUnique(String str) {
        HashSet<String> set = new HashSet<>();
        for (String[] strs : relation) {
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < str.split("").length; k++) {
                sb.append(strs[Integer.parseInt(String.valueOf(str.charAt(k)))]);
            }
            if (set.contains(sb.toString())) return false;
            else set.add(sb.toString());
        }
        return true;
    }
    
    boolean isMinimal(String str){
        for (String tmp : keys) {
            int cnt = 0;
            for (int i = 0; i < tmp.split("").length; i++) {
                if (str.contains(String.valueOf(tmp.charAt(i)))) {
                    cnt++;
                    if (tmp.length() == cnt) return false;
                }
            }
        }
        return true;
    }
}