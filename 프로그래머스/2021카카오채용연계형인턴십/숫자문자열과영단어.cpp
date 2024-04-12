#include <iostream>
#include <string>
#include <unordered_map>

using namespace std;

string dic[10] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
unordered_map<string, string> words;

int solution(string s) {
    int answer = 0;
    string tmp = "", numstring = "";
    for (int i = 0; i < 10; i++) {
        words[dic[i]] = to_string(i);
    }

    for (int i = 0; i < s.length(); i++) {
        if (s[i] >= '0' && s[i] <= '9') {
            tmp += s[i];
        } else {
            numstring = "";
            for (int j = i; j < s.length() && (s[j] < '0' || s[j] > '9'); j++) {
                numstring += s[j];
                if (words.count(numstring)) {
                    tmp += words[numstring];
                    i = j;
                    break;
                }
            }
        }
    }
    answer = stoi(tmp);
    return answer;
}

int main() {
    string s = "one4seveneight";
    cout << solution(s);
    return 0;
}
