package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.interf.IStudentDao;

@Service
public class LoginService {

	@Autowired
	IStudentDao dao;
	
	public List deleteStudent(String[] selectedIds) {

		System.out.println("Login service");
		//calculation
		List<Student> stdList =  dao.deleteStudent(selectedIds);

		return stdList;
	}
}
