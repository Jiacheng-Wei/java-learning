package twicehomework;

import java.util.Scanner;
public class Twicehomework {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int hundred=0,fifty=0,ten=0,five=0,two=0,one=0;
		System.out.println("请输入工资数");
		
		for (int i=0;i<10;i++)
		{
			int money=input.nextInt();
			int evehundred,evefifty,eveten,evefive,evetwo,eveone;
			evehundred=money/100;
			evefifty=(money%100)/50;
			eveten=(money%50)/10;
			evefive=(money%10)/5;
			evetwo=(money%5)/2;
			eveone=money%5%2;
			
			hundred=hundred+evehundred;
			fifty=fifty+evefifty;
			ten=ten+eveten;
			five=five+evefive;
			two=two+evetwo;
			one=one+eveone;
		}
		System.out.println("需要100元"+hundred+"张需要50元"+fifty+
				"张需要10元"+ten+"张需要5元"+five+"张需要2元"+two+"张需要1元"+one+"张");
	}

}
