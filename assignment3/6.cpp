#include<bits/stdc++.h>
using namespace std;

class B;
class A{
    float a;

    public:
    void geta(){
        cout<<"enter a:";
        cin>>a;
    }
     friend void mean(A,B);
};

class B{
    float b;
   
   public:
    void getb(){
        cout<<"enter b:";
        cin>>b;
    }
    friend void mean(A,B);
};

void mean(A num1, B num2)
{
   float mean=(num1.a+num2.b)/2;
   cout<<mean;
}


int main()
{
    A num1;
    B num2;
    num1.geta();
    num2.getb();

   
    mean(num1, num2); 
    return 0;
}



