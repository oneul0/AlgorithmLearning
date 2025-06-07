#include <iostream>
#include <string>
using namespace std;

int main(){
    int t;
    cin >> t;
    for(int i = 0 ; i <t; i++){
        int n, maxCost = 0;
        string maxName = "";
        
        cin >> n;
        for(int j = 0; j<n; j++){
            int a;
            string b;
            cin >> a >> b;
            if(a > maxCost){
                maxCost = a;
                maxName = b;
            }
        }
        cout << maxName << endl;  
    }
    return 0;
}