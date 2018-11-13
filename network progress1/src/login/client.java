package login;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Scanner;

public class client {
	public static void main(String[] args) throws Exception{
		String host = "10.132.48.182";
		int port = 8000;
		try {
			
			while (true)
			{
			Socket connection = new Socket(host,port);
			message info = new message();
			Scanner input = new Scanner(System.in);
			System.out.println("请输入操作选项,1:注册,3:代表登陆");
			info.setCommandID(input.nextInt());
			while(info.getCommandID() != 1 && info.getCommandID() != 3 && info.getCommandID()!=0)
			{
				System.out.println("请输入正确的操作选项,1:注册,3:登陆");
				info.setCommandID(input.nextInt());
			}
			System.out.println("请输入用户名。");
			info.setUserName(input.next());
			System.out.println("请输入密码。");
			info.setPassword(input.next());
			info.setTotalLength(info.getUserName().length()+info.getPassword().length()+4);
			OutputStream out = connection.getOutputStream();
			byte[] data = new byte[58];
			System.arraycopy(info.getUserName().getBytes("UTF-8"), 0, data, 0,info.getUserName().getBytes().length);
			System.arraycopy(info.getPassword().getBytes("UTF-8"), 0, data, 20, info.getPassword().getBytes().length);
			byte[] src;
			src = ByteBuffer.allocate(4).putInt(info.getCommandID()).array();
			System.arraycopy(src, 0, data, 50, 4);
			src = ByteBuffer.allocate(4).putInt(info.getTotalLength()).array();
			System.arraycopy(src, 0, data, 54, 4);
			out.write(data);
			byte[] backData = new byte[73];
			InputStream in = connection.getInputStream();
			in.read(backData);
			message echo = new message();
			echo.setCommandID(ByteBuffer.allocate(4).put(backData,0,4).getInt(0));
			echo.setTotalLength(ByteBuffer.allocate(4).put(backData,4,4).getInt(0));
			echo.setStatus(backData[8]);
			echo.setDescription(new String(backData,9,64,"UTF-8"));
			System.out.println(echo.getDescription());
			connection.close();
			}
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
