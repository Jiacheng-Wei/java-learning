package homework8;
import java.util.Scanner;

public class Complex implements Cloneable{
	private int a;
	private int b;
	
	public Complex() {
		a=0;
		b=0;
	}
	public Complex(int _a) {
		a=_a;
		b=0;
	}
	public Complex(int _a,int _b) {
		a=_a;
		b=_b;
	}
	public Complex add(Complex A,Complex B) {
		Complex C =new Complex();
		C.a=A.a+B.a;
		C.b=A.b+B.b;
		return C;
	}
	public Complex substract(Complex A,Complex B) {
		Complex C =new Complex();
		C.a=A.a-B.a;
		C.b=A.b-B.b;
		return C;		
	}
	public Complex multiply(Complex A,Complex B) {
		Complex C =new Complex();
		C.a=A.a*B.a-A.b*B.b;
		C.b=A.a*B.b+A.b*B.a;
		return C;
	}
	public Complex divide(Complex A,Complex B) {
		Complex C =new Complex();
		C.a=(A.a*B.a+A.b*B.b)/(B.a*B.a+B.b*B.b);
		C.b=(A.b*B.a-A.a*B.b)/(B.a*B.a+B.b*B.b);
		return C;
	}
	public double abs(Complex A) {
		return Math.sqrt(A.a*A.a+A.b*A.b);
	}
	public String toString() {
		if (b!=0) return a+"+"+"("+b+")"+"i";
		else return String.valueOf(a); 
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("��������������");
		Scanner in = new Scanner(System.in);
		System.out.println("�������һ��������ʵ�����鲿");
		int a,b;
		a = in.nextInt();
		b = in.nextInt();
		Complex D = new Complex(a,b);
		System.out.println("������ڶ���������ʵ�����鲿");
		int c,d;
		c = in.nextInt();
		d = in.nextInt();
		Complex E = new Complex(c, d);
		
		System.out.println("��Ϊ��" + D.add(D,E));
		System.out.println("��Ϊ��" + D.substract(D,E));
		System.out.println("��Ϊ��" + D.divide(D, E));
		System.out.println("��Ϊ��" + D.multiply(D, E));

	}

}
