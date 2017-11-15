package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.controllers.Student;
import com.dao.interf.IStudentDao;

//@Repository
@Component
public class StudenDaotImpl implements IStudentDao {

	public List<Student> deleteStudent(String[] selectedIds) {
		System.out.println("Executing Hibernate code");
		Session session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();

		//Delete students one by one
		for (String selectedId : selectedIds) {

			session.beginTransaction();
			Student std = (Student) session.get(Student.class, Integer.parseInt(selectedId));
			session.delete(std);

			session.getTransaction().commit();
		}

		//Fetch remaining students to show in jsp
		Query q = session.createQuery("from Student");

		List<Student> studentList = q.list();
		
		return studentList;
	}

}
