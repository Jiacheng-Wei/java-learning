package twicehomework;

import java.util.Scanner;
public class Twicehomework {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		for (int i=0;i<10;i++)
		{
			System.out.println("�����빤����");
			int money=input.nextInt();
			int hundred,fifty,ten,five,two,one;
			hundred=money/100;
			fifty=(money%100)/50;
			ten=(money%50)/10;
			five=(money%10)/5;
			two=(money%5)/2;
			one=money%5%2;
			
			System.out.println("��Ҫ100Ԫ"+hundred+"����Ҫ50Ԫ"+fifty+
					"����Ҫ10Ԫ"+ten+"����Ҫ5Ԫ"+five+"����Ҫ2Ԫ"+two+"����Ҫ1Ԫ"+one+"��");
			
		}

	}

}
