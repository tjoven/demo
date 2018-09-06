package demo;

public class Demo03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = new StringBuilder("计算机").append("软件").toString();
		String str2 = new StringBuilder("ja1").append("va").toString();
		String str3 = new StringBuilder("ja1").append("va").toString();
		
		
		System.out.println((str1.intern()==str1));
		System.out.println((str2.intern()==str2));
		System.out.println((str3.intern()==str2));
		
	}

}
