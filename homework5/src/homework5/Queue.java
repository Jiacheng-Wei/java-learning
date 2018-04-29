package homework5;


public class Queue {
	private int[] element;
	private int size;
	
	public Queue(){
		element=new int[8];
		size=0;	
	}
	public void enqueue(int v) {
		element[size]=v;
		size++;
	}
	public void dequeue() {
		System.out.print(element[0]+" ");
		for (int i=0;i<7;i++)
		{
			element[i]=element[i+1];
		}
		size--;
	}
	public boolean empty() {
		if (size!=8)
			return true;
		else return false;
	}
	public int getSize() {
		return size;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue qu1=new Queue();
		System.out.println("被删除的队列元素：");
		for (int i=1;i<21;i++) {
			if (qu1.empty()){
				qu1.enqueue(i);
			}
			else if(qu1.getSize()==8) {
				qu1.dequeue();
				i--;
			}
		}
		System.out.println();
		System.out.println("未被删除的队列元素：");
		for (int i=0;i<8;i++) {
			qu1.dequeue();
		}
		
	}

}
