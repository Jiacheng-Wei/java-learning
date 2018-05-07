package homework6;
import java.util.Scanner;
import java.util.Date;


class Account{
	private int id;
	private double balance;
	private String AnnualInterestRate = "0%";
	private Date dateCreated = new Date();
	
	Account() {
		id = 0;
		balance = 0;
	}
	
	Account(int ID,double BALANCE) {
		id = ID;
		balance = BALANCE;
	}
	
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", AnnualInterestRate=" 
					+ AnnualInterestRate+ ", dateCreated=" + dateCreated + "]";
	}

	public void SetID(int ID) {
		id = ID;
	}
	
	public void printID() {
		System.out.println(id);
	}
	
	public void SetBALANCE(double BALANCE) {                                       
		balance = BALANCE;
	}
	
	public void printBALANCE() {
		System.out.println(balance);
	}
	
	public double getBALANCE() {                                                     
		return balance;
	}
	
	public void SetAnnualInterestRate(String ANNUALINTERESTRATE) {
		AnnualInterestRate = ANNUALINTERESTRATE;
	}
	
	public void printAnnualInterestRate() {
		System.out.println(AnnualInterestRate);
	}
	
	public void LookUpDateCreated() {
		dateCreated = new Date();
	}
	
	public String getMonthlyInterestRate() {
		return AnnualInterestRate;
	}
	
	public double withDraw(double _balance1) {                                       
		if(_balance1 <= balance && _balance1 > 0) {
			balance = balance - _balance1;
			SetBALANCE(balance);
			System.out.println("Success!");
			return balance;
		}
		else {
			System.out.println("Error!");
			return balance;
		}
	}
	
	public double deposit(double _balance2) {                                       /*取款方法*/
		if(_balance2 > 0) {
			balance += _balance2;
			SetBALANCE(balance);
			System.out.println("Success!");
			return balance;
		}
		else {
			System.out.println("Error!");
			return balance;
		}
	}

}
public class ATM {
	public static void main(String[] args) {
		
		Account[] IDNumber = new Account[10];
		
		for(int i = 0; i < IDNumber.length; i++) {
			IDNumber[i] = new Account();                                    /*初始化对象数组*/
		}
		
		while(true) {
			Scanner input = new Scanner(System.in);
			
			
			
			System.out.print("Enter an ID:");
			int IDnumber = input.nextInt();
			System.out.println();
			
		
			
			if(IDnumber >= 100 && IDnumber <= 109) {                              /*菜单栏*/
				System.out.println("Main Menu:");
				System.out.println("1.Check Balance");
				System.out.println("2.Withdraw");
				System.out.println("3.Deposite");
				System.out.println("4.Exit");
				System.out.println();
				System.out.print("Enter a choice:");
				
				int chioce = input.nextInt();
				
				switch(chioce) {                                                             
				case 1:System.out.print("Your balance is:");                         
					IDNumber[IDnumber-100].printBALANCE();                                         /*输出余额*/
					break;
				case 2:System.out.print("How much do you want to withdraw:");
				int balances = input.nextInt();
				IDNumber[IDnumber-100].withDraw(balances);                                          /*存钱*/
					break;
				case 3:System.out.print("How much do you want to deposite:");
				int lalances1 = input.nextInt();
				IDNumber[IDnumber-100].deposit(lalances1);                         /*取钱*/
					break;
				case 4:break;  
				
				default:System.out.println("Error!");
					break;
				}
	System.out.println("id:" + IDnumber + " balance:" + IDNumber[IDnumber-100].getBALANCE()); /*为输入的账号添加初始信息*/
	IDNumber[IDnumber-100].SetID(IDnumber);
	IDNumber[IDnumber-100].SetBALANCE(IDNumber[IDnumber-100].getBALANCE());
	System.out.println(IDNumber[IDnumber-100]);
			}
			else {
				System.out.println("Please Enter The Right ID!");
			}
		}
	}
}