#include<iostream>
#include<string>
#include<vector>

using namespace std;

int main(){
    vector<string> words;
    string word = "s";
    while (word != "")
    {
        getline(cin, word);
        if(word != ""){words.push_back(word);}
    }
    
    for(string s : words){
        cout << s << '\n';
    }

    return 0;
}