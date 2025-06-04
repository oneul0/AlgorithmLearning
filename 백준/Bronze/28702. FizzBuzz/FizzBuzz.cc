#include <iostream>
#include <vector>
#include <string>
#include <ctype.h>
#include <algorithm>

using namespace std;

string fizzbuzz(int num){
    if(num % 15 == 0){
        return "FizzBuzz";
    }
    if(num % 3 == 0){
        return "Fizz";
    }
    if(num % 5 == 0){
        return "Buzz";
    }

    return to_string(num);
}


int main(){
    vector<string> arr;
    arr.resize(3);
    for(int i = 0; i<3; i++){
        cin >> arr[i];
    }
    int idx = -1;
    for(int i = 0; i<3; i++){
        if(!all_of(arr[i].begin(), arr[i].end(), ::isdigit)){
            continue;
        }
        idx = i;
    }
    
    if(idx != -1){
        int tmp = stoi(arr[idx]) + (2-idx) +1;
        cout << fizzbuzz(tmp);
    }
    
    return 0;
}
