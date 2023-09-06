package com.learning.learnspringboot.courses.controller;

// import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.learnspringboot.courses.bean.Course;
import com.learning.learnspringboot.courses.repository.CourseRepository;

@RestController
public class CourseController {
    @Autowired
    private CourseRepository repository;

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return repository.findAll();
        //System.out.println();
        // return Arrays.asList(new Course(2, "Learn Sprig Boot", "John"),
        // new Course(1, "Learn Microservice", "in28Minutes"), new Course(3, "Java", "No
        // One"),
        // new Course(4, "ewewe", "sdssa"));
    }

    // GET -retrive data by id
    @GetMapping("/courses/{id}")
    public Course getCourseDetails(@PathVariable long id) {
        Optional<Course> course = repository.findById(id);
        if (course.isEmpty()) {
            throw new RuntimeException("Could not find class" + id);
        }
        return course.get();
    }
    // POST- create new resourses

    @PostMapping("/courses")
    public void createCourse(@RequestBody Course course) {
        repository.save(course);
    }

    // PUT-update Course
    @PutMapping("/courses/{id}")
    public void updateCourse(@PathVariable long id, @RequestBody Course course) {
        repository.save(course);
    }

    // DELETE-delete course
    @DeleteMapping("/course/{id}")
    public void deleteCourse(@PathVariable long id) {
        repository.deleteById(id);

    }

}