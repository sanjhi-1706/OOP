#include<bits/stdc++.h>
using namespace std;

class class_2;
class class_1{
    float a;

    public:
    void geta(){
        cout<<"enter a:";
        cin>>a;
    }
     friend void exchange(class_1&,class_2&);
};

class class_2{
    float b;
   
   public:
    void getb(){
        cout<<"enter b:";
        cin>>b;
    }
    friend void exchange(class_1&,class_2&);
};

void exchange(class_1 &num1, class_2 &num2)
{
   float exchange=(num1.a+num2.b)/2;
   cout<<exchange;
}


int main()
{
    class_1 num1;
    class_2 num2;
    num1.geta();
    num2.getb();

   
    exchange(num1, num2); 
    return 0;
}



