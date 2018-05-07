package demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo01 {
	volatile int a = 0;
	
	public static void main(String[] args) {
		Demo01 demo01 = new Demo01();
			demo01.play();
	
	}
	
	
	void play(){
		 String str = "一口价 ¥9.0";
		 Pattern compile = Pattern.compile("\\d+\\.?\\d?+");
         Matcher matcher = compile.matcher(str);
         matcher.find();
         String fixedMoney = matcher.group();
         System.out.print(fixedMoney);
	}
}
