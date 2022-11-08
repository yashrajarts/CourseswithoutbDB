package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Courses;

@Service
public class CourseServiceImpl implements CourseServices {

	List<Courses> list;
	public CourseServiceImpl()
	{
		list=new ArrayList<>();
		list.add(new Courses(12, "Core Java", "Core Java"));
		list.add(new Courses(14, "Advanced Java", "Advanced Java"));
	}
	
	@Override
	public List<Courses> getCourses()
	{
		return list;
	}

	@Override
	public Courses getCourse(long courseId) {
		Courses c=null;
		for(Courses course:list)
		{
			if(course.getId()==courseId)
			{
				c = course;
				break;
			}
		}
		return c;
	}

	@Override
	public Courses addCourse(Courses course) {
		list.add(course);
		return course;
	}

	@Override
	public Courses updateCourse(Courses course) {
		list.forEach( e -> {
			if(e.getId() == course.getId()){
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
			}
		});
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
		list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		
	}
	
}
