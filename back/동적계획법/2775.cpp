#include <iostream>
#include <vector>

using namespace std;

int k,n,a,b,T;
vector<vector<int>> apt(15,vector<int>(15,0));
void fillApartment(){
    for(int i = 1; i<15; i++){
        for(int j = 1; j<15; j++){
            if(j==1) apt[i][j] = 1;
            else{
                apt[i][j] = apt[i-1][j]+apt[i][j-1];
            }
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
    cin >> T;
    for(int i = 1; i<15; i++){
        apt[0][i] = i;
    }
    fillApartment();
    for(int i =0; i<T; i++){
        cin >> k >> n;
        cout << apt[k][n] <<'\n';
    }
    return 0;
}