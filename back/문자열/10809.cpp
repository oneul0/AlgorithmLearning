#include <iostream>
#include <string>
#include <vector>

//char lowercase[26] = {'a', 'b', 'c', 'd', 'e', 'f', 'g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
char lowercase[26];
//vector<char> alphabets;
int alphabets[26];
int cnt = 0;

using namespace std;

int main(){
    for(int i = 0; i<26; i++){
        lowercase[i] = 97+i;
    }
    fill_n(alphabets, 26, -1);
    string word;

    cin >> word;

    for(int k = 0; k<word.length(); k++){
        char c = word[k];
        //alphabets.push_back(c);
        for(int i = 0; i<26; i++){
            if(c == lowercase[i]){
                if(alphabets[i] == -1){
                    alphabets[i] = k;
                }
                
            }
        }
    }


    for(int j : alphabets){
        cout << j << " ";
    }

    return 0;

}