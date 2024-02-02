#include <iostream>
#include <algorithm>
using namespace std;

int arr[30] = {};

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    int n;
    for(int i = 0; i<28; i++){
        cin >> n;
        arr[n-1] = 1;
    }

    for(int i = 0; i<2; i++){
        int *min;
        min=find(arr, arr+30, 0);
        int min_idx = min-arr;
        //cout <<"min_idx : " << min_idx<<" ";
        arr[min_idx] = 1;
        cout << min_idx+1<<"\n";
    }
    

    return 0;
}