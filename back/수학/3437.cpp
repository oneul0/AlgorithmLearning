#include<iostream>
#include<algorithm>

using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int t;
    
    cin >> t;

    for(int i = 0; i<t; i++){
        int n;
        cin >> n;
        int two = 0;
        int five =0;
        int tw = 2;
        int fv = 5;

        while(fv<=n){
            five += n/fv;
            fv *=5;    
        }
        
        cout<<five<<"\n";
    }

    return 0;
}