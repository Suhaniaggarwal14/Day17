
package com.graymatter.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.graymatter.model.Student;

@Controller
public class StudentController {

	List<Student> sts=new ArrayList<>();
	
	@RequestMapping("/login")
public ModelAndView login(@RequestParam String username, @RequestParam String password) {
	ModelAndView mv=null;
	if(username.equals("hello")&&password.equals("123"))
	{
		mv=new ModelAndView("Dashboard");
		mv.addObject("username",username);
		return mv;
	}
	mv=new ModelAndView("login");
	mv.addObject("error","Invalid Credentials");
	return mv;
}
	@RequestMapping("/dologin")	
public ModelAndView dologin() {
		return new ModelAndView("login");
}
	
	@RequestMapping("/addStundent")
	public ModelAndView addform() {
		return new ModelAndView("addStudent");
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteform() {
		return new ModelAndView("delete");
	}
	
	@RequestMapping("/getallstundent")
	public ModelAndView getall() {
		return new ModelAndView("getAllStudent");
	}
	
	@RequestMapping("/update")
	public ModelAndView updateform() {
		return new ModelAndView("update");
	}
	
	@RequestMapping("/getStundent")
	public ModelAndView getform() {
		return new ModelAndView("getStudent");
	}
	
	@RequestMapping("/add")
	public ModelAndView add(@RequestParam String name,@RequestParam String id,@RequestParam String course) {
	sts.add(new Student(name,Integer.parseInt(id),course));
	return new ModelAndView("Dashboard");
	}
	
	
	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam String id) {
		int id1=Integer.parseInt(id);
		 Iterator<Student> iterator = sts.iterator();
	        while (iterator.hasNext()) {
	            Student student = iterator.next();
	            if (student.getId() == id1) {
	                iterator.remove();
	                break;
	            }
	        }
	return new ModelAndView("Dashboard");
	}
	
	@RequestMapping("/getAll")
	public ModelAndView getAll() {
    ModelAndView mv=new ModelAndView("display");
    mv.addObject("sts",sts);
    mv.addObject("action", "All");
	return mv;
	}
	
	
	@RequestMapping("/getStudent")
	public ModelAndView getStudent(@RequestParam String id) {
		int id1=Integer.parseInt(id);
		Student sd=null;
		for (Student s : sts) {
			if(s.getId()==id1)
			{
				sd=new Student(s.getName(),id1,s.getCourse());
				break;
			}
				
		}
		ModelAndView mv=new ModelAndView("display");
	    mv.addObject("stud",sd);
	    mv.addObject("action", "student");
		return mv;
	}
	
	@RequestMapping("/update")
	public ModelAndView updateStudent(@RequestParam String name,@RequestParam String id,@RequestParam String course) {
		int id1=Integer.parseInt(id);
		Student sd=null;
		for (Student s : sts) {
			if(s.getId()==id1)
			{
				
				
				s.setCourse(course);
				s.setName(name);
				break;
			}
				
		}
		ModelAndView mv=new ModelAndView("Dashboard");
		return mv;
	}
	
}
