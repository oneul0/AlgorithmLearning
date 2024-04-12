#include <iostream>
#include <string>
#include <vector>
#include <sstream>
#include <unordered_map>
#include <tuple>

using namespace std;

vector<pair<string,string>> privaciesSplit(vector<string> privacies){
    vector<pair<string,string>> splitInfo;
    for(int i = 0; i<privacies.size(); i++){
        vector<string> tmp;
        string s;
        stringstream ss(privacies[i]);
        while(ss >> s) tmp.push_back(s);
        //날짜와 약관 종류로 쪼개진 tmp 가공
        pair<string,string> p = {tmp[0],tmp[1]};
        splitInfo.push_back(p);
    }
    
    return splitInfo;
}

vector<vector<int>> expireDate(vector<pair<string,string>> splitInfo){
    vector<vector<int>> expire(splitInfo.size());
    for(int i = 0; i<splitInfo.size(); i++){
        string dates = splitInfo[i].first,s;
        stringstream ss(dates);
        while(getline(ss,s,'.')){
            expire[i].push_back(stoi(s));
        }
    }
    for(int i = 0; i<expire.size(); i++){
        expire[i][1]
    }
    return expire;
}

vector<int> solution(string today, vector<string> terms, vector<string> privacies) {
    vector<int> answer;
    vector<pair<string,string>> splitInfo = privaciesSplit(privacies);
    vector<vector<int>> expireDay;
    unordered_map<string,string> um;
    //약관 별 기간 매핑
    for(int i = 0; i<terms.size(); i++){
        stringstream ss(terms[i]);
        string s1,s2;
        ss >> s1 >> s2;
        um.insert({s1,s2});
    }

    //만료기간 벡터
    expireDay = expireDate(splitInfo);

    //약관 비교
    for(int i = 0; i<splitInfo.size(); i++){
        
    }

    return answer;
}

int main(){
    string today = "2022.05.19";
    vector<string> terms = {"A 6", "B 12", "C 3"};
    vector<string> privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
    vector<int> result;
    result = solution(today,terms,privacies);
    for(auto c : result){
        cout << c << " ";
    }
    return 0;
}