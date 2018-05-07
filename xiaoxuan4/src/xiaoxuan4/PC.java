package xiaoxuan4;

public class PC {
	CPU cpu;
	HandDisk HD;
	public void setCPU(CPU cpu) {
		this.cpu=cpu;
	}
	public void setHandDisk(HandDisk HD) {
		this.HD=HD;
	}
	public void show() {
		System.out.println("CPU Speed is"+cpu.getSpeed());
		System.out.println("HandDisk Amount is"+HD.getAmount());
	}
}
