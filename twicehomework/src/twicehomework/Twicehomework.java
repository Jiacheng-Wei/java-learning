package twicehomework;

import java.util.Scanner;
public class Twicehomework {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int hundred=0,fifty=0,ten=0,five=0,two=0,one=0;
		System.out.println("�����빤����");
		
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
		System.out.println("��Ҫ100Ԫ"+hundred+"����Ҫ50Ԫ"+fifty+
				"����Ҫ10Ԫ"+ten+"����Ҫ5Ԫ"+five+"����Ҫ2Ԫ"+two+"����Ҫ1Ԫ"+one+"��");
	}

}
