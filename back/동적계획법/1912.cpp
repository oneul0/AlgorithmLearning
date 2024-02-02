#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
vector<int> v;
vector<int> cache;


int dp(int n){
    cache.push_back(v[0]);

    for(int i = 1; i<n; i++){
        //cache의 값을 i=0~i=i-1까지 선형순회하며 더한 값 중 가장 큰 값
        //1~n의 인덱스로 cache를 선형 순회하며 0과 cache[i-1] 중 큰 것을 판단하여 현재 인덱스(v[i])를 더한 값을 저장
        //0에 v[i]를 더한다면 현재 값이며, 전 값에 더한다면 연속해서 더하는 것
        /* 원본 아이디어
        A[i]를 오른쪽 끝으로 갖는 구간의 최대 합을 반환하는 함수 maxAt(i)를 정의를 한다.
        A[i]에서 끝나는 최대 합 부분 구간은 항상 A[i] 하나만으로 구성되어 있거나, 
        A[i-1]를 오른쪽 끝으로 갖는 최대 합 부분 구간의 오른쪽에 A[i]를 붙인 형태로 구성되어 있다. 
        */
        cache.push_back(max(0,cache[i-1])+v[i]);
    }
    int max = *max_element(cache.begin(), cache.end());
    return max;
}

int main(){
    int n,num;
    cin >>n;

    for(int i = 0; i<n; i++){
        cin>>num;
        v.push_back(num);
    }

    cout << dp(n);


    return 0;
}