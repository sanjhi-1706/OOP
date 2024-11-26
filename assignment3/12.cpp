#include<bits/stdc++.h>
using namespace std;

class String{
    char a[30];

    public:
    String(char a[30]){
        strcpy(this->a,a);
    }

    friend int operator==(String a1,String a2){
        if(strcmp(a1.a,a2.a)==0) return 1;
        else return 0;
    }

    friend int operator>=(String a1,String a2){
        if(strcmp(a1.a,a2.a)>0) return 1;
        else return 0;
    }

    friend int operator<=(String a1,String a2){
        if(strcmp(a1.a,a2.a)<0) return 1;
        else return 0;
    }
    friend void compare(String a1,String a2);
};

void compare(String a1,String a2){
    if(a1==a2){
        cout<<a1.a<<" is equal to "<<a2.a<<endl;
    }
    if(a1>=a2){
        cout<<a1.a<<" is greater than "<<a2.a<<endl;
    }
    if(a1<=a2){
        cout<<a1.a<<" is less than "<<a2.a<<endl;
    }
}

int main(){
    String a1("sanjhi");
    String  a2("rani");
    compare(a1,a2);
  return 0;
}