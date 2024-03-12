#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;
//백트래킹?
//조합으로(중복없는 조합 경우의 수) n+1만들어서 n+1리스트를 만드나?
//
bool canGoNext(vector<int> myHand){
    vector<int> arr = myHand;
    vector<bool> chk(arr.size(), true);
    sort(arr.begin(), arr.end());
    
    do{
        for(int i = 0; i<2; i++){ //조합 수
            //조합 구하기 https://twpower.github.io/82-next_permutation-and-prev_permutation
            arr[i];
        }
    }while(next_permutation(chk.begin(), chk.end()));


    return false;
}
void round(int coin, vector<int> myHand, int idx, vector<int> cards, vector<int>& results, int depth){
    //구매 프로세스가 있어야 할 듯
    //다음으로 진행 못 하면
    if(!canGoNext(myHand)){
        //현재 라운드 수 저장 후 리턴
        results.push_back(depth);
        return;
    }
    //다음으로 진행할 수 있으면 
    round(coin, myHand, idx+2, cards,results,depth++);
    return;
}

int solution(int coin, vector<int> cards) {
    int answer = 0;
    int n = cards.size(), num = n+1, idx = n/3;

    //첫 손
    vector<int> myHand(n/3,0);
    for(int i = 0; i<n/3; i++){
        myHand[i] = cards[i];
    }

    vector<int> results;
    round(coin, myHand, idx, cards, results, 1);
    answer = *max_element(results.begin(), results.end());

    return answer;
}

int main(){
    int coin = 4;
    vector<int> cards = {3,6,7,2,1,10,5,9,8,12,11,4};

    cout << solution(coin, cards);
    return 0;
}