#include <iostream>
#include <vector>

using namespace std;

#define KNAP_MAX 6
#define ITEM_NUM 5

vector<char> name = {'A','B','C', 'D', 'E'};
vector<int> weight = {1, 2, 3, 4, 5};
vector<int> value = {100, 300, 350, 500, 650};
vector<vector<int>> maxValue(ITEM_NUM, vector<int>(KNAP_MAX+1, 0));

int lastItem[KNAP_MAX+1];

void showKnap(int item){
    int knap; //0~6kg

    cout<< name[item] <<", "<< weight[item] << "kg, " << value[item]<<"원 고려한 결과" <<endl;

    for(knap = 0; knap<= KNAP_MAX; knap++){
        cout << knap << "kg ";
        cout << maxValue[item][knap]<<"원 ";

        if(lastItem[knap] != -1){
            cout<<name[lastItem[knap]];
        }
        else{
            cout<<"None"<<endl;
        }
    }

    cout << endl;
}



int main(){
    int item, knap, selVal, totalWeight;
    item = 0;

    for(knap = 0; knap<= KNAP_MAX; knap++){
        if(weight[item]<= knap){
            maxValue[item][knap] = value[item];
            lastItem[knap] = item;
        }
        else{
            maxValue[0][knap]=0;
            lastItem[knap] = -1;
        }
    }
   // showKnap(item);

    for(item = 1; item<ITEM_NUM; item++){
        for(knap=0; knap<= KNAP_MAX; knap++){
            if(weight[item]<=knap){
                //선택한 경우의 가치 구하기
                selVal = maxValue[item-1][knap-weight[item]]+value[item];
                //가치가 크면 선택
                if(selVal>maxValue[item-1][knap]){
                    maxValue[item][knap] = selVal;
                    lastItem[knap] = item;

                }
                //가치가 크지 않으면 선택X
                else{
                    maxValue[item][knap] = maxValue[item-1][knap];
                }

            }
            else{
                maxValue[item][knap] = maxValue[item-1][knap];
            }
           // showKnap(item);
        }

        //cout << "배낭에 들어있는 물건 조사"<<endl;
        totalWeight = 0;
        for(knap = KNAP_MAX; knap >0; knap-= weight[item]){
            item = lastItem[knap];
           // cout << knap<<"kg 배낭에 마지막으로 넣은 물건 : "<<name[item] <<endl;
            totalWeight += weight[item];
           // cout<<name[item]<<", "<<weight[item]<<"kg, "<< value[item]<<"원 "<<endl;
            //cout<<knap<<"kg - "<<weight[item]<<"kg = "<<knap-weight[item]<<"입니다."<<endl; 
        }

        cout << "정답>> ";
        cout << "무게 합 : "<< totalWeight<<"kg"<<endl;
        cout << "가치 최댓값 : "<<maxValue[ITEM_NUM-1][KNAP_MAX];
    }


    return 0;
}