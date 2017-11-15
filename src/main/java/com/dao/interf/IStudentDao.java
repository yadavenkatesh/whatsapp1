package com.dao.interf;

import java.util.List;


import com.controllers.Student;

public interface IStudentDao {

	public List<Student> deleteStudent(String[] selectedIds);
}
