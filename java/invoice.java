package Hello;


import java.util.Scanner;

class Input {
   String number;
   String description;
   int quantity;
   double price;

    Input() {
       number="";
       description="";
       quantity=0;
       price=0.0;
    }

    void set() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("number: ");
        number = scanner.nextLine();

        System.out.print("description: ");
        description = scanner.nextLine();

        System.out.print("Enter quantity: ");
        quantity = scanner.nextInt();

        System.out.print("Enter price: ");
        price = scanner.nextDouble();
        
        scanner.close();
        
        
    }
    void get() {
    	System.out.println("number:"+number);
    	System.out.println("description:"+description);
    	System.out.println("quantity:"+quantity);
    	System.out.println("price:"+price);
    	
   
}
    void calculate() {
    	if(quantity<0) quantity=0;
    	if (price<0.0) price=0.0;
    	double amount=quantity*price;
    	System.out.print("total amount :"+amount);
}
}

public class invoice {
	public static void main(String[] args) {
		Input A=new Input();
		A.set();
		A.get();
		A.calculate();
		
	}
	}

