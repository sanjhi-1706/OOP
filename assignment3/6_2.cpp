#include <iostream>
using namespace std;


class complex {
private:
    double real;
    double img;

public:
    complex(int a,int b){
        real=a;
        img=b;
    }
      friend void multiply(complex ,complex);  
};

void multiply(complex c1,complex c2){
    float real=(c1.real*c2.real)-(c2.img*c1.img);
    float img=(c1.real*c2.img)+(c1.img*c2.real);
    cout<<real<<"+"<<img<<"i"<<endl;
}

int main(){
    complex c1(2,3);
    complex c2(5,2);

    multiply(c1,c2);
    return 0;
}
    















