
class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;

        int answer = 0;
        int tail = 0;

        String[] cache = new String[cacheSize];
        int[] lastSeen = new int[cacheSize];

        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();

            int idx = indexOf(cache, city, tail);

            // Cache Hit
            if (idx != -1) {
                lastSeen[idx] = i;
                answer += 1;
            }
            // Cache Miss
            else {
                if (tail < cacheSize) {
                    cache[tail] = city;
                    lastSeen[tail] = i;
                    tail++;
                } else {
                    int lruIdx = findLRUIdx(lastSeen, tail);
                    cache[lruIdx] = city;
                    lastSeen[lruIdx] = i;
                }
                answer += 5;
            }
        }

        return answer;
    }

    public int findLRUIdx(int[] arr, int size) {
        int lruIdx = 0;

        for (int i = 1; i < size; i++) {
            if (arr[i] < arr[lruIdx]) {
                lruIdx = i;
            }
        }

        return lruIdx;
    }

    public int indexOf(String[] arr, String target, int size) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(target)) return i;
        }
        return -1;
    }
}
