package com.example.chainOfResponsibility;

public class BossHandler extends Handler{

	@Override
	public boolean limit(Problem problem) {
		if (problem.money<10000) {
			return true;
		}
		return false;
	}

}
