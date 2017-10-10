package com.example.factory;
/**
 * 工厂模式
 * @author car
 *
 */
public class FactoryPattern {
public static void main(String[] args) {
	Product product=Factory.produce(ProductA.class);
	product.method();
}
}
