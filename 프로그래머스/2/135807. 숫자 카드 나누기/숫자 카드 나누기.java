import java.util.*;
class Solution {
    int[] arrA, arrB;
    public int solution(int[] arrayA, int[] arrayB) {
        this.arrA = arrayA;
        this.arrB = arrayB;
        
        int answer = 0;
        int a = findGcd(arrA);
        int b = findGcd(arrB);
        
        boolean findA = a != 1 && Arrays.stream(arrB).allMatch(o -> o%a != 0);
        boolean findB = b != 1 && Arrays.stream(arrA).allMatch(o -> o%b != 0);
        if(findA && findB) return Math.max(a,b);
        if(findA) return a;
        if(findB) return b;
        
        return answer;
    }
    
    int findGcd(int[] arr){
        int res = arr[0];
        for(int i = 0; i<arr.length; i++){
            res = gcd(res, arr[i]);
            if(res == 1) break;
        }
        return res;
    }
    
    int gcd(int a, int b){
        while(b != 0){
            int c = b;
            b = a%b;
            a = c;
        }
        return a;
    }
}