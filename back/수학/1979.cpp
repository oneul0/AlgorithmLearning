#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    int n;
    cin >> n;
    vector<int> v;
    while(n--){
        int num;
        bool chk = true;
        cin >> num;
        if(num == 2){ v.push_back(num); }
        else if(num >2){
            for(int i = 2; i<=sqrt(num)+1; i++){
                if(num%i==0){ chk = false; }
            }
            if(chk){
                v.push_back(num);
            }
        }
        
        
    }
    cout << v.size();
    return 0;
}