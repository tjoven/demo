package demo;

public class Demo02 {
	static String a  = "a";
	static Demo01 demo01 = new Demo01();
	static Demo01 get(){
		demo01.a = 111; 
		return demo01;
		
	}
	
}
