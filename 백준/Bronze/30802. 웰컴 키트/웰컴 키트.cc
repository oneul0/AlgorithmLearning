#include <iostream>
#include <vector>

using namespace std;

int N, s_bundle = 0, p_bundle = 0, shirts = 0;

int main(){
    cin.tie(nullptr) -> ios_base::sync_with_stdio(false);
    cin >> N;
    long v[6];
    for(int i = 0; i<6; i++){
        cin >> v[i];
    }
    
    cin >> s_bundle >> p_bundle;

    for(int i = 0; i< 6; i++){
        if(v[i] == 0) continue;
        if(v[i]%s_bundle == 0) shirts+=(v[i]/s_bundle);
        else shirts+=((v[i]/s_bundle)+1);
    }
    
    cout << shirts << endl << N/p_bundle << " " << N%p_bundle;

    return 0;
}