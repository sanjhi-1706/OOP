#include<bits/stdc++.h>
using namespace std;

struct customer{
    string name;
    int earning;
    double bonus;

void input(){
    cout<<"enter name of the customer:";
    cin>>name;
    getline(cin,name);
    cout<<"enter the no of earning:";
    cin>>earning;
}

void calculating(){
    if(earning<2000){
        bonus=0;
    }
    else {
        bonus=(earning-200)*0.10;
    }
    
}

void output(){
    cout<<name<<endl;
    cout<<"earning made:"<<earning<<endl;
    cout<<bonus;
}
};

int main(){
    customer customer;
    customer.input();
    customer.calculating();
    customer.output();

    return 0;


}