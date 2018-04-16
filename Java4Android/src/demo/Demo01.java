package demo;

public class Demo01 {
	volatile int a = 0;
	
	public static void main(String[] args) {
		Demo01 demo01 = new Demo01();
			demo01.play();
	
	}
	
	void printA(String tag,int a){
		System.out.println(tag+":"+a);
		
	}
	
	void play(){
		 a = 0;
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				a++;
				printA("one",a);
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				a++;
				printA("other",a);
			}
		}).start();
	}
	
}
