#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

long long line, minLine, leftest, rightest, result;
vector<long long> v;
int k, n;
//이분 탐색
int main(){
    cin >> k >> n;
    v.resize(k);
    for(int i = 0; i<k; i++){
        cin >> v[i];
    }

    minLine = *min_element(v.begin(), v.end());
    leftest = 1;
    rightest = *max_element(v.begin(), v.end());

    while(leftest <= rightest){
        long long mid = (leftest+rightest)/2;
        long long sum = 0;

        for(int i = 0; i<k; i++){
            sum += v[i]/mid; //선 개수 구하기
        }
        if(sum >= n){
            result = mid;
            leftest = mid+1;
        }
        else{
            rightest = mid -1;
        }
    }
    cout << result;

    return 0;
}