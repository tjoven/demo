package com.example.factory;

import java.net.InterfaceAddress;
/**
 * 简单的工厂模式
 * 想要生成多个工厂，可以把Factory声明称接口，然后去实现它FactoryA,FactoryB...
 * @author car
 *
 */
public class Factory  {
	public static  <T> T produce(Class<?> T) {
		Product product = null;
		try {
			product = (Product) Class.forName(T.getName()).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return (T) product;
	}

}
