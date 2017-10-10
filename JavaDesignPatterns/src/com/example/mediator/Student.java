package com.example.mediator;

/**
 * 每个对象 都包含 中介的引用
 * @author car
 *
 */
public abstract class Student {
	Mediator mediator;
	public Student(Mediator mediator) {
		this.mediator=mediator;
	}

}
