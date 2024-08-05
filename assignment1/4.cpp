#include<bits/stdc++.h>
using namespace std;

struct customer{
    string name;
    int calls;
    double bill;

void input(){
    cout<<"enter name of the customer:";
    cin>>name;
    getline(cin,name);
    cout<<"enter the no of calls:";
    cin>>calls;
}

void calculating(){
    if(calls<=100){
        bill=200.0;
    }
    else if(calls<=150){
        bill=200+(calls-100)*0.60;
    }
    else if(calls<=200){
        bill=200+50*0.60+(calls-150)*0.50;
    }
    else{
        bill=200+50*0.60+50*0.50+(calls-200)*0.40;
    }
}

void output(){
    cout<<name<<endl;
    cout<<"calls made:"<<calls<<endl;
    cout<<bill;
}
};

int main(){
    customer customer;
    customer.input();
    customer.calculating();
    customer.output();

    return 0;


}