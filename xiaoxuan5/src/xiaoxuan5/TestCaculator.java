package xiaoxuan5;
import java.util.Scanner;

public class TestCaculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b;
		Scanner x=new Scanner(System.in);
		Scanner y=new Scanner(System.in);
		System.out.println("������������a��b��");
		a=x.nextInt();
		b=y.nextInt();
		Caculator caculator = new Caculator(a, b);
		System.out.println("����֮��="+caculator.add());
		System.out.println("����֮��="+caculator.subtract());
		System.out.println("����֮��="+caculator.multiple());
		System.out.println("����֮��="+caculator.divide());
	}

}
class Caculator {
	private int a;
	private int b;
	public Caculator(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public double add() {
		return a + b;
	}

	public double subtract() {
		return a - b;
	}

	public double multiple() {
		return a * b;
	}

	public double divide() {
		if(b == 0) {
			return 0;
		}
		return a / b;
	}
}