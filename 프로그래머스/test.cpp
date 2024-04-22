#include <iostream>

<<<<<<< HEAD
typedef void (*general_fun)();

class base1 {};
class base2 {};

// single inheritance
class derived_s : base1 {};
// multiple inheritance
class derived_m : base1, base2 {};
// virtual inheritance
class derived_v :  virtual base1 {};
// unknown class
class unknown; 

typedef void (derived_s::*memFun_s)();
typedef void (derived_v::*memFun_v)();
typedef void (derived_m::*memFun_m)();
typedef void (unknown::*memFun_u)();

#define println(os) std::cout << os << std::endl

int main(int argc, char* argv[])
{

  println("size of general funcion = " << sizeof(general_fun));
  println("size of single instance member function = " << sizeof(memFun_s));
  println("size of multiple instance member function = " << sizeof(memFun_m));
  println("size of virtual instance member function = " << sizeof(memFun_v));
  println("size of unknown instance member function = " << sizeof(memFun_u));
  return 0;
=======
// 주어진 숫자의 n번째 비트와 m번째 비트를 바꾸는 함수
int swapBits(int num, int n, int m) {
    // n번째 비트와 m번째 비트를 추출합니다.
    int nthBit = (num >> n) & 1;
    int mthBit = (num >> m) & 1;

    // n번째 비트와 m번째 비트를 서로 바꿉니다.
    num = num & (~(1 << n)); // n번째 비트를 0으로 설정합니다.
    num = num | (mthBit << n); // n번째 비트에 m번째 비트의 값을 삽입합니다.
    num = num & (~(1 << m)); // m번째 비트를 0으로 설정합니다.
    num = num | (nthBit << m); // m번째 비트에 n번째 비트의 값을 삽입합니다.

    return num;
}

int main() {
    int originalNumber = 12;
    int n = 1; // 바꾸고 싶은 첫 번째 비트의 위치
    int m = 3; // 바꾸고 싶은 두 번째 비트의 위치

    int swappedNumber = swapBits(originalNumber, n, m);

    std::cout << "Original number: " << originalNumber << std::endl;
    std::cout << "Swapped number: " << swappedNumber << std::endl;

    return 0;
>>>>>>> laptop
}
//https://ospace.tistory.com/217
