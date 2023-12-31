package com.learning.learnspringboot.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.learnspringboot.courses.bean.Course;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
