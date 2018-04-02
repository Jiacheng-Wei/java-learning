package twicehomework;

import java.util.Scanner;
public class Twicehomework {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		for (int i=0;i<10;i++)
		{
			System.out.println("请输入工资数");
			int money=input.nextInt();
			int hundred,fifty,ten,five,two,one;
			hundred=money/100;
			fifty=(money%100)/50;
			ten=(money%50)/10;
			five=(money%10)/5;
			two=(money%5)/2;
			one=money%5%2;
			
			System.out.println("需要100元"+hundred+"张需要50元"+fifty+
					"张需要10元"+ten+"张需要5元"+five+"张需要2元"+two+"张需要1元"+one+"张");
			
		}

	}

}
