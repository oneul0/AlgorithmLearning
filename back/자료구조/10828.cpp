#include <iostream>
#include <vector>
#include <string>

using namespace std;

vector<int> v;
void stack_vec(string order){
    
    int num;
    if(order == "push"){
        cin >> num;
        v.push_back(num);
    }
    else if(order == "pop"){
        if(v.empty()){
            cout << -1 << '\n';
        }
        else{
            cout << v.back() << '\n';
            v.pop_back();
        }
        
    }
    else if(order == "size"){
        cout << v.size() << '\n';
    }
    else if(order == "empty"){
        cout << v.empty() << '\n';
    }
    else if(order == "top"){
        if(v.empty()){cout<<-1<<'\n';}
        else{
            cout << v.back() << '\n';
        }
        
    }
    
    
}

int main(){
    ios_base::sync_with_stdio(false);
    int n;
    cin >> n;
    string order;
    while(n--){
        cin >> order;
        stack_vec(order);
    }
    return 0;
}