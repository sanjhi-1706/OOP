//WAP to add and substract two number. Let the add() accept the objects using call-by-value 
//technique, subtract() using call-by-reference, and multiply() accept using the call-by-address technique.
#include<iostream>
using namespace std;
class math{
    private:
    int a,b,sum,sub,pro;
    public:
    int add(int a,int b){
        this->a=a;
        this->b=b;
        sum=a+b;
        return sum;
    }
    int diff(int * x,int *y){
        a=*x;
        b=*y;
        if(a>=b)
        sub=a-b;
        else
        sub=b-a;
        return sub;
    }
    int mul(int a,int b){
        this->a=a;
        this->b=b;
        pro=a*b;
        return pro;
    }
    void print(){
        cout<<"sum: "<<add(2,9)<<endl;
        int k=8,n=5;
         cout<<"diff: "<<diff(&k,&n)<<endl;
         int *u,*v;
         u=&k;v=&n;
         cout<<"mul:"<<mul(*u,*v);
    }
};
int main(){
    math m;
    m.print();
}