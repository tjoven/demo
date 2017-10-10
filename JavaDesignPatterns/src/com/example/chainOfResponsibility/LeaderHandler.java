package com.example.chainOfResponsibility;

public class LeaderHandler extends Handler{

	@Override
	public boolean limit(Problem problem) {
		if (problem.money<1000) {
			return true;
		}
		return false;
	}

}
