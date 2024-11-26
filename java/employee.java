package Hello;

import java.util.Scanner;

class getinfo{
	String name ;
	String lastname ;
	double salary;
	getinfo(){
		name="";
		lastname="";
		salary=0.0;
		
	}
	 void set() {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("name: ");
	        name = scanner.nextLine();

	        System.out.print("lastname: ");
	        lastname = scanner.nextLine();

	        System.out.print("Enter salary: ");
	        salary= scanner.nextDouble();
	        
	        //scanner.close();
	        
	        
	    }
	    void get() {
	    	System.out.println("name:"+name);
	    	System.out.println("lastname:"+lastname);
	    	if(salary>=0.0) {
	    	System.out.println("salary:"+salary);
	    	}
	    }
	    	
	    	double yearlysalary() {
	    		double yearlysalary=salary*12;
	    		return yearlysalary;
	    	}
	    	
	    	double newsalary() {
	    		return yearlysalary()+yearlysalary()*0.10;
	    	}
	    	
	    
}
public class employee {

	public static void main(String[] args) {
		getinfo A=new getinfo();
		getinfo B=new getinfo();
		A.set();
		B.set();
		A.get();
		B.get();
		System.out.println(A.yearlysalary());
		System.out.println(B.yearlysalary());
		System.out.println(A.newsalary());
		System.out.println(B.newsalary());
		
		
		
	}
		
	}


