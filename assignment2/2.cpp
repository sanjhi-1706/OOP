#include<bits/stdc++.h>
using namespace std;

struct item{
    int quantity;
    double unitprice;
    double discountrate;

     int getquantity(){
        cout<<"enter quantity :";
        cin>>quantity;
        return quantity;
    }

    double finalcost(){
        double total=quantity*unitprice;
        double discount=total*discountrate;
        return total-discount;
    }
   
};
 
struct order{
    item miners;
    item toaster;
    item fan;

    void totalamount(){
        double cost=miners.finalcost()+toaster.finalcost()+fan.finalcost();
         double salestax=cost*0.10;
         double total=cost+salestax;
        cout<<total<<endl;
    }
};

int main(){
   order order1;
   order1.miners.unitprice=1500;
   order1.toaster.unitprice=200;
   order1.fan.unitprice=450;

   order1.miners.discountrate=5;
   order1.toaster.discountrate=10;
   order1.fan.discountrate=15;

   order1.miners.getquantity();
   order1.toaster.getquantity();
   order1.fan.getquantity();

   order1.totalamount();
   return 0;
   
}
