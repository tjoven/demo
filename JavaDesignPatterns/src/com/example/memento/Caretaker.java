package com.example.memento;

import java.util.ArrayList;

/**
 * 管理 备忘录 不进行任何操作，只负责将备忘录传递给其他对象
 * 可以多次存档
 * @author car
 *
 */
public class Caretaker {
	Memento memento;
	ArrayList<Memento> list=new ArrayList<Memento>();
	public ArrayList<Memento> getMementos() {
		return list;
	}

	public void addMemento(Memento memento) {
		if (list.size()>1) {//最多存2条数据 最后的两条数据
			list.remove(0);
		}
		list.add(memento);
		
	}
}
