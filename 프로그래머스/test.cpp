#include <iostream>
#include <functional> // for std::plus
#include <vector>

using namespace std;


int main(){
    string s = "Hello";
    vector<int> c = {1,2,3,4,5,6};
    vector<int> f(4,0);
    f=c;
    for(int i = 0; i<f.size(); i++){
        cout << f[i] <<" ";
    }

    
    return 0;
}
