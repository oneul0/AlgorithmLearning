#include <iostream>
#include <algorithm>
#include <map>
#include <string>
#include <sstream>

using namespace std;

int N, DDD, hh, mm, F;
char dash, colon;
string input, inputs;

int year,month,day,hour,minute;
string model, name;

class Rental_info{
    private:
    int N, DDD, HH, MM, F;
    //map<string, string>    

    public:
    void note_info_update(int n, int ddd, int hh, int mm, int f){
        this -> N = n;
        this -> DDD = ddd;
        this -> HH = hh;
        this -> MM = mm;
        this -> F = f;
    }
};
class Rentals{
    private:
    int YEAR, MONTH, DAY, HOUR, MINUTE=0;
    string MODEL, NAME;

    public:
    void info_update(int year, int month, int day, int hour, int minute, string model, string name){
        this -> MINUTE += year;
        this -> MONTH = month;
        this -> DAY = day;
        this -> HOUR = hour;
        this -> MINUTE = minute;
        this -> MODEL = model;
        this -> NAME = name;
    }
};

int main(){
    Rental_info rinfo = Rental_info();

    //대여장 정보
    getline(cin, input);
    istringstream ss(input);
    ss >> N >> DDD >> dash >> hh >> colon >> mm >> F;
    rinfo.note_info_update(N, DDD, hh, mm, F);
    
    //Rentals rent[N];
    //대여 정보 작성
    Rentals rent = Rentals();
    for(int i = 0; i<N; i++){

        getline(cin, inputs);
        istringstream ss(inputs);
        ss >> year >> dash >> month >> dash >> day >> dash >> hour >> colon >> minute >> model >> name;
    }
    


    return 0;
}