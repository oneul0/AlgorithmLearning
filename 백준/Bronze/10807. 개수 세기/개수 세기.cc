#include <iostream>

using namespace std;

int main(){
    int n,v,num;
    int arr[201] = {0};
    cin >>n;
    for(int i = 0; i<n; i++){
		cin >> num;
		num+=100;
        arr[num]++;
    }
    cin >> v;
    v+=100;
    cout << arr[v];
    
        
    return 0;
}