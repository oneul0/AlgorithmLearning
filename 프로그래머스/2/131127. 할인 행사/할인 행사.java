import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        if (discount.length < 10) return 0;

        Map<String, Integer> standard = new HashMap<>();
        Map<String, Integer> window = new HashMap<>();
        
        for (int i = 0; i < want.length; i++) {
            standard.put(want[i], number[i]);
            window.put(want[i], 0);
        }

        // 처음 10일
        for (int i = 0; i < 10; i++) {
            addElement(window, discount[i]);
        }
        
        if (satisfied(want, standard, window)) answer++;

        // 슬라이딩
        for (int i = 10; i < discount.length; i++) {
            removeElement(window, discount[i - 10]);
            addElement(window, discount[i]);
            
            if (satisfied(want, standard, window)) answer++;
        }
        
        return answer;
    }

    public void removeElement(Map<String, Integer> map, String key) {
        int count = map.getOrDefault(key, 0) - 1;
        map.put(key, count);
    }

    public void addElement(Map<String, Integer> map, String key) {
        int count = map.getOrDefault(key, 0) + 1;
        map.put(key, count);
    }

    public boolean satisfied(String[] want, Map<String, Integer> standard, Map<String, Integer> window) {
        for (String w : want) {
            if (standard.get(w) > window.getOrDefault(w, 0)) return false;
        }
        return true;
    }
}