package firsthomework;

public class Firsthomework {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

				int x,y,z;//一等奖人数,二等奖人数，三等奖人数
				for(x=0;x<30;x++)
				{
					for (y=0;y<30;y++)
					{
						for (z=0;z<30;z++)
						{
								if (x+y+z==30&&3*x+2*y+z==50)
								{
									System.out.println("方案有"+"一等奖"+x+"二等奖"+y+"三等奖"+z);
								}
						}
					}
				}
				
			
		}
	

}
