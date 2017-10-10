package com.example.mediator;

/**
 * 中介者控制 联系所有对象
 * @author car
 *
 */
public class ConcreteMediator extends Mediator {

	StudentA studentA;
	StudentB studentB;
	@Override
	public void change(Student student) {//选择 调节那两个对象
		if (student==studentA) {
			handleA((StudentA)student);
		}else if (student==studentB) {
			handleB((StudentB)student);
		}
		
	}

	public void setStudentA(StudentA studentA){
		this.studentA=studentA;
	}
	public void setStudentB(StudentB studentB){
		this.studentB=studentB;
	}

	public void handleA(StudentA student) {
		studentB.receive(student.msg);
		
	}
	public void handleB(StudentB student) {
		studentA.receive(student.msg);
		
	}
	
}
