package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Student;

import java.util.*;

public class StudentService
{
    private final Map<String, Student> students = new HashMap<>();
    private double grade = 0.0;

    public void subscribeStudent( Student student )
    {
        //TODO
        students.put(student.getId(),student);

    }

    public Student findStudent( String studentId )
    {
        //TODO
        if (students.containsKey(studentId)){
            return students.get(studentId);
        }
        return null;
    }

    public boolean showSummary()
    {
        //TODO

        if(!students.isEmpty() ){
           // System.out.println("Enter the studentId:" );
            for( String id: this.students.keySet()){
                Student display = this.students.get(id);
                System.out.println(display);
                displayEnrolledCourses(display);


            }
                return true;

        }
        return false;
    }

    public void displayEnrolledCourses( Student student  ) {
        List<Course> courses = student.getEnrolledCourses();
        if( !courses.isEmpty() ) {
            System.out.println("Enrolled Course");
            courses.forEach(course -> {
                grade = 0.0;
                System.out.println(String.format(course + "Grade: %.1f", grade));
            });
        }
    }


    public void enrollToCourse( String studentId, Course course )
    {
        //TODO
        Student student = students.get(studentId);
        student.enrollToCourse(course);

    }
}
