 package com.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.interf.IStudentDao;

@Controller
public class LoginController {
	
	final static Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	private Student student1;
	
	@Autowired
	private Student student2;
	
	@Autowired
	private Student student3;

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "testIoc")
	public String testSpringIoc() {
/*
		System.out.println("-------------------" + student1.getCities());
		for (String city : student1.getCities()) {
			System.out.println("@@@@@@" + city);
		}*/
		student1.setStudId(101);
		student1.setName("Raju");
//		student1.getPpt().setCity("Hyderabad");
		
		System.out.println("----------------------");
		student2.setStudId(102);
		student2.setName("Ravi");
		
		
		
		System.out.println("Testing triggeered");
		System.out.println(student1.getStudId());
		System.out.println(student1.getName());
		
		System.out.println(student2.getStudId());
		System.out.println(student2.getName());
		
		return "Home";
	}
	
	@RequestMapping(value = "login")
	public String loginUser(@RequestParam("name") String userName, Model model) {

		model.addAttribute("name", userName);
		logger.info("Logged in User mobile number is : " + userName);
		//System.out.println("testing applicaiton" + userName);

		return "success";
	}

	@RequestMapping(value = "getAllStuds", method = RequestMethod.GET)
	public String getAllStudents(Model model) {
//		System.out.println("testing getAllStudentts");
		logger.info("testing getAllStudentts");
		Session session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();

		Query q = session.createQuery("from Student");

		List<Student> studentList = q.list();

		model.addAttribute("stdList", studentList);

		for (Student std : studentList) {
			logger.info("@@@@" + std.getName());
			System.out.println("-----" + std.getName());
		}

		return "success";
	}

	@RequestMapping(value = "/deleteStudent")
	public String deleteStudent(@RequestParam(value = "checkId") String[] selectedIds, Model model) {

		System.out.println("Login controller");
		List<Student> stdList = loginService.deleteStudent(selectedIds);

		model.addAttribute("stdList", stdList);

		return "success";
	}

	@RequestMapping(value="getStudent/{abc}")
	public String getStudent(@PathVariable(value="abc") String stdId, Model model) {
		System.out.println(stdId);
		Session session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
		session.beginTransaction();
		Student std = (Student) session.get(Student.class, Integer.parseInt(stdId));
		model.addAttribute("student", std);
		session.getTransaction().commit();
				
		return "editPage";
	}
	
	@RequestMapping(value="updateStudent", method=RequestMethod.POST)
	public String updateStudent(Student student, Model model) {
		System.out.println(student.getName());
		Session session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
		session.beginTransaction();
		session.update(student);
		
		Query q = session.createQuery("from Student");

		List<Student> studentList = q.list();
		session.getTransaction().commit();
		model.addAttribute("stdList", studentList);
		
		return "success";
	}
}
