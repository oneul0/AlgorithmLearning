#include <iostream>
#include <string>
#include <vector>
#include <set>
using namespace std;


int N;

bool canGoToNextRound(set<int>& myHands, set<int>& newCards)
{
    for (int card : myHands)
    {
        int isPossible = (N + 1) - card;
        if (newCards.find(isPossible) != newCards.end())
        {
            myHands.erase(card);
            newCards.erase(isPossible);
            return true;
        }
    }
    return false;
}

int solution(int coin, vector<int> cards)
{
    int rounds = 1;
    N = cards.size();
    set<int> myhands, newCards;

    for (int i = 0; i < N / 3; i++)
    {
        myhands.insert(cards[i]);
    }
    
    int nextIdx = N / 3;
    
    while (nextIdx < N)
    {
        //카드 뽑기
        for (int i = 0; i < 2; i++)
        {
            newCards.insert(cards[nextIdx++]);
        }
        //손패에서 가능하다면
        if (myhands.size() >= 2 && canGoToNextRound(myhands,myhands))
        {
            rounds++;
        }
        //손패 카드 1장 뽑은 카드 1장
        else if (myhands.size() >= 1 && coin >= 1 && canGoToNextRound(myhands, newCards)) 
        {
            rounds++;
            coin--;  
        }
        //뽑은 카드로만 2장
        else if (coin >= 2 && canGoToNextRound(newCards,newCards))
        {
            rounds++;
            coin -= 2;  
        }
        //모두 안된다면 다음 라운드로 갈 수 없음
        else
        {  
            break;
        }   
    }
    return rounds;      
}

int main(){
    int coin = 4;
    vector<int> cards = {3,6,7,2,1,10,5,9,8,12,11,4};

    cout << solution(coin, cards);
    return 0;
}