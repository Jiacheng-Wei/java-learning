package xiaoxuan4;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CPU cpu=new CPU();
		HandDisk HD=new HandDisk();
		cpu.setSpeed(1520);//��λHz
		HD.setAmount(1024);//��λg
		PC pc=new PC();
		pc.setCPU(cpu);
		pc.setHandDisk(HD);
		pc.show();
		

	}

}
