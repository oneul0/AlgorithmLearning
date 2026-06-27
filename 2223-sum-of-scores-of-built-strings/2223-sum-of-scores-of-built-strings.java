class Solution {
    public long sumScores(String s) {
        int n = s.length();
        long[] z = new long[n];
        z[0] = n;  // s0 = sn 이므로 전체 길이

        int L = 0, R = 0;
        for (int i = 1; i < n; i++) {
            if (i < R) {
                // Z-box 사용
                z[i] = Math.min(z[i - L], R - i);
            }
            // 직접 확장해보고
            while (i + z[i] < n && s.charAt((int)z[i]) == s.charAt((int)(i + z[i]))) {
                z[i]++;
            }
            // Z-box 갱신
            if (i + z[i] > R) {
                L = i;
                R = (int)(i + z[i]);
            }
        }

        long sum = 0;
        for (long v : z){
            sum += v;
        }
        return sum;
    }
}

/**
여기서 말하는 Z-bos란 
Z[i] = s[i:] 와 s[0:] 의 longest common prefix 길이

s = "abaca"
     01234

Z[0] = 5  (자기 자신, 전체 길이)
Z[1] = 0  "baca" vs "abaca" → 불일치
Z[2] = 1  "aca"  vs "abaca" → 'a' 1개 일치
Z[3] = 0  "ca"   vs "abaca" → 불일치
Z[4] = 1  "a"    vs "abaca" → 'a' 1개 일치

sum = 5 + 0 + 1 + 0 + 1 = 7 
이런식으로 하나씩 잘라가며 비교*/