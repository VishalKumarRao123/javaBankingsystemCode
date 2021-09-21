package lab_3;
import java.util.Scanner;

class Account{
	int acno;
    String name;
    double balance;
    public void createAccount(int i) {
    	System.out.print("Enter Name :- ");
    	Scanner sc = new Scanner(System.in);
    	name = sc.nextLine();
    	balance  = 0.000;
    	acno = 1000+i;
    	System.out.println("Account is Created !");
    	System.out.println("Name   AccoutNo.  Avl..Balance");
    	System.out.println(name+"   "+acno+"          "+balance);
    }
    public static  void deposit(Account obj[] ,int i) {
    	if(i==0) {
    		System.out.println("First Create Atleast One Account !");
    	}
    	else {
    	System.out.print("Enter Account No. to Deposit :-");
    	int acn,j;
    	Scanner sc  = new Scanner(System.in);
    	acn = sc.nextInt();
    	for( j=0;j<i;j++) {
    		if(obj[j].acno==acn) {
    			System.out.print("Enter Amount to Deposit :-");
    			double amt = sc.nextDouble();
    			obj[j].balance=obj[j].balance+amt;
    			System.out.println("Amount is deposited Successfully !");
    			System.out.println("Name     AccoutNo.     Avl..Balance");
    			System.out.println(obj[j].name+"    "+obj[j].acno+"              "+obj[j].balance);
    			break;
    		}
    	}
    	if(j==i)
    		System.out.println("Invalid Account Number !");
    }}
    public static void withDraw(Account obj[],int i) {
    	if(i==0) {
    		System.out.println("First Create Atleast One Account !");
    	}
    	else {
    	System.out.print("Enter Account No. to WithDraw :-");
    	int acn,j;
    	Scanner sc  = new Scanner(System.in);
    	acn = sc.nextInt();
    	for(j=0;j<i;j++) {
    		if(obj[j].acno==acn) {
    			System.out.print("Enter Amount to WithDraw :-");
    			double amt = sc.nextDouble();
    			if(amt<=obj[j].balance) {
    				System.out.println("Amount is deposited Successfully !");
    				obj[j].balance=obj[j].balance-amt;
        		
    			}
    			else
    			    System.out.println("Your Balance is Not Sufficient !");
    			System.out.println(obj[j].name+" "+obj[j].acno+" "+obj[j].balance);
    			break;
    		}
    	}
    	if(j==i)
    		System.out.println("Invalid Account Number !");
    }}
    public static void transfer(Account obj[],int i) {
    	if(i==0) {
    		System.out.println("First Create Atleast One Account !");
    	}
    	else {
    	boolean f=false,s=false;
    	int sender=0,receiver=0,j=0,a=0,b=0;
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Enter Account no. of Sender :-");
    	sender = sc.nextInt();
    	System.out.print("Enter Account no. of Receiver :-");
    	receiver = sc.nextInt();
    	for( j=0;j<i;j++) {
    		if(obj[j].acno==sender) {
    			a=j;
    			f=true;
    		}
    			
    		else if(obj[j].acno==receiver) {
    			b=j;
    			s=true;
    		}
    			 
    		if(f==true&&s==true)
    			break;
    	}
    	if(!f&&!s)
    		  System.out.println("Both Account no are Invalid !");
    	else if(!f)
    		 System.out.println("Sender's Account no are Invalid !");
    	else if(!s)
   		 System.out.println("Receiver's Account no are Invalid !");
    	else {
    		System.out.print("Enter Amount to transfer : ");
    		int amt = sc.nextInt();
    		if(obj[a].balance>=amt) {
    			obj[a].balance=obj[a].balance-amt;
    			obj[b].balance=obj[b].balance+amt;
    			System.out.println("Transaction is Completed !");
    			System.out.println("Name   AccoutNo.  Avl..Balance");
    	    		System.out.println("Sender:- "+obj[a].name+"    "+obj[a].acno+"       "+obj[a].balance);
    	    		System.out.println("Receiver:- "+obj[b].name+"    "+obj[b].acno+"       "+obj[b].balance);
    		}
    		else
    		{
    			System.out.println(obj[a].balance+" has Not Enough Balance to transfer Required Amount !");
    		}
    	}}
    }
    public static void printallAc(Account obj[],int i) {
    	if(i==0) {
    		System.out.println("First Create Atleast One Account !");
    	}
    	else {
    	System.out.println("Name   AccoutNo.  Avl..Balance");
    	for(int j=0;j<i;j++) {
    		System.out.println(obj[j].name+"    "+obj[j].acno+"       "+obj[j].balance);
    	}
    }}
}
public class BankAccount {
    static int i=0;
	public static void main(String[] args) {
	 Account[] obj = new  Account[100];
	 System.out.println("*******************************");
	 System.out.println("* 1--->Create an Account      *");
	 System.out.println("* 2--->Deposit Amount         *");
	 System.out.println("* 3--->Withdraw               *");
	 System.out.println("* 4--->Transfer               *");
	 System.out.println("* 5--->Print All Accounts     *");
	 System.out.println("* 6--->Exit                   *");
	 System.out.println("*******************************");
	 boolean b=true;
	 while(b) {
	 int choice ;
	 Scanner sc = new Scanner(System.in);
	 System.out.print("Enter Your Choice : ");
	 choice = sc.nextInt();
	 switch(choice) {
	 case 1:Account o = new Account();
		    o.createAccount(i);
		    obj[i]=o;
	          i=i+1;
	          break;
	 case 2 : Account.deposit(obj,i);
	          break;
	 case 3 : Account.withDraw(obj,i);
	 		  break;
	 case 4 : Account.transfer(obj,i);
	 		   break;
	 case 5 : Account.printallAc(obj,i);
	          break;
	 case 6 : 
		       System.out.println("Thank You !");
		        b=false;
	           break;
	 default : System.out.println("Invalid Choice");
	 }}
	}

}
