package practice3;
import java.util.Scanner;

public class ComputerAverage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);
		
		System.out.print("Enter three numbers:");
		double number1=input.nextDouble();
		double number2=input.nextDouble();
		double number3=input.nextDouble();
		
		double average=(number1+number2+number3)/3;
		
		System.out.println("the average of"+number1+","+number2+","+number3+
				"is"+average);
	}

}
