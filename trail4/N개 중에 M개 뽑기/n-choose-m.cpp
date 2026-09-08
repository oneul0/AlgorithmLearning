#include <vector>
#include <iostream>

using namespace std;

int N, M;

void comb(int start, vector<int> arr, vector<bool> chk){
    if(arr.size() == M){
        for(int val : arr){
            cout << val << " ";
        }
        cout << endl;
        return;
    }

    for(int i = start; i<=N; i++){
        if(chk[i] == true) continue;
        arr.push_back(i);
        chk[i] = true;
        comb(i+1, arr, chk);
        arr.pop_back();
        chk[i] = false;
    }
}

int main() {
    cin >> N >> M;
    vector<int> v;
    vector<bool> chk(N+1, false);
    comb(1, v, chk);

    return 0;
}

