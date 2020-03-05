package com.endava.school4it.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

	@Autowired
	UtilService utilService;


	public int impartire(int a, int b) {
		return a / b;
	}

	public int inmultire(int a, int b) {
		return utilService.inmultire(a, b);
	}


}
