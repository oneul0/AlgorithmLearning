#include <iostream>

using namespace std;

int main(){
    string stackIn;
    int n, tc = 0;

    while(cin>>n){
        int sum = 0;
        cin>>stackIn;
        for(int i = 0; i<n; i++){
            if(47 < stackIn[i] &&  stackIn[i] < 58){
                sum += stackIn[i] - 48;
            }
        }
        cout<<"#"<<++tc<<" "<<sum<<"\n";
    }
}