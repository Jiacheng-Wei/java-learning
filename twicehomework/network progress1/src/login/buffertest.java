package login;

import java.io.DataOutputStream;
import java.nio.ByteBuffer;
import java.util.Scanner;

public class buffertest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte[] num = new byte[4];
		int t = -1;
		for(int i = 0; i < 4; i++)
		{
			num[i] = (byte)((t >> 8*i) & 0xff);
		}
		int arr = num[0] & 0xff;
		arr |= (num[1] & 0xff) << 8;
		arr |= (num[2] & 0xff) << 16;
		arr |= (num[3] & 0xff) << 24;
		System.out.println(arr);
		int a = 12091309;
		double b = 12.87467;
		ByteBuffer bb = ByteBuffer.allocate(12);
		bb.putInt(a).putDouble(b);
		a = bb.getInt(0);
		b = bb.getDouble(4);
		System.out.println(a);
		System.out.println(b);	
	}
}
