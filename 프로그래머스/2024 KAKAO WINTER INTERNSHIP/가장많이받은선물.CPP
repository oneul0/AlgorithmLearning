#include <string>
#include <vector>
#include <iostream>
#include <unordered_map>
#include <sstream>
#include <algorithm>

using namespace std;

int solution(vector<string> friends, vector<string> gifts) {
    int answer = 0;
    //일단 문제와 같은 표(2차원 벡터)로 만들어서 문제 해결
    //2차원 벡터의 인덱스는 friends의 인덱스와 동일함.
    int friendsSize = friends.size();
    //이름과 인덱스 연결맵, 선물지수
    unordered_map<string, int> nameIndexMap, giftScore;
    vector<int> nextMonth(friendsSize,0);
    vector<vector<int>> giftRelations(friendsSize, vector<int>(friendsSize,0));
    //
    for(int i = 0; i<friendsSize; i++){
        nameIndexMap.insert({friends[i], i});
        giftScore.insert({friends[i],0});
    }
    //선물 내역 정리
    for(int i = 0; i<gifts.size(); i++){
        string sender, receiver;
        istringstream ss(gifts[i]);
        ss >> sender >> receiver;
        //주고 받은 선물 표로 나타내기
        giftRelations[nameIndexMap[sender]][nameIndexMap[receiver]] += 1;
        giftScore[sender]++;
        giftScore[receiver]--;
    }
    
    for(int i = 0; i<friendsSize; i++){//sender
        for(int j = 0; j<friendsSize; j++){ //receiver
            if(i==j) continue; //본인
            //두 사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면, 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받습니다.
            if(giftRelations[i][j] == 0 && giftRelations[j][i] == 0){
                if(giftScore[friends[i]]>giftScore[friends[j]]) nextMonth[i]++;
            }
            else if(giftRelations[i][j] == giftRelations[j][i]){
                if(giftScore[friends[i]]>giftScore[friends[j]]) nextMonth[i]++;
            }
            //두 사람이 선물을 주고받은 기록이 있다면, 이번 달까지 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받습니다.
            else{
                if(giftRelations[i][j]>giftRelations[j][i]) nextMonth[i]++;
            }
        }
    }

    answer = *max_element(nextMonth.begin(), nextMonth.end());
    return answer;
}

int main(){
    vector<string> friends = {"muzi", "ryan", "frodo", "neo"};
    vector<string> gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
    // vector<string> friends = {"joy", "brad", "alessandro", "conan", "david"};
    // vector<string> gifts = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
    // vector<string> friends = {"a", "b", "c"};
    // vector<string> gifts = {"a b", "b a", "c a", "a c", "a c", "c a"};
    cout << solution(friends, gifts);
    return 0;
}