package homework3;
import java.util.Scanner;
import java.util.Random;

public class Homework {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b;
		Scanner input=new Scanner(System.in);
		System.out.println("�����������������");
		a=input.nextInt();
		System.out.println("�����������������");
		b=input.nextInt();
		Random rand=new Random(20);
		int[][] arr1=new int[a][b];
		for (int i=0;i<a;i++)
		{
			for (int j=0;j<b;j++)
			{
				arr1[i][j]=(int)(rand.nextInt(2));
				System.out.print(arr1[i][j]+" ");
			}
			System.out.println();
		}
		
		int[] arr2=new int[a];
		int count=0;
		System.out.println("������ж�Ϊ1��0�����:");
		for (int i=0;i<a;i++)//������ж�Ϊ1��0�����
		{
			int count1=0;
			for (int j=0;j<b;j++)
			{
				if (arr1[i][j]==arr1[i][0])
				{
					count1++;
					continue;
				}
				else 
				{
					break;
				}
			}
			if (count1==b)
			{
				arr2[count]=i;
				count++;
			}
		}
		if (count!=0)
		{
			for (int i=0;i<count;i++)
			{
				System.out.print(arr2[i]+" ");
			}
		}
		else 
		{
			System.out.print("��");
		}
		System.out.println();
		

		
		System.out.println("������ж�Ϊ1��0�����:");
		int[] arr3=new int[b];
		count=0;
		for (int i=0;i<b;i++)//������ж�Ϊ1��0�����
		{
			int count1=0;
			for (int j=0;j<a;j++)
			{
				if (arr1[j][i]==arr1[0][i])
				{
					count1++;
					continue;
				}
				else 
				{
					break;
				}
			}
			if (count1==a)
			{
				arr3[count]=i;
				count++;
			}
		}
		if (count!=0)
		{
			for (int i=0;i<count;i++)
			{
				System.out.print(arr3[i]+" ");
			}
		}
		else 
		{
			System.out.print("��");
		}
		System.out.println();
		
		System.out.println("���Խ��߶�Ϊ1��0������:");
		count=0;//�Խ���ȫΪ0��1������
		if (a==b)
		{
			int count1=0;
			for (int i=0;i<a;i++)
			{
				if (arr1[i][i]==arr1[0][0])
				{
					count1++;
				}
			}
			if(count1==a)
			{
				count++;
				System.out.println("left");
			}
			
			int count2=0;
			for (int i=0,j=a-1;i<a&&j>=0;i++,j--)
			{
				if (arr1[i][j]==arr1[0][b-1])
				{
					count2++;
				}
			}
			if (count2==a)
			{
				count++;
				System.out.println("right");
			}
			
			System.out.println(count);
		}
		else
		{
			System.out.println(0);
		}

		
	}

}
