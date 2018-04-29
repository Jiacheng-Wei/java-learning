package xuan;

import java.util.Scanner;

public class homework {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);
		
		System.out.println("Enter the weight");
		double weight=input.nextDouble();
		System.out.println("Enter the height");
		double height=input.nextDouble();
		double BMI;
		BMI=weight/(height*height);
		if (BMI<18.5)
		{
			System.out.println("too light");
		}
		else if(BMI>=18.5&&BMI<23.9)
		{
			System.out.println("normal");
		}
		else if(BMI>=24&&BMI<=27)
		{
			System.out.println("heavy");
		}
		else if(BMI>=28&&BMI<=32)
		{
			System.out.println("fat");
		}
		else if(BMI>32)
		{
			System.out.println("too fat");
		}

	}

}
