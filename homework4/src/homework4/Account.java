package homework4;
import java.util.Date;

public class Account {
	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated;
	
	public Account() {
		id=0;
		balance=0;
		annualInterestRate=0;
		dateCreated=new Date();
	}
	
	public Account(int _id, double _balance) {
		id=_id;
		balance=_balance;
	}
	public int getId() {
		return id;
	}
	public void setId(int _id) {
		id= _id;
	}
	public void setBalance(double _balance) {
		balance=_balance;
	}
	public double getBalance() {
		return balance;
	}
	public void setAnnualInterestRate(double _annualInterestRate) {
		annualInterestRate=_annualInterestRate;
	}
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	public void setDateCreated(Date _dateCreated) {
		dateCreated=_dateCreated;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void withDraw(double _money) {
		balance=balance-_money; 
	}
	public void deposit(double _money) {
		balance=balance+_money;
	}
	public void printInfo() {
		System.out.println("Account [balance=" + balance + ", annuallneterestRate=" + (annualInterestRate*100) + "%, dateCreated="  
				   + dateCreated + "]");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account=new Account(1122,20000);
		account.setAnnualInterestRate(0.045);
		account.setDateCreated(new Date());
		
		account.printInfo();
		
		account.withDraw(2500);
		account.printInfo();
		account.deposit(3000);
		
		account.printInfo();
	}

}
