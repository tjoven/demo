package com.example.chainOfResponsibility;

public class ManagerHandler extends Handler{

	@Override
	public boolean limit(Problem problem) {
		if (problem.money<5000) {
			return true;
		}
		return false;
	}
}
