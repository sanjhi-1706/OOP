#include<bits/stdc++.h>
using namespace std;

struct letter{
    double weight;
   
void input(){
    cout<<"weight of letter:";
    cin>>weight;
}

double postagecalculation(){
    double postage;
    if(weight<=50){
        postage=(weight/10)*0.50;
    }
    else if(weight<=150){
        postage=5*0.50+((weight-50)/10)*0.40;
    }
    else if(weight<=400){
        postage=5*0.50+10*0.40+((weight-150)/10)*0.25;
    }
    else{
        postage=5*0.50+10*0.40+25*0.25+((weight-400)/1000)*25;
    }
    return postage ;
}
};

int main(){
    letter letter;
    letter.input();
    cout<<"letter postage:"<<letter.postagecalculation()<<endl;
    

    return 0;


}