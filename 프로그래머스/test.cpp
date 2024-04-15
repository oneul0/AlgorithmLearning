#include <iostream>

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
}
//https://ospace.tistory.com/217
