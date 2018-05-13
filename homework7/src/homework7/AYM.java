package homework7;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

class Transation{
	private Date date =new Date();
	private char type;
	private double amount;
	private double balance;
	private String description;
	
	public Transation(Date _date,char _type,double _amount,double _balance, String _description) {
			super();
			date=_date;
			type=_type;
			amount=_amount;
			balance= _balance;
			description=_description;
		}
	public String toString() {
		return "Transation [date="+date+",type="+type+",amount"+amount+",balance="+balance+",description is "+description+"]";
	}
}	
class Account{
	private int id;
	private String name;
	private double balance;
	private double AnnualInterestRate;
	private Date dateCreated =new Date();
	private ArrayList<Transation> transations=new ArrayList<>();

	public Account(){
		id=0;
		balance=0;
	}
	
	public Account(int _id,double _balance, String _name ){
		id = _id;
		balance = _balance;
		name=_name;
	}
	public String toString() {
		return "Account [id=" +id+",name is"+name+",balance="+balance+",AnnualInterestRate="
				+AnnualInterestRate+",dateCreated="+dateCreated+"]";
	}
	public void SetID(int _id) {
		id=_id;
	}
	public void PrintID() {
		System.out.println(id);
	}
	public void SetName(String _name) {
		name=_name;
	}
	public void printName() {
		System.out.println(name);
	}
	public void SetBALANCE(double _balance) {
		balance=_balance;
	}
	public void printBALANCE() {
		System.out.println(balance);
	}
	public double getBALANCE() {
		return balance;
	}
	public void SetAnnualInterestRate(double _annualinterestrate) {
		AnnualInterestRate = _annualinterestrate;
	}
	public void printAnnualInterestRate() {
		System.out.println(AnnualInterestRate);
	}

	public void LookUpDateCreated() {
		dateCreated =new Date();
	}
	public double getMonthlyInterestRate() {
		return AnnualInterestRate;
	}
	public void withDraw(double _balance1) {
		if (_balance1<=balance&&_balance1>0) {
			balance=balance-_balance1;
			SetBALANCE(balance);
			System.out.println("Success!");
			Transation T= new Transation(new Date(),'W', _balance1, balance, "Withdraw"+_balance1);
			transations.add(T);
		}
		else {
			System.out.println("Error!");
		}
	}
	public void deposit(double _balance2) {
		if (_balance2>0) {
			balance+=_balance2;
			SetBALANCE(balance);
			System.out.println("Success!");
			Transation T= new Transation(new Date(),'D', _balance2, balance, "Deposit"+_balance2);
			transations.add(T);
		}
		else {
			System.out.println("Error!");
		}
	}
	public void printTransation() {
		for(int i=0;i<transations.size();i++) {
			System.out.println(transations.get(i));
		}
	}
}

public class AYM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			Scanner input=new Scanner(System.in);
			int _id=input.nextInt();
			double _balance=input.nextDouble();
			String _name=input.nextLine();
			Account account=new Account(_id,_balance,_name);
			account.SetAnnualInterestRate(0.015);
			System.out.println();
			while (true) {
				System.out.println("Main Menu:");
				System.out.println("1.Check Balance");
				System.out.println("2.Withdraw");
				System.out.println("3.Deposite");
				System.out.println("4:History");
				System.out.println("5.Exit");
			
				System.out.println();
				System.out.print("Enter a choice:");
				
				int chioce = input.nextInt();
				
			
				switch(chioce) {                                                             
					case 1:System.out.print("Your balance is:");                         
						account.printBALANCE();                                         /*输出余额*/
						break;
					case 2:System.out.print("How much do you want to withdraw:");
						int balances = input.nextInt();
						account.withDraw(balances);                                          /*存钱*/
						break;
					case 3:System.out.print("How much do you want to deposite:");
						int balances1 = input.nextInt();
						account.deposit(balances1);                         /*取钱*/
						break;
					case 4:
						System.out.println(account);
						account.printTransation();
						break;  
					case 5:
						break;
					default:System.out.println("Error!");
						break;
				}
				System.out.println("是否退出本轮操作？（TRUE或FALSE）");
				boolean choice2=input.nextBoolean();
				if (choice2) {
					break;
				}
			}	
		}
}
