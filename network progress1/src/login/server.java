package login;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;

public class server {
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		try {
			ServerSocket serversocket = new ServerSocket(12000);
			System.out.println("server starts");
			Socket s = null;
			//-------------------------------------------
			while(true)
			{
				s = serversocket.accept();
				System.out.println("connect");
				message info = new message();
				byte[] data = new byte[58];
				InputStream ip = s.getInputStream();
				ip.read(data);
				String username = new String(data,0,20,"UTF-8");
				String password = new String(data,20,30,"UTF-8");
				info.setUserName(username);
				info.setPassword(password);
				ByteBuffer bb = ByteBuffer.allocate(4);
				info.setCommandID(bb.put(data,50,4).getInt(0));
				info.setTotalLength(((ByteBuffer) bb.clear()).put(data, 54, 4).getInt(0));
				System.out.println(info.getPassword()+info.getUserName()+info.getCommandID()+info.getTotalLength());
				//------------------------------------------
				message echo = new message();
				if(info.getCommandID()==1)
				{	
					echo.setCommandID(2);
					String path = "password.txt";
					System.out.println(path);
					try 
					{
						FileOutputStream fout = new FileOutputStream(path,true);
						PrintStream p = new PrintStream(fout);
						String saveData = info.getUserName()+"*"+info.getPassword().hashCode();
						File f = new File(path);
						BufferedReader br = new BufferedReader(new FileReader(f));
						String temp = br.readLine();
						boolean flag = true;
						while(temp!=null)
						{
							String[] tmpSplit = temp.split("\\*");
							if(tmpSplit[0].equals(info.getUserName()))
							{
								echo.setStatus((byte)0);
								echo.setDescription("ÕÊ»§ÒÑ´æÔÚ");
								flag = false;
								break;
							}	
							temp = br.readLine();
							flag = true;
						}	
						if(flag)
						{
							p.println(saveData);
							echo.setStatus((byte)1);
							echo.setDescription("×¢²á³É¹¦");
						}	
						System.out.println(saveData);
						br.close();
						p.close();	
					}	
					catch(FileNotFoundException e) {
						e.printStackTrace();
					}
					echo.setTotalLength(echo.getDescription().length()+5);
				}	
				else if(info.getCommandID()==3)
				{
					echo.setCommandID(4);
					String path2 = "password.txt";
					System.out.println(path2);
					File f2 = new File(path2);
					if(!f2.exists())
					{
						echo.setStatus((byte)0);
						echo.setDescription("ÕÊ»§Î´×¢²á");
					}
					else
					{
						try {
							BufferedReader br = new BufferedReader(new FileReader(f2));
							boolean flag2 = true;
							String temp = br.readLine();
							System.out.println(temp);
							while(temp != null)
							{
								if(temp.equals(info.getUserName()+"*"+info.getPassword().hashCode()))
								{
									echo.setStatus((byte)1);
									echo.setDescription("µÇÂ½³É¹¦");
									flag2 = false;
									break;
								}
								else{
									flag2 = true;
									temp = br.readLine();
								}
							}
							if(flag2)
							{
								echo.setStatus((byte)0);
								echo.setDescription("ÕÊ»§»òÃÜÂë´íÎó£¬µÇÂ½Ê§°Ü");
							}
							br.close();
						}
						catch (FileNotFoundException e) {
							e.printStackTrace();
						}
						echo.setTotalLength(echo.getDescription().length()+5);
					}
				}
			//------------------------------------------
				byte[] backData = new byte[73];
				byte[] src = null;
				src = ByteBuffer.allocate(4).putInt(echo.getCommandID()).array();
				System.arraycopy(src, 0, backData, 0, 4);
				src = ByteBuffer.allocate(4).putInt(echo.getTotalLength()).array();
				System.arraycopy(src, 0, backData, 4, 4);
				backData[8] = echo.getStatus();
				src = echo.getDescription().getBytes("UTF-8");
				System.arraycopy(src, 0, backData, 9 , src.length);
				OutputStream op = s.getOutputStream();
				op.write(backData);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}